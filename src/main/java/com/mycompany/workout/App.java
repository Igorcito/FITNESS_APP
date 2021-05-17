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
    
    
    @Override
    public void start(Stage stage) throws IOException { //ESTE MÉTODO ES PARA QUE SE NOS MUESTRE LA IMAGEN EN EL LOGIN.
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
//    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("primary"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }

    static void loadPrimary () throws IOException {
        String fxml = "primary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        PrimaryController controller = new PrimaryController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.loadImage();
        
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
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