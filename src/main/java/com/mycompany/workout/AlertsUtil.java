/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.workout;

import javafx.scene.control.Alert;

/**
 *
 * @author IGOR
 */
public class AlertsUtil {
    
    /**
     * MÉTODO QUE NOS MUESTRA UN MENSAJE DE ERROR.
     * @param mensaje
     */
    public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }
    
    /**
     * MÉTODO QUE NOS MUESTRA UN MENSAJE DE INFORMACIÓN.
     * @param mensaje
     */
    public static void mostrarInfo(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
