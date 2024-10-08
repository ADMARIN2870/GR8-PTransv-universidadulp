package persistencia;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static persistencia.Conexion.getConexion;

public class InscripcionData {
    private final Connection connection;
    private MateriaData matData;
    private AlumnoData aluData;

    // Constructor principal que recibe una conexión y crea instancias de MateriaData y AlumnoData
    public InscripcionData(Conexion conexion) {
        connection = Conexion.getConexion();
        matData = new MateriaData(conexion);
        aluData = new AlumnoData(conexion);
    }

    // Constructor vacío implementado (si es necesario)
    public InscripcionData() {
        this.connection = Conexion.getConexion(); // Inicializa la conexión
        this.matData = new MateriaData((Conexion) getConexion()); // Inicializa MateriaData
        this.aluData = new AlumnoData((Conexion) getConexion()); // Inicializa AlumnoData
    }

    // Constructor con parámetros (si necesitas usarlo)
    public InscripcionData(Conexion conexion, MateriaData materiaData, AlumnoData alumnoData) {
        this.connection = getConexion();
        this.matData = materiaData;
        this.aluData = alumnoData;
    }

    // Método para guardar una inscripción en la base de datos
    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?, ?, ?)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, insc.getAlumno().getIdAlumno());
                statement.setInt(2, insc.getMateria().getIdMateria());
                statement.setDouble(3, insc.getNota());
                
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    insc.setIdInscripcion(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la inscripción: " + e.getMessage());
        }
    }

    // Método para obtener todas las inscripciones
    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Inscripcion inscripcion = new Inscripcion();
                    inscripcion.setIdInscripcion(resultSet.getInt("idInscripcion"));
                    Alumno alumno = aluData.buscarAlumnoPorId(resultSet.getInt("idAlumno"));
                    Materia materia = matData.buscarMateria(resultSet.getInt("idMateria"));
                    inscripcion.setAlumno(alumno);
                    inscripcion.setMateria(materia);
                    inscripcion.setNota(resultSet.getDouble("nota"));
                    inscripciones.add(inscripcion);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener inscripciones: " + e.getMessage());
        }
        return inscripciones;
    }

    // Método para obtener inscripciones de un alumno específico
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idAlumno);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Inscripcion inscripcion = new Inscripcion();
                    inscripcion.setIdInscripcion(resultSet.getInt("idInscripcion"));
                    Alumno alumno = aluData.buscarAlumnoPorId(resultSet.getInt("idAlumno"));
                    Materia materia = matData.buscarMateria(resultSet.getInt("idMateria"));
                    inscripcion.setAlumno(alumno);
                    inscripcion.setMateria(materia);
                    inscripcion.setNota(resultSet.getDouble("nota"));
                    inscripciones.add(inscripcion);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener inscripciones por alumno: " + e.getMessage());
        }
        return inscripciones;
    }

    // Método para obtener materias cursadas por un alumno
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT m.* FROM materia m JOIN inscripcion i ON m.idMateria = i.idMateria WHERE i.idAlumno = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idAlumno);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Materia materia = new Materia();
                    materia.setIdMateria(resultSet.getInt("idMateria"));
                    materia.setNombre_materia(resultSet.getString("nombre"));
                    materia.setAnio(resultSet.getInt("anio"));
                    materia.setEstado(resultSet.getBoolean("estado"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener materias cursadas: " + e.getMessage());
        }
        return materias;
    }

    // Método para obtener materias NO cursadas por un alumno
    public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idAlumno);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Materia materia = new Materia();
                    materia.setIdMateria(resultSet.getInt("idMateria"));
                    materia.setNombre_materia(resultSet.getString("nombre"));
                    materia.setAnio(resultSet.getInt("anio"));
                    materia.setEstado(resultSet.getBoolean("estado"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener materias no cursadas: " + e.getMessage());
        }
        return materias;
    }

    // Método para borrar una inscripción
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idAlumno);
                statement.setInt(2, idMateria);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al borrar inscripción: " + e.getMessage());
        }
    }

    // Método para actualizar la nota de una inscripción
    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDouble(1, nota);
                statement.setInt(2, idAlumno);
                statement.setInt(3, idMateria);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la nota: " + e.getMessage());
        }
    }

    // Método para obtener alumnos inscritos en una materia específica
    public List<Alumno> obtenerAlumnosXMateria(int idMateria) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT a.* FROM alumno a JOIN inscripcion i ON a.idAlumno = i.idAlumno WHERE i.idMateria = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idMateria);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setIdAlumno(resultSet.getInt("idAlumno"));
                    alumno.setDni(resultSet.getInt("dni"));
                    alumno.setApellido(resultSet.getString("apellido"));
                    alumno.setNombre(resultSet.getString("nombre"));
                    alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toLocalDate());
                    alumno.setEstado(resultSet.getBoolean("estado"));
                    alumnos.add(alumno);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener alumnos por materia: " + e.getMessage());
        }
        return alumnos;
    }

    // Método obtenerAlumnosxMateria ya implementado
    public List<Alumno> obtenerAlumnosxMateria(int idMateria) {
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT a.* FROM alumno a JOIN inscripcion i ON a.idAlumno = i.idAlumno WHERE i.idMateria = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idMateria);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Alumno alumno = new Alumno();
                    alumno.setIdAlumno(resultSet.getInt("idAlumno"));
                    alumno.setDni(resultSet.getInt("dni"));
                    alumno.setApellido(resultSet.getString("apellido"));
                    alumno.setNombre(resultSet.getString("nombre"));
                    alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toLocalDate());
                    alumno.setEstado(resultSet.getBoolean("estado"));
                    alumnos.add(alumno);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener alumnos por materia: " + e.getMessage());
        }
        return alumnos;
    }
}
