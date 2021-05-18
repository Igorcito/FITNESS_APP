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
public class Ejercicio_Resistencia extends Ejercicio{
    
    /**
     * ATRIBUTOS:
     */
    private int tiempo;
    
    /**
     * CONTRUCTOR VACÍO:
     */
    public Ejercicio_Resistencia () {}
    
    /**
     * CONSTRUCTOR CON PARÁMETROS:
     * @param tiempo
     * @param id_ejercicio
     * @param nombre
     * @param tipo
     * @param zona 
     */
    public Ejercicio_Resistencia (int tiempo, int id_ejercicio, String nombre, String tipo, String zona) {
        
        super (id_ejercicio, nombre, tipo, zona);
        this.tiempo = tiempo;
    }

    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * @param tiempo the tiempo to set
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    
    /**
     * MÉTODO TO STRING PARA VER LA INFORMACIÓN DEL OBJETO EN UNA LÍNEA.
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + "     Tiempo: " + this.getTiempo() + " Min." + "\n";
    } 
    
}
