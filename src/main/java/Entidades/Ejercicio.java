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
    
    /**
     * ATRIBUTOS DE CLASE ABSTRACTA:
     */
    private int id_ejercicio;
    private String nombre;
    private String tipo;
    private String zona;
    
    /**
     * CONSTRUCTOR VACÍO:
     */
    public Ejercicio(){}
    
    /**
     * CONSTRUCTOR CON PARÁMETROS:
     * @param id_ejercicio
     * @param nombre
     * @param tipo
     * @param zona 
     */
    public Ejercicio(int id_ejercicio, String nombre, String tipo, String zona) {
        this.id_ejercicio = id_ejercicio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.zona = zona;
    }
    
    /**
     * @return the id_ejercicio
     */
    public int getId_ejercicio() {
        return id_ejercicio;
    }

    /**
     * @param id_ejercicio the id_ejercicio to set
     */
    public void setId_ejercicio(int id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }
    
    /**
     * MÉTODO TO STRING PARA VER LA INFORMACIÓN DEL OBJETO EN UNA LÍNEA.
     * @return 
     */
    @Override
    public String toString() {
        return "ID: " + this.getId_ejercicio() + "     Nombre: " + this.getNombre() + "     Tipo: " + this.getTipo() + "     Zona: " + this.getZona();
    }

}
