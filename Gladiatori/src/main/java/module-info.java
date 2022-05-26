module com.example.gladiatori {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gladiatori to javafx.fxml;
    exports com.example.gladiatori;
}