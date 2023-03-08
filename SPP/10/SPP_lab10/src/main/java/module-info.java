module com.example.spp_lab3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.spp_lab3 to javafx.fxml;
    exports com.example.spp_lab3;
}