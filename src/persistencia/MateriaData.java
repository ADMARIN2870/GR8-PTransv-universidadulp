/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Adriana
 */

package persistencia;

import entidades.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaData {
    private final Connection connection;

    public MateriaData(Conexion conexion) {
        connection = Conexion.getConexion();
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
                    materia.setNombre_materia(resultSet.getString("nombre_materia"));
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
        String sql = "UPDATE materia SET nombre_materia = ?, año = ?, estado = ? WHERE idMateria = ?";
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
                    materia.setNombre_materia(resultSet.getString("nombre_materia"));
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

    public Materia buscarMateriaPorNombre(String nombreMateria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
