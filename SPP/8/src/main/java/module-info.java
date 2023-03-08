module com.example.spp_lab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spp_lab1 to javafx.fxml;
    exports com.example.spp_lab1;
}