/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/*
package vista;



import persistencia.AlumnoData;
import persistencia.Conexion;
import entidades.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Adriana
 */
/*
public class GR8PTransvUniversidadulp {

/*
 
    /**
     * @param args the command line arguments
     */
    /*
  
    public static void main(String[] args) {
       
      Conexion conexion = new Conexion();
      Scanner leer = new Scanner(System.in);

       
        AlumnoData alumnoData = new AlumnoData(conexion);

        
        Alumno nuevoAlumno = new Alumno(26668376, "Marin", "Adriana", LocalDate.of(1978, 8, 07), true);
               
        alumnoData.guardarAlumno(nuevoAlumno);
        
        System.out.println("Alumno guardado con éxito: " + nuevoAlumno.getIdAlumno());
        System.out.println("Alumno por dni\n"+alumnoData.buscarAlumnoPorDni(nuevoAlumno.getDni()));
        
        ArrayList<Alumno>alumnos =alumnoData.obtenerAlumnos();
        System.out.println("Lista completa de alumnos");
        for(Alumno a: alumnos){
            System.out.println(a);
        }
        System.out.println("Presione 's' Si desea eliminar todos los alumnos");
        
        String s = leer.nextLine();
        if(s.equalsIgnoreCase("s")){
            
            for(Alumno a: alumnos){
                
                alumnoData.eliminarAlumnoPorId(a.getIdAlumno());
            }
        }
        }  


package vista;

import persistencia.MateriaData;
import persistencia.Conexion;
import entidades.Materia;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adriana
 */
/*
public class GR8PTransvUniversidadulp {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Scanner leer = new Scanner(System.in);

        
        MateriaData materiaData = new MateriaData(conexion);

        
        Materia nuevaMateria = new Materia("Matemáticas", 2024, true);
        materiaData.guardarMateria(nuevaMateria);

        
        System.out.println("Materia guardada con éxito: " + nuevaMateria.getIdMateria());

        
        System.out.println("Ingrese el ID de la materia a buscar:");
        int idMateria = leer.nextInt();
        Materia materiaEncontrada = materiaData.buscarMateria(idMateria);
        System.out.println("Materia encontrada: " + materiaEncontrada);

        
        List<Materia> materias = materiaData.listarMaterias();
        System.out.println("Lista completa de materias:");
        for (Materia m : materias) {
            System.out.println(m);
        }

        
        System.out.println("Presione 's' si desea eliminar todas las materias");
        leer.nextLine(); 
        String s = leer.nextLine();
        if (s.equalsIgnoreCase("s")) {
            for (Materia m : materias) {
                materiaData.eliminarMateria(m.getIdMateria());
                System.out.println("Materia eliminada con éxito: " + m.getIdMateria());
            }
        }
    }
}
*/

package vista;

import persistencia.InscripcionData;
import persistencia.Conexion;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Adriana
 */
public class GR8PTransvUniversidadulp {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Scanner leer = new Scanner(System.in);

        // Instanciar la clase InscripcionData para trabajar con las inscripciones
        InscripcionData inscripcionData = new InscripcionData(conexion);

        // Guardar una nueva inscripción
        System.out.println("Ingrese el ID del alumno para inscribir:");
        int idAlumno = leer.nextInt();
        System.out.println("Ingrese el ID de la materia:");
        int idMateria = leer.nextInt();
        Inscripcion nuevaInscripcion = new Inscripcion(idAlumno, idMateria, 0.0);
        inscripcionData.guardarInscripcion(nuevaInscripcion);
        System.out.println("Inscripción guardada con éxito!");

        // Listar todas las inscripciones
        List<Inscripcion> inscripciones = inscripcionData.obtenerInscripciones();
        System.out.println("Lista completa de inscripciones:");
        for (Inscripcion i : inscripciones) {
            System.out.println(i);
        }

        // Obtener inscripciones por alumno
        System.out.println("Ingrese el ID del alumno para listar sus inscripciones:");
        int idAlumnoParaBuscar = leer.nextInt();
        List<Inscripcion> inscripcionesPorAlumno = inscripcionData.obtenerInscripcionesPorAlumno(idAlumnoParaBuscar);
        System.out.println("Inscripciones del alumno:");
        for (Inscripcion inscripcion : inscripcionesPorAlumno) {
            System.out.println(inscripcion);
        }

        // Obtener materias cursadas por un alumno
        System.out.println("Materias cursadas por el alumno:");
        List<Materia> materiasCursadas = inscripcionData.obtenerMateriasCursadas(idAlumnoParaBuscar);
        for (Materia materia : materiasCursadas) {
            System.out.println(materia);
        }

        // Obtener materias NO cursadas por un alumno
        System.out.println("Materias NO cursadas por el alumno:");
        List<Materia> materiasNoCursadas = inscripcionData.obtenerMateriasNOCursadas(idAlumnoParaBuscar);
        for (Materia materia : materiasNoCursadas) {
            System.out.println(materia);
        }

        // Actualizar la nota de una inscripción
        System.out.println("Ingrese el ID del alumno y de la materia para actualizar la nota:");
        int idAlumnoNota = leer.nextInt();
        int idMateriaNota = leer.nextInt();
        System.out.println("Ingrese la nueva nota:");
        double nuevaNota = leer.nextDouble();
        inscripcionData.actualizarNota(idAlumnoNota, idMateriaNota, nuevaNota);
        System.out.println("Nota actualizada con éxito!");

        // Eliminar inscripción de un alumno en una materia
        System.out.println("Ingrese el ID del alumno y de la materia para eliminar la inscripción:");
        int idAlumnoEliminar = leer.nextInt();
        int idMateriaEliminar = leer.nextInt();
        inscripcionData.borrarInscripcionMateriaAlumno(idAlumnoEliminar, idMateriaEliminar);
        System.out.println("Inscripción eliminada con éxito!");

        // Obtener alumnos inscritos en una materia
        System.out.println("Ingrese el ID de la materia para listar los alumnos inscritos:");
        int idMateriaParaAlumnos = leer.nextInt();
        List<Alumno> alumnosInscritos = inscripcionData.obtenerAlumnosXMateria(idMateriaParaAlumnos);
        System.out.println("Alumnos inscritos en la materia:");
        for (Alumno alumno : alumnosInscritos) {
            System.out.println(alumno);
        }
    }
}
