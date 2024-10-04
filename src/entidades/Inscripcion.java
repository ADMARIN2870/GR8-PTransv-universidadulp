
package entidades;

public class Inscripcion {
    private int idInscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;

    // Constructor vacío
    public Inscripcion() {
    }

    // Constructor con parámetros
    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    // Constructor con ID de inscripción
    public Inscripcion(int idAlumno, int idMateria, double nota) {
        this.alumno = new Alumno();  // Inicializa un nuevo alumno con el ID
        this.alumno.setIdAlumno(idAlumno);  // Asigna el ID al alumno
        this.materia = new Materia();  // Inicializa una nueva materia con el ID
        this.materia.setIdMateria(idMateria);  // Asigna el ID a la materia
        this.nota = nota;
    }

    // Métodos getter y setter
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + '}';
    }
}
