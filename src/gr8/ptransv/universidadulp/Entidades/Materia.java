/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr8.ptransv.universidadulp.Entidades;

/**
 *
 * @author Adriana
 */
public class Materia {
    private int idMateria;
    private String nombreMateria;
    private int año;
    private boolean estado;

    public Materia(int idMateria, String nombreMateria, int año, boolean estado) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.año = año;
        this.estado = estado;
    }

    public Materia(String nombreMateria, int año, boolean estado) {
        this.nombreMateria = nombreMateria;
        this.año = año;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombreMateria=" + nombreMateria + ", a\u00f1o=" + año + '}';
    }
   }
    
