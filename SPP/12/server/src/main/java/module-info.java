module com.example.spp_lab5_server {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spp_lab5_server to javafx.fxml;
    exports com.example.spp_lab5_server;
}