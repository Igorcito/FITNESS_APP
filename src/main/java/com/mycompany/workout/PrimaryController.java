package com.mycompany.workout;

import Entidades.Usuario;
import com.mycompany.workout.DAOs.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary_1");
    }

    @FXML
    private ImageView imagenlogin;

    @FXML
    private Label errorLDatos;

    @FXML
    public void loadImage() {
        Image img = new Image(getClass().getResourceAsStream("/Images/Workout3.png"));
        imagenlogin.setImage(img);
    }

    //Campos de relleno del REGISTRO:-------------------------------------------
    @FXML
    private TextField rnombre;
    @FXML
    private PasswordField rpass;
    @FXML
    private TextField rdni;

    @FXML
    private void Registro() throws SQLException {
        UsuarioDAO Usuario = new UsuarioDAO();
        Usuario usu = new Usuario();

        boolean pruebanombre = false;
        boolean pruebapass = false;
        boolean pruebadni = false;

        if (usu.NombreCorrecto(rnombre.getText())) {
            pruebanombre = true;
        } else {
            pruebanombre = false;
            AlertsUtil.mostrarError("El nombre debe de tener, como mínimo, 5 caracteres");
        }

        if (usu.PassCorrecta(rpass.getText())) {
            pruebapass = true;
        } else {
            pruebapass = false;
            AlertsUtil.mostrarError("La contraseña debe tener una letra mayúscula y más de 7 caracteres.");
        }

        if (usu.dniCorrecto(rdni.getText())) {
            pruebadni = true;
        } else {
            pruebadni = false;
            AlertsUtil.mostrarError("El DNI introducido es erróneo.");
        }

        if (pruebanombre && pruebapass && pruebadni) {
            try {
                Usuario.conectar();
                usu = new Usuario(rnombre.getText(), rpass.getText(), rdni.getText());
                Usuario.InsertarUsuario(usu);
                AlertsUtil.mostrarInfo("Usuario registrado con éxito.");
            } catch (SQLException sqle) {
                AlertsUtil.mostrarError("1. Error al conectar con la base de datos" + sqle.getMessage());
            } catch (ClassNotFoundException ex) {
                AlertsUtil.mostrarError("2. Error al conectar con la base de datos" + ex.getMessage());
            } catch (IOException ex) {
                AlertsUtil.mostrarError("3. Error al conectar con la base de datos" + ex.getMessage());
            } finally {
                Usuario.desconectar();
            }
        }
    }

    //Campos de relleno del LOGIN:---------------------------------------------
    @FXML
    private TextField lnombre;
    @FXML
    private PasswordField lpass;

    @FXML
    private void login() throws SQLException {
        UsuarioDAO Usuario = new UsuarioDAO();
        Usuario usu = new Usuario(lnombre.getText(), lpass.getText());
        Usuario usu2 = new Usuario();

        if (usu.getNombre() == null || usu.getPass() == null) {
            return;
        }

        try {
            Usuario.conectar();
            Usuario userDb = Usuario.cogerUsuarioPorNombre(usu.getNombre());

            if (usu.getNombre().equals(userDb.getNombre()) && usu.getPass().equals(userDb.getPass())) {
                App.setUsuario(userDb);
                App.setRoot("secondary_1");
            } else {
                AlertsUtil.mostrarError("Has introducido mal tus datos. Escríbelos de nuevo.");
            }

        } catch (SQLException sqle) {
            AlertsUtil.mostrarError("1. Error al conectar con la base de datos" + sqle.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertsUtil.mostrarError("2. Error al conectar con la base de datos" + ex.getMessage());
        } catch (IOException ex) {
            AlertsUtil.mostrarError("3. Error al conectar con la base de datos" + ex.getMessage());
        } finally {
            Usuario.desconectar();
        }

    }

}
