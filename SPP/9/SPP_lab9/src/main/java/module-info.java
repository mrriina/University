module com.example.spp_lab2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.spp_lab2 to javafx.fxml;
    exports com.example.spp_lab2;
}