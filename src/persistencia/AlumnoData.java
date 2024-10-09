
package persistencia;

import entidades.Alumno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AlumnoData {
    private Connection connection = Conexion.getConexion();

    public AlumnoData(Conexion conexion) {
        connection = Conexion.getConexion();
    }

    public AlumnoData() {
    }
    
    public void guardarAlumno(Alumno alumno) {
        
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setInt(1, alumno.getDni());
                statement.setString(2, alumno.getApellido());
                statement.setString(3, alumno.getNombre());
                if (alumno.getFechaNacimiento() != null) {
                    statement.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                } else {
                    statement.setNull(4, Types.DATE);
                }
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
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE idAlumno = ? AND estado = 1"; 
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idAlumno);
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
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el alumno: " + e.getMessage());
        }

        return alumno;
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

                // Verificación si fechaNacimiento es null
                Date fechaNacimientoSql = resultSet.getDate("fechaNacimiento");
                if (fechaNacimientoSql != null) {
                    alumno.setFechaNacimiento(fechaNacimientoSql.toLocalDate());
                } else {
                    alumno.setFechaNacimiento(null);  // Asigna null si no hay fecha de nacimiento
                }

                alumno.setEstado(resultSet.getBoolean("estado"));
                alumnos.add(alumno);
            }
        }catch(NullPointerException e){
            System.out.println("Error NullPointer");
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
     public void eliminarAlumnoPorDni(int dni) {
    String sql = "DELETE FROM alumno WHERE dni = ?";

    try {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, dni);  // Se pasa el ID del alumno a eliminar
            
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
    
    public boolean dniExiste(int dni){
        boolean existencia=true;
        
        String sql ="SELECT dni FROM alumno;";
        try{
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    
                    if(rs.getInt("dni")==(dni)){
                        existencia=false;
                    }
                }
            }
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno " + ex.getMessage());
        }
        return existencia;
    }

   public Alumno buscarAlumno(Object id) {
        if (id instanceof Integer integer) {  // Verifica que el ID sea un número entero
            return buscarAlumnoPorId(integer);  // Llama al método ya implementado para buscar por ID
        } else {
            throw new IllegalArgumentException("El tipo de ID proporcionado no es válido.");
        }
    }

    
    public List<Alumno> listarAlumnos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Alumno buscarAlumnoporIdbuscarAlumnoPorDni(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 

}
