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
public class Ejercicio_Flexibilidad extends Ejercicio{
    
    /**
     * ATRIBUTOS:
     */
    private String intensidad;
    
    /**
     * CONSTRUCTOR VACÍO:
     */
    public Ejercicio_Flexibilidad () {}
    
    /**
     * CONSTRUCTOR CON PARÁMETROS:
     * @param intensidad
     * @param id_ejercicio
     * @param nombre
     * @param tipo
     * @param zona 
     */
    public Ejercicio_Flexibilidad (String intensidad, int id_ejercicio, String nombre, String tipo, String zona) {
        
        super (id_ejercicio, nombre, tipo, zona);
        this.intensidad = intensidad;
    }

    /**
     * @return the intensidad
     */
    public String getIntensidad() {
        return intensidad;
    }

    /**
     * @param intensidad the intensidad to set
     */
    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }
    
    
    
    /**
     * MÉTODO TO STRING PARA VER LA INFORMACIÓN DEL OBJETO EN UNA LÍNEA.
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + "     Intensidad: " + this.getIntensidad() + "\n";
    } 
    
}
