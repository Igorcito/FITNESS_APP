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
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String pass;
    private String dni;

//    CONSTRUCTORES:------------------------------------------------------------
//    VACIO:
    public Usuario(){}
    
//    LOGIN:
    public Usuario(String nombre, String pass){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.pass = pass;
    }
    
//    CAMBIAR PASS:
    public Usuario(int id_usuario, String nombre, String pass){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.pass = pass;
    }

//    REGISTER:
    public Usuario(String nombre, String pass, String dni) {
        this.nombre = nombre;
        this.pass = pass;
        this.dni = dni;
    }
    
    
//    GETTERS & SETTERS:--------------------------------------------------------
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
//    MÉTODOS:------------------------------------------------------------------
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "Pass: " + this.pass + "DNI: " + this.dni;
    }
    
    /**
     *  Verifica si nuestro nombre de ususario es apto/correcto al contener,
     *  com minimo, 5 letras.
     * @param nombre
     * @return Nos devuelve el estado de la variable "NOMBRECORRECTO".
     */
    public boolean NombreCorrecto(String nombre) {
        //return nombre.length() >= 5; --- Es lo mismo el el if de abajo.

        boolean nombreok = false;
        if (nombre.length() >= 5) {
            nombreok = true;
        }
        return nombreok;
    }
    
    /**
     * Verifica si la contraseña que hemos introducido es apta según el
     * criterio que hemos definido.
     * @param password
     * @return Nos devuelte el estado de la variable "PASSOK"
     *         que puede ser True o False.
     */
    public boolean PassCorrecta(String password) {
        boolean passok = false;
        if (password.length() > 7) {
            if (password.matches(".*[A-Z].*")) {
                passok = true;
            }
        }
        return passok;
    }
    
    public boolean dniCorrecto(String dni) {
        boolean dniok = false;
        if (dni.length() == 9) {
            dniok = true;
        }
        return dniok;
    }

    
}
