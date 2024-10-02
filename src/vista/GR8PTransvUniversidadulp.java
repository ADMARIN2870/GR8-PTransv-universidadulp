/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
public class GR8PTransvUniversidadulp {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Conexion conexion = new Conexion();
      Scanner leer = new Scanner(System.in);

        
        AlumnoData alumnoData = new AlumnoData(conexion);

        
        Alumno nuevoAlumno = new Alumno(40722588, "Salonia", "Luca", LocalDate.of(1995, 6, 15), true);
               
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
    
}   



