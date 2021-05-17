package com.mycompany.workout;

import Entidades.Ejercicio_Flexibilidad;
import Entidades.Ejercicio_Fuerza;
import Entidades.Ejercicio_Resistencia;
import com.mycompany.workout.DAOs.EjercicioDAO;
import com.mycompany.workout.DAOs.UsuarioDAO;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

public class SecondaryController {

    //VARIABLES PARA LA OPCIÓN DE EXPORTAR:
    private boolean Fuerza = false;
    private boolean Resistencia = false;
    private boolean Flexibilidad = false;

    @FXML
    private ListView Ejercicios;

    @FXML
    private void cerrarSesion() throws IOException {
        App.loadPrimary();
    }

    @FXML
    private void ircambiarpass() throws IOException {
        App.setRoot("Pass");
    }

    @FXML
    public void Fuerza() throws IOException, SQLException {

        EjercicioDAO conexion1 = new EjercicioDAO();
        Ejercicios.getItems().clear();

        try {
            conexion1.conectar();
            List<Ejercicio_Fuerza> OLEF = conexion1.listEF();
            Ejercicios.setItems(FXCollections.observableList(OLEF));

            Fuerza = true;
            Resistencia = false;
            Flexibilidad = false;

        } catch (SQLException ex) {
            AlertsUtil.mostrarError("1. Error al hacer el listado de ejercicios de Fuerza." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertsUtil.mostrarError("2. Error al hacer el listado de ejercicios de Fuerza." + ex.getMessage());
        } finally {
            conexion1.desconectar();
        }

    }

    @FXML
    public void Resistencia() throws IOException, SQLException {

        EjercicioDAO conexion1 = new EjercicioDAO();
        Ejercicios.getItems().clear();

        try {
            conexion1.conectar();
            List<Ejercicio_Resistencia> OLER = conexion1.listER();
            Ejercicios.setItems(FXCollections.observableList(OLER));

            Fuerza = false;
            Resistencia = true;
            Flexibilidad = false;

        } catch (SQLException ex) {
            AlertsUtil.mostrarError("1. Error al hacer el listado de ejercicios de Resistencia." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertsUtil.mostrarError("2. Error al hacer el listado de ejercicios de Resistencia." + ex.getMessage());
        } finally {
            conexion1.desconectar();
        }

    }

    @FXML
    public void Flexibilidad() throws IOException, SQLException {

        EjercicioDAO conexion1 = new EjercicioDAO();
        Ejercicios.getItems().clear();

        try {
            conexion1.conectar();
            List<Ejercicio_Flexibilidad> OLEFL = conexion1.listEFL();
            Ejercicios.setItems(FXCollections.observableList(OLEFL));

            Fuerza = false;
            Resistencia = false;
            Flexibilidad = true;

        } catch (SQLException ex) {
            AlertsUtil.mostrarError("1. Error al hacer el listado de ejercicios de Flexibilidad." + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertsUtil.mostrarError("2. Error al hacer el listado de ejercicios de Flexibilidad." + ex.getMessage());
        } finally {
            conexion1.desconectar();
        }

    }

    @FXML
    public void borrarUsuario() throws ClassNotFoundException, IOException, SQLException {

        UsuarioDAO Usuario = new UsuarioDAO();

        try {
            Usuario.conectar();
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Darse de Baja:");
            confirmacion.setContentText("¿Estás seguro de que quieres darte de baja?");
            Optional<ButtonType> respuesta = confirmacion.showAndWait();
            if (respuesta.get().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE) {
                return;
            }
            int id = App.getUsuario().getId_usuario();
            Usuario.borrarUsuario(id);
            App.loadPrimary();

        } catch (SQLException ex) {
            AlertsUtil.mostrarError("Error al darse de baja. " + ex.getMessage());
        } finally {
            Usuario.desconectar();
        }
    }

    //**MÉTODO PARA EXPORTAR LOS EJERCICIOS DE 1 TIPO A UN FICHERO.
    @FXML
    public void exportarEjercicios() {
        FileWriter fichero = null;
        PrintWriter escritor = null;
        EjercicioDAO exportacion = new EjercicioDAO();

        try {
            exportacion.conectar();
            fichero = new FileWriter("Tablas.txt");
            escritor = new PrintWriter(fichero);
//            AlertsUtil.mostrarInfo(String.valueOf(Ejercicios.getItems().size()));
//            for(int i=0; i>=Ejercicios.getItems().size(); i++) {
//                escritor.println(Ejercicios.getItems().get(i).toString());
//            }
            
            if (Fuerza == true && Resistencia == false && Flexibilidad == false) {
                escritor.println(exportacion.listEF().toString());
            }
            if (Fuerza == false && Resistencia == true && Flexibilidad == false) {
                escritor.println(exportacion.listER());
            }
            if (Fuerza == false && Resistencia == false && Flexibilidad == true) {
                escritor.println(exportacion.listEFL());
            } 
            AlertsUtil.mostrarInfo("Se han exportado los ejercicios.");
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException ex) {
            AlertsUtil.mostrarError("2. Fallo en la exportación. \n" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            AlertsUtil.mostrarError("3. Fallo en la exportación. \n" + ex.getMessage());
        } finally {
            if (fichero != null)
                try {
                fichero.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
