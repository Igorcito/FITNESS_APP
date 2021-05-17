/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author IGOR
 */
public abstract class Ejercicio {
    
    private int id_ejercicio;
    private String nombre;
    private String tipo;
    private String zona;
    
    //CONSTRUCTORES:------------------------------------------------------------
    public Ejercicio(){}
    
    public Ejercicio(int id_ejercicio, String nombre, String tipo, String zona) {
        this.id_ejercicio = id_ejercicio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.zona = zona;
    }
    
    //GETTERS & SETTERS:--------------------------------------------------------
    public int getId_Ejercicio() {
        return id_ejercicio;
    }

    public void setId_Ejercicio(int id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }
    
    //MÉTODOS:------------------------------------------------------------------
    @Override
    public String toString() {
        return "ID: " + this.id_ejercicio + "     Nombre: " + this.nombre + "     Tipo: " + this.tipo + "     Zona: " + this.zona;
    }

}
