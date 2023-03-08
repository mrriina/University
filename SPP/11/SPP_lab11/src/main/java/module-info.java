module com.example.spp_lab4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spp_lab4 to javafx.fxml;
    exports com.example.spp_lab4;
}