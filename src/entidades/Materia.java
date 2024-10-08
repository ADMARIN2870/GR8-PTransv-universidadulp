
package entidades;

public class Materia {
    private int idMateria;
    private String nombre_materia;
    private int anio;
    private boolean estado;

    // Constructor vacío
    public Materia() {
    }

    // Constructor con parámetros
    public Materia(String nombre_materia, int anio, boolean estado) {
        this.nombre_materia = nombre_materia;
        this.anio = anio;
        this.estado = estado;
    }


    public Materia(String nombre_materia, int anio) {
        this.nombre_materia = nombre_materia;
        this.anio = anio;
        this.estado = true;
    }

    public Materia(int idMateria, String nombre_materia, int anio, boolean estado) {
        this.idMateria = idMateria;
        this.nombre_materia = nombre_materia;
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
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
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
        return "Materia{" + "idMateria=" + idMateria + ", nombre_materia='" + nombre_materia + '\'' + ", anio=" + anio + ", estado=" + estado + '}';
    }

    public void setNombre_Materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    }
