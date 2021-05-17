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
    
    //ATRIBUTOS:
    private String intensidad;
    
    //CONSTRUCTORES:------------------------------------------------------------
    public Ejercicio_Flexibilidad () {}
    
    public Ejercicio_Flexibilidad (String intensidad, int id_ejercicio, String nombre, String tipo, String zona) {
        
        super (id_ejercicio, nombre, tipo, zona);
        this.intensidad = intensidad;
    }
    
    //GETTERS & SETTERS:--------------------------------------------------------
    public String getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(String intensidad) {
        this.intensidad = intensidad;
    }
    
    //MÉTODOS:------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "     Intensidad: " + this.getIntensidad() + "\n";
    } 
    
}
