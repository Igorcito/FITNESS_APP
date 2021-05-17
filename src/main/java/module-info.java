module com.mycompany.workout {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.workout to javafx.fxml;
    exports com.mycompany.workout;
}
