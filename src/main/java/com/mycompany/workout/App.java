package com.mycompany.workout;

import Entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static Usuario InfoUsuario = new Usuario();

    static void setUsuario(Usuario Infousuario) {       
    InfoUsuario = Infousuario;
    }
    
    static Usuario getUsuario() {
        return InfoUsuario;
    }
    
    /**
     * MÉTODO QUE INICIA LA APLICACIÓN.
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException { 
        String fxml = "primary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        PrimaryController Controller = new PrimaryController();
        fxmlLoader.setController(Controller);
        scene = new Scene(fxmlLoader.load(),1024, 768);
        stage.setScene(scene);
        stage.show();

        // Give the controller access to the main app.
        Controller.loadImage();
    }
    
    /**
     * MÉTODO QUE CARGA LA PANTALLA DE INICIO.
     * @throws IOException 
     */
    static void loadPrimary () throws IOException {
        String fxml = "primary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        PrimaryController controller = new PrimaryController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.loadImage();
        
    }
    /**
     * MÉTODO PARA CARGAR UNA VENTANA.
     * @param fxml
     * @throws IOException 
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    /**
     * 
     * @param fxml
     * @return
     * @throws IOException 
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
    
    /**
     * METODO QUE INICIALIZA EL LISTVIEW PARA VER LOS EJERCICIOS EN PANTALLA.
     * @throws IOException
     * @throws SQLException 
     */
    static void loadlistaejerciciosWindow() throws IOException, SQLException {
        String fxml = "secondary_1";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        SecondaryController controller = new SecondaryController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.Fuerza();
    }
    
}