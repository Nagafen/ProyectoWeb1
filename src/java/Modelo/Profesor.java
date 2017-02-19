/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author crist
 */
public class Profesor {
    private int id;
    private char[] nombre;
    private char[] apellido;
    private int ext;

    public Profesor(int id, char[] nombre, char[] apellido, int ext) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ext = ext;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public char[] getApellido() {
        return apellido;
    }

    public void setApellido(char[] apellido) {
        this.apellido = apellido;
    }

    public int getExt() {
        return ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }   
}
