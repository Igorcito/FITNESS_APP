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
public class Ejercicio_Fuerza extends Ejercicio {
    
    //ATRIBUTOS:
    private int peso;
    
    //CONSTRUCTORES:------------------------------------------------------------
    public Ejercicio_Fuerza () {}
    
    public Ejercicio_Fuerza (int peso, int id_ejercicio, String nombre, String tipo, String zona) {
        
        super (id_ejercicio, nombre, tipo, zona);
        this.peso = peso;
    }
    
    //GETTERS & SETTERS:--------------------------------------------------------
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    //MÉTODOS:------------------------------------------------------------------
    @Override
    public String toString() {
        return super.toString() + "     Peso: " + this.getPeso() + " KG." + "\n";
    } 
    
}
