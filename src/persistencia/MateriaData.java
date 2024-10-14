

package persistencia;

import entidades.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MateriaData {
    
    private Connection connection = Conexion.getConexion();
    private Object Nombre_materia;

    public MateriaData(Conexion conexion) {
        connection = Conexion.getConexion();
    }

    public MateriaData() {
       
    }

    // Método para guardar una nueva materia en la base de datos
    public void guardarMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre_materia, año, estado) VALUES (?, ?, ?)";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, materia.getNombre_materia());
                statement.setInt(2, materia.getAnio());
                statement.setBoolean(3, materia.isEstado());
                
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    materia.setIdMateria(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la materia: " + e.getMessage());
        }
    }

    // Método para buscar una materia por su ID
    public Materia buscarMateria(int id) {
        Materia materia = null;
        String sql = "SELECT * FROM materia WHERE idMateria = ? AND estado = 1"; // Solo materias activas
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    materia = new Materia();
                    materia.setIdMateria(resultSet.getInt("idMateria"));
                    materia.setNombre_materia(resultSet.getString("Nombre_materia"));
                    materia.setAnio(resultSet.getInt("año"));
                    materia.setEstado(resultSet.getBoolean("estado"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la materia: " + e.getMessage());
        }

        return materia;
    }

    // Método para modificar una materia existente
    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET Nombre_materia = ?, año = ?, estado = ? WHERE idMateria = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, materia.getNombre_materia());
                statement.setInt(2, materia.getAnio());
                statement.setBoolean(3, materia.isEstado());
                statement.setInt(4, materia.getIdMateria());
                
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Materia modificada con éxito.");
                } else {
                    System.out.println("No se encontró una materia con ese ID.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar la materia: " + e.getMessage());
        }
    }

    // Método para eliminar (borrar) una materia por su ID
    public void eliminarMateria(int id) {
        String sql = "DELETE FROM materia WHERE idMateria = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                
                int filasAfectadas = statement.executeUpdate();
                if (filasAfectadas > 0) {
                    System.out.println("Materia eliminada con éxito.");
                } else {
                    System.out.println("No se encontró una materia con ese ID.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar la materia: " + e.getMessage());
        }
    }

    // Método para listar todas las materias
    public List<Materia> listarMaterias() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT * FROM materia WHERE estado = 1"; // Solo materias activas
        try {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                
                while (resultSet.next()) {
                    Materia materia = new Materia();
                    materia.setIdMateria(resultSet.getInt("idMateria"));
                    materia.setNombre_materia(resultSet.getString("Nombre_materia"));
                    materia.setAnio(resultSet.getInt("año"));
                    materia.setEstado(resultSet.getBoolean("estado"));
                    materias.add(materia);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar las materias: " + e.getMessage());
        }

        return materias;
    }

     public boolean materiaExiste(String nombreMateria, int año){
        boolean existencia=true;
        
        String sql ="SELECT Nombre_materia, año FROM materia;";
        try{
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    if(rs.getString("Nombre_materia").equals(Nombre_materia)&&rs.getInt("año")==año){
                        existencia=false;
                    }
                }
            }
        
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla materia " + ex.getMessage());
        }
        return existencia;
    }
}
