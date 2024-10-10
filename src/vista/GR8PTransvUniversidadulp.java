
package vista;
/*
import entidades.*;
import java.util.List;
import persistencia.AlumnoData;
import persistencia.Conexion;
import persistencia.InscripcionData;
import persistencia.MateriaData;

public class GR8PTransvUniversidadulp {
    public static void main(String[] args) {
        // 1. Establecer la conexión a la base de datos
        Conexion conexion = new Conexion();

        // Verificar si la conexión se ha establecido correctamente
        if (conexion != null) {
            System.out.println("Conexión exitosa a la base de datos.");

            // Crear las instancias de los objetos Data (gestión de alumnos, materias, inscripciones)
            AlumnoData alumnoData = new AlumnoData(conexion);
            MateriaData materiaData = new MateriaData(conexion);
            InscripcionData inscripcionData = new InscripcionData(conexion, materiaData, alumnoData);

            // 2. Guardar un nuevo alumno
            Alumno nuevoAlumno = new Alumno("Juancito", 123417111, "Pereira");
            alumnoData.guardarAlumno(nuevoAlumno);
            System.out.println("Alumno guardado: " + nuevoAlumno);

            // 3. Buscar un alumno por ID
            Alumno alumnoEncontrado = alumnoData.buscarAlumnoPorId(nuevoAlumno.getIdAlumno());  // Cambiado a buscar por ID
            System.out.println("Alumno encontrado: " + alumnoEncontrado);

            // 4. Listar todos los alumnos
            System.out.println("\nListado de todos los alumnos:");
            List<Alumno> alumnos = alumnoData.obtenerAlumnos();  // Asumiendo que implementarás este método
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
            }

            // 5. Guardar una nueva materia
            Materia nuevaMateria = new Materia("Matemáticas", 2024);
            materiaData.guardarMateria(nuevaMateria);
            System.out.println("Materia guardada: " + nuevaMateria);

            // 6. Buscar una materia por ID
            Materia materiaEncontrada = materiaData.buscarMateria(nuevaMateria.getIdMateria());
            System.out.println("Materia encontrada: " + materiaEncontrada);

            // 7. Listar todas las materias
            System.out.println("\nListado de todas las materias:");
            List<Materia> materias = materiaData.listarMaterias();
            for (Materia materia : materias) {
                System.out.println(materia);
            }

            // 8. Inscribir al alumno en una materia
            Inscripcion nuevaInscripcion = new Inscripcion(nuevoAlumno, nuevaMateria, 0);  // Inicialmente sin nota
            inscripcionData.guardarInscripcion(nuevaInscripcion);
            System.out.println("Inscripción guardada: " + nuevaInscripcion);

            // 9. Obtener todas las inscripciones de un alumno
            System.out.println("\nInscripciones del alumno con ID " + nuevoAlumno.getIdAlumno() + ":");
            List<Inscripcion> inscripcionesAlumno = inscripcionData.obtenerInscripcionesPorAlumno(nuevoAlumno.getIdAlumno());
            for (Inscripcion insc : inscripcionesAlumno) {
                System.out.println(insc);
            }

            // 10. Actualizar la nota de una inscripción
            inscripcionData.actualizarNota(nuevoAlumno.getIdAlumno(), nuevaMateria.getIdMateria(), 8.5);
            System.out.println("Nota actualizada para el alumno " + nuevoAlumno.getIdAlumno() + " en la materia " + nuevaMateria.getIdMateria());

            // 11. Eliminar una inscripción de un alumno en una materia
            inscripcionData.borrarInscripcionMateriaAlumno(nuevoAlumno.getIdAlumno(), nuevaMateria.getIdMateria());
            System.out.println("Inscripción eliminada para el alumno " + nuevoAlumno.getIdAlumno() + " en la materia " + nuevaMateria.getIdMateria());

            // 12. Listar alumnos por materia
            System.out.println("\nListado de alumnos por materia (ID de la materia: " + nuevaMateria.getIdMateria() + "):");
            List<Alumno> alumnosPorMateria = inscripcionData.obtenerAlumnosxMateria(nuevaMateria.getIdMateria());
            for (Alumno alumno : alumnosPorMateria) {
                System.out.println(alumno);
            }

        } else {
            System.out.println("No se pudo establecer conexión con la base de datos.");
        }
    }
}
*/
import javax.swing.*;

public class GR8PTransvUniversidadulp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana Principal");
        JDesktopPane desktopPane = new JDesktopPane();
        
        frame.setSize(528,394);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(desktopPane);
        frame.setVisible(true);

        // Crear y centrar el JInternalFrame
        ViewAlumnosXMateria internalFrame = new ViewAlumnosXMateria();
        desktopPane.add(internalFrame);
        
        internalFrame.setSize(400, 300);
        int x = (desktopPane.getWidth() - internalFrame.getWidth()) / 2;
        int y = (desktopPane.getHeight() - internalFrame.getHeight()) / 2;
        internalFrame.setLocation(x, y);
        internalFrame.setVisible(true);
    }
}
