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
    /**
     * ATRIBUTOS:
     */
    private int id_usuario;
    private String nombre;
    private String pass;
    private String dni;

    /**
     * CONSTRUCTOR VACÍO:
     */
    public Usuario(){}
    
    /**
     * CONSTRUCTOR PARA EL LOGIN:
     * @param nombre
     * @param pass 
     */
    public Usuario(String nombre, String pass){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.pass = pass;
    }
    
    /**
     * CONSTRUCTOR PARA CAMBIAR LA CONTRASEÑA:
     * @param id_usuario
     * @param nombre
     * @param pass 
     */
    public Usuario(int id_usuario, String nombre, String pass){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.pass = pass;
    }

    /**
     * CONSTRUCTOR PARA EL REGISTRO.
     * @param nombre
     * @param pass
     * @param dni 
     */
    public Usuario(String nombre, String pass, String dni) {
        this.nombre = nombre;
        this.pass = pass;
        this.dni = dni;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    /**
     * MÉTODO TO STRING PARA VER LA INFORMACIÓN DEL OBJETO EN UNA LÍNEA.
     * @return 
     */
    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + "Pass: " + this.getPass() + "DNI: " + this.getDni();
    }
    
    /**
     *  Verifica si nuestro nombre de ususario es apto/correcto al contener,
     *  com minimo, 5 letras.
     * @param nombre
     * @return Nos devuelve el estado de la variable "NOMBRECORRECTO"
     *         que puede ser True o False.
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
    
    /**
     * VERIFICA QUE EL DNI TENGA, COMO MÍNIMO, LOS 9 CARÁCTERES CORRESPONDIENTES
     * (8 NÚMEROS Y UNA LETRA).
     * @param dni
     * @return Nos devuelte el estado de la variable "DNIOK"
     *         que puede ser True o False.
     */
    public boolean dniCorrecto(String dni) {
        boolean dniok = false;
        if (dni.length() == 9) {
            dniok = true;
        }
        return dniok;
    }

    
}
