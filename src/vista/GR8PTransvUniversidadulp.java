/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import persistencia.AlumnoData;
import persistencia.Conexion;
import entidades.Alumno;
import java.time.LocalDate;


/**
 *
 * @author Adriana
 */
public class GR8PTransvUniversidadulp {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Conexion conexion = new Conexion();

        
        AlumnoData alumnoData = new AlumnoData(conexion);

        
        Alumno nuevoAlumno = new Alumno(40722588, "Gómez", "Laura", LocalDate.of(1995, 6, 15), true);

        Alumno test=alumnoData.buscarAlumnoPorDni(nuevoAlumno.getDni());
        if(!test.equals(nuevoAlumno)){
        alumnoData.guardarAlumno(nuevoAlumno);
        }
        

        
        System.out.println("Alumno guardado con éxito: " + nuevoAlumno.getIdAlumno());
    }
    
}   



