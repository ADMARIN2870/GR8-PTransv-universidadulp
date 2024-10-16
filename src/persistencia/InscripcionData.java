package persistencia;

import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static persistencia.Conexion.getConexion;

public class InscripcionData {
    private final Connection connection;
  //  private MateriaData matData;
    private MateriaData matData =new MateriaData();
    //private AlumnoData aluData;
        private AlumnoData aluData = new AlumnoData();

    

    // Constructor principal que recibe una conexión y crea instancias de MateriaData y AlumnoData
    public InscripcionData(Conexion conexion) {
        connection = Conexion.getConexion();
  
    }

    // Constructor vacío implementado (si es necesario)
    public InscripcionData() {
        this.connection = Conexion.getConexion(); // Inicializa la conexión
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
    
    //reversionar este metodo para lo que necesito
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
                    inscripcion.setIdInscripcion(resultSet.getInt("idInscripto"));
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
    //METODO LUCA
    public List<Inscripcion>obtenerInscripcionesPorIdAlumno(int idAlumno){
        ArrayList<Inscripcion> cursadas = new ArrayList<>();
        
        String sql = "SELECT * FROM inscripcion WHERE idAlumno= ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            
            ResultSet rs=ps.executeQuery();//Es Query por que es un select y no una modificacion
            
            while(rs.next()){
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alumno =  aluData.buscarAlumnoPorId(rs.getInt("idAlumno"));//Para recuperar el numbre del alumno y no solo el id
                Materia materia = matData.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(rs.getDouble("nota"));
                
                cursadas.add(inscripcion);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion."+ex.getMessage());
        }
        
        return cursadas;
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
                    materia.setNombre_materia(resultSet.getString("nombre_materia"));
                    materia.setAnio(resultSet.getInt("año"));
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
    String sql = "SELECT idmateria, Nombre_materia, año FROM materia WHERE idmateria NOT IN (SELECT idmateria FROM inscripcion WHERE idalumno = ?)";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Materia materia = new Materia();
            materia.setIdMateria(rs.getInt("idmateria"));
            materia.setNombre_materia(rs.getString("Nombre_materia"));
            materia.setAnio(rs.getInt("año"));
            materias.add(materia);
        }
    } catch (SQLException ex) {
        System.out.println("Error al obtener materias no cursadas: " + ex.getMessage());
    }
    return materias;
}


    // Método para Anular una inscripción
  public void AnularInscripcion(int idAlumno, int idMateria) {
    String sql = "DELETE FROM inscripcion WHERE idalumno = ? AND idmateria = ?";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ps.setInt(2, idMateria);
        ps.executeUpdate();
    } catch (SQLException ex) {
        System.out.println("Error al anular la inscripción: " + ex.getMessage());
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
