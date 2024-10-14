
package entidades;

public class Materia {
    private int idMateria;
    private String Nombre_materia;
    private int anio;
    private boolean estado;

    // Constructor vacío
    public Materia() {
    }

    // Constructor con parámetros
    public Materia(String nombre_materia, int anio, boolean estado) {
        this.Nombre_materia = nombre_materia;
        this.anio = anio;
        this.estado = estado;
    }


    public Materia(String nombre_materia, int anio) {
        this.Nombre_materia = nombre_materia;
        this.anio = anio;
        this.estado = true;
    }

    public Materia(int idMateria, String nombre_materia, int anio, boolean estado) {
        this.idMateria = idMateria;
        this.Nombre_materia = nombre_materia;
        this.anio = anio;
        this.estado = estado;
    }
    

    

    // Métodos getter y setter para cada atributo
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre_materia() {
        return Nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.Nombre_materia = nombre_materia;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return Nombre_materia+" "+anio+", ID: "+idMateria;
    }

    public void setNombre_Materia(String nombre_materia) {
        this.Nombre_materia = nombre_materia;
    }

    public int getidMateria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getnombre_materia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    }
