module com.example.laba_bd {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.laba_bd to javafx.fxml;
    exports com.example.laba_bd;
}