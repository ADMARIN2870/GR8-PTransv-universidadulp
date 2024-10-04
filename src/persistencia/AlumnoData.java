/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
/**
 *
 * @author Adriana
 */
import entidades.Alumno;
import java.sql.*;
import java.util.ArrayList;

public class AlumnoData {
    private final Connection connection;

    public AlumnoData(Conexion conexion) {
        connection = Conexion.getConexion();
    }

    public AlumnoData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void guardarAlumno(Alumno alumno) {
        
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, alumno.getDni());
                statement.setString(2, alumno.getApellido());
                statement.setString(3, alumno.getNombre());
                statement.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                statement.setBoolean(5, alumno.isEstado());
                
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    alumno.setIdAlumno(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al Guardar el Alumno: " + e.getMessage());
        }
    }

    public Alumno buscarAlumnoPorId(int idAlumno) {
    Alumno alumno = null;  // Se inicializa como null para manejar el caso en que no se encuentre el alumno
    String sql = "SELECT * FROM alumno WHERE idAlumno = ? AND estado = 1"; // Solo busca alumnos activos

    try {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idAlumno);  // Se pasa el ID como parámetro en la consulta
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(resultSet.getInt("idAlumno"));
                alumno.setDni(resultSet.getInt("dni"));
                alumno.setApellido(resultSet.getString("apellido"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(resultSet.getBoolean("estado"));
            } else {
                System.out.println("No se encontró un alumno con ese ID.");
            }
        } // Se pasa el ID como parámetro en la consulta
    } catch (SQLException e) {
        System.out.println("Error al buscar el alumno: " + e.getMessage());
    }

    return alumno;  // Devuelve el alumno encontrado o null si no se encontró
}

    public Alumno buscarAlumnoPorDni(int dni) {
    Alumno alumno = null;
    String sql = "SELECT * FROM alumno WHERE dni = ? AND estado = 1";  // Solo busca alumnos activos

    try {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dni);  // Se pasa el DNI como parámetro en la consulta
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(resultSet.getInt("idAlumno"));
                alumno.setDni(resultSet.getInt("dni"));
                alumno.setApellido(resultSet.getString("apellido"));
                alumno.setNombre(resultSet.getString("nombre"));
                alumno.setFechaNacimiento(resultSet.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(resultSet.getBoolean("estado"));
            } else {
                System.out.println("No se encontró un alumno con ese DNI.");
            }
        } // Se pasa el DNI como parámetro en la consulta
    } catch (SQLException e) {
        System.out.println("Error al buscar el alumno: " + e.getMessage());
    }

    return alumno;  // Devuelve el alumno encontrado o null si no se encontró
}

    public ArrayList<Alumno> obtenerAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
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
            System.out.println("Error al obtener los alumnos: " + e.getMessage());
        }
        return alumnos;
    }
    
    public void modificarAlumno(Alumno alumno) {
    String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ?, estado = ? WHERE idAlumno = ?";
    try {
        PreparedStatement statement;
        statement = connection.prepareStatement(sql);
        statement.setInt(1, alumno.getDni());
        statement.setString(2, alumno.getApellido());
        statement.setString(3, alumno.getNombre());
        statement.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
        statement.setBoolean(5, alumno.isEstado());
        statement.setInt(6, alumno.getIdAlumno()); // Aquí se pasa el ID del alumno que se quiere modificar

        int filasAfectadas = statement.executeUpdate();
        if (filasAfectadas > 0) {
            System.out.println("Alumno modificado con éxito.");
        } else {
            System.out.println("No se encontró un alumno con ese ID.");
        }
        statement.close();
    } catch (SQLException e) {
        System.out.println("Error al modificar el alumno: " + e.getMessage());
    }
}
    
    public void eliminarAlumnoPorId(int idAlumno) {
    String sql = "DELETE FROM alumno WHERE idAlumno = ?";

    try {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idAlumno);  // Se pasa el ID del alumno a eliminar
            
            int filasAfectadas = statement.executeUpdate();  // Ejecuta la eliminación
            
            if (filasAfectadas > 0) {
                System.out.println("Alumno eliminado con éxito.");
            } else {
                System.out.println("No se encontró un alumno con ese ID.");
            }
        } // Se pasa el ID del alumno a eliminar
    } catch (SQLException e) {
        System.out.println("Error al eliminar el alumno: " + e.getMessage());
    }
}

    public Alumno buscarAlumnoPorNombreApellido(String nombreAlumno, String apellidoAlumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
