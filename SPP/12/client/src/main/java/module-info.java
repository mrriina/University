module com.example.spp_lab5_client {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spp_lab5_client to javafx.fxml;
    exports com.example.spp_lab5_client;
}