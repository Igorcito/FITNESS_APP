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
    
    /**
     * ATRIBUTOS:
     */
    private int peso;
    
    /**
     * CONSTRUCTOR VACÍO:
     */
    public Ejercicio_Fuerza () {}
    
    /**
     * CONSTRUCTOR CON PARÁMETROS:
     * @param peso
     * @param id_ejercicio
     * @param nombre
     * @param tipo
     * @param zona 
     */
    public Ejercicio_Fuerza (int peso, int id_ejercicio, String nombre, String tipo, String zona) {
        
        super (id_ejercicio, nombre, tipo, zona);
        this.peso = peso;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    /**
     * MÉTODO TO STRING PARA VER LA INFORMACIÓN DEL OBJETO EN UNA LÍNEA.
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + "     Peso: " + this.getPeso() + " KG." + "\n";
    } 
    
}
