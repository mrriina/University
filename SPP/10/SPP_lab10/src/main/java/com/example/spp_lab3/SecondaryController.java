package com.example.spp_lab3;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    public ComboBox productCombo;
    @FXML
    public ComboBox warehouseCombo;
    @FXML
    public TextField idAmount;
    @FXML
    public Button submitButton;

    public Product product = null;
    public Warehouse warehouse = null;
    public Integer amount = null;

    public Storage showDialog(Stage stage, Product productComboValue, Warehouse warehouseComboValue, Integer amountInputValue) throws IOException, SQLException {
        productCombo.setValue(productComboValue);
        warehouseCombo.setValue(warehouseComboValue);
        idAmount.setText(Integer.toString(amountInputValue));

        submitButton.setOnAction(e -> {
            if (productCombo.getValue() != null)
                product = (Product) productCombo.getValue();
            if (warehouseCombo.getValue() != null)
                warehouse = (Warehouse) warehouseCombo.getValue();
            if (idAmount.getText() != null)
                amount = Integer.valueOf(idAmount.getText());
            stage.close();
        });

        stage.showAndWait();

        if (product == null || warehouse == null || amount == null) {
            return new Storage(0, null, null, 0);
        }

        return new Storage(0, product.getId_product().toString(), warehouse.getId_warehouse().toString(), amount);
    }
}