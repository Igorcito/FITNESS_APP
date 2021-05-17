/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.workout;

import Entidades.Usuario;
import com.mycompany.workout.DAOs.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author IGOR
 */
public class PassController {

    @FXML
    private TextField User;
    @FXML
    private TextField Newpass;

    @FXML
    private void cambiarContrasenia() throws ClassNotFoundException, IOException, SQLException {
        UsuarioDAO Usuario = new UsuarioDAO();
        Usuario Usuid = new Usuario();
        
        Usuario.conectar();
        
        String nombre = User.getText();
        Usuid = Usuario.cogerUsuarioPorNombre(User.getText());
        
        if (Usuario.usuarioExistente(nombre)) {
            try {
                Usuario.UpdatePass(Usuid.getId_usuario(), Newpass.getText());
                AlertsUtil.mostrarInfo("Se han modificado tus datos");
            } catch (SQLException sqle) {
                AlertsUtil.mostrarError("Error al conectar con la base de datos" + sqle.getMessage());
            } finally {
                Usuario.desconectar();
            }
        } else {
            AlertsUtil.mostrarError("No se ha podido cambiar la contraseña");
        }

    }

    @FXML
    private void PassToSecondary() throws IOException, SQLException {
    App.setRoot("Secondary_1");
    }
    
}
