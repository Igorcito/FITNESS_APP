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
    
    //ATRIBUTOS:
    private int tiempo;
    
    //CONSTRUCTORES:------------------------------------------------------------
    public Ejercicio_Resistencia () {}
    
    public Ejercicio_Resistencia (int tiempo, int id_ejercicio, String nombre, String tipo, String zona) {
        
        super (id_ejercicio, nombre, tipo, zona);
        this.tiempo = tiempo;
    }
    
    //GETTERS & SETTERS:--------------------------------------------------------
    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    //MÉTODOS:------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "     Tiempo: " + this.getTiempo() + " Min." + "\n";
    } 
    
}
