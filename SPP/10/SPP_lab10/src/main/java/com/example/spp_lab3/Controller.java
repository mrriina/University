package com.example.spp_lab3;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    private TableView storagesTable;
    @FXML
    private ComboBox filterCombo;
    @FXML
    private Button showTableButton;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button refreshButton;
    @FXML
    private GridPane  recordForm;
    @FXML
    private Label idRowLabel;
    @FXML
    private Label productRowLabel;
    @FXML
    private Label warehouseRowLabel;
    @FXML
    private Label amountRowLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label productLabel;
    @FXML
    private Label warehouseLabel;
    @FXML
    private Label amountLabel;
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn productColumn;
    @FXML
    private TableColumn warehouseColumn;
    @FXML
    private TableColumn amountColumn;

    public Warehouse warehouseFilter = null;

    @FXML
    public void initialize() throws IOException, SQLException {
        storagesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Statement statement = Main.conn.createStatement();

        String sqlCommand = "SELECT * FROM warehouses";
        ResultSet resultSet = statement.executeQuery(sqlCommand);
        ObservableList<Warehouse> warehouses = FXCollections.observableArrayList();

        while (resultSet.next()) {
            warehouses.add(
                    new Warehouse(
                            resultSet.getInt("number_warehouse"),
                            resultSet.getString("name"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getInt("companyid")
                    )
            );
        }

        filterCombo.setItems(warehouses);
        showTableButtonClicked();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addEditWindow.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(loader.load()));

        SecondaryController controller = loader.getController();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void refreshButtonClicked() throws IOException, SQLException {
        filterCombo.setValue(null);
        showTableButtonClicked();
    }

    @FXML
    private void showTableButtonClicked() throws IOException, SQLException {
        Statement statement = Main.conn.createStatement();
        String sqlCommand;
        ResultSet resultSet;

        warehouseFilter = (Warehouse) filterCombo.getValue();

        if (Objects.isNull(warehouseFilter))
            sqlCommand = "SELECT storage.idstorage, product.name, warehouses.name, storage.amount FROM storage INNER JOIN product ON product.idproduct = storage.product INNER JOIN warehouses ON warehouses.number_warehouse = storage.warehouse";
        else
            sqlCommand = "SELECT storage.idstorage, product.name, warehouses.name, storage.amount FROM storage INNER JOIN product ON product.idproduct = storage.product INNER JOIN warehouses ON warehouses.number_warehouse = storage.warehouse WHERE warehouses.number_warehouse = '" + warehouseFilter.getId_warehouse() +"'";
        resultSet = statement.executeQuery(sqlCommand);

        ObservableList<Storage> storages = FXCollections.observableArrayList();

        while (resultSet.next()) {
            storages.add(
                    new Storage(
                            resultSet.getInt("idstorage"),
                            resultSet.getString("product.name"),
                            resultSet.getString("warehouses.name"),
                            resultSet.getInt("amount")
                    )
            );
        }

        storagesTable.setItems(storages);

        productColumn.setCellValueFactory(new PropertyValueFactory<Storage, String>("product_name"));
        warehouseColumn.setCellValueFactory(new PropertyValueFactory<Storage, String>("warehouse_name"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Storage, Integer>("amount"));
    }

    @FXML
    private void newButtonClicked() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addEditWindow.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(fxmlLoader.load()));

        SecondaryController controller = fxmlLoader.getController();

        stage.initModality(Modality.APPLICATION_MODAL);

        Statement statement = Main.conn.createStatement();
        String sqlCommand = "SELECT * FROM product";
        ResultSet resultSet = statement.executeQuery(sqlCommand);
        ObservableList<Product> products = FXCollections.observableArrayList();

        while (resultSet.next()) {
            products.add(
                    new Product(
                            resultSet.getInt("idproduct"),
                            resultSet.getString("name"),
                            resultSet.getString("model"),
                            resultSet.getInt("price")
                    )
            );
        }

        sqlCommand = "SELECT * FROM warehouses";
        resultSet = statement.executeQuery(sqlCommand);
        ObservableList<Warehouse> warehouses = FXCollections.observableArrayList();

        while (resultSet.next()) {
            warehouses.add(
                    new Warehouse(
                            resultSet.getInt("number_warehouse"),
                            resultSet.getString("name"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getInt("companyid")
                    )
            );
        }

        controller.productCombo.setItems(products);
        controller.warehouseCombo.setItems(warehouses);

        Storage storage = controller.showDialog(stage, null, null, 0);

        if (storage.getProduct_name() == null || storage.getWarehouse_name() == null || storage.getAmount() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Adding error");
            alert.setHeaderText("");
            alert.setContentText("All fields must be filled in!");

            alert.showAndWait();

            return;
        }

        sqlCommand = "INSERT INTO storage (product, warehouse, amount) VALUES ('" + Integer.valueOf(storage.getProduct_name()) + "', '" + Integer.valueOf(storage.getWarehouse_name()) + "', '" + storage.getAmount() + "')";
        statement.execute(sqlCommand);

        showTableButtonClicked();
    }


    @FXML
    private void editButtonClicked() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addEditWindow.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(new Scene(fxmlLoader.load()));

        SecondaryController controller = fxmlLoader.getController();

        stage.initModality(Modality.APPLICATION_MODAL);

        Storage selectedStorage = (Storage) storagesTable.getSelectionModel().getSelectedItem();
        Product selectedProduct = null;
        Warehouse selectedWarehouse = null;
        Integer selectedProductId = null;
        Integer selectedWarehouseId = null;

        Statement statement = Main.conn.createStatement();
        String sqlCommand = "SELECT product, warehouse FROM storage WHERE idstorage = '" + selectedStorage.getId_storage() + "'";
        ResultSet resultSet = statement.executeQuery(sqlCommand);
        while (resultSet.next()) {
            selectedProductId = resultSet.getInt("product");
            selectedWarehouseId = resultSet.getInt("warehouse");
        }


        sqlCommand = "SELECT * FROM product";
        resultSet = statement.executeQuery(sqlCommand);
        ObservableList<Product> products = FXCollections.observableArrayList();

        while (resultSet.next()) {
            if (resultSet.getInt("idproduct") == selectedProductId) {
                selectedProduct = new Product(
                        resultSet.getInt("idproduct"),
                        resultSet.getString("name"),
                        resultSet.getString("model"),
                        resultSet.getInt("price")
                );
            }

            products.add(
                    new Product(
                            resultSet.getInt("idproduct"),
                            resultSet.getString("name"),
                            resultSet.getString("model"),
                            resultSet.getInt("price")
                    )
            );
        }

        sqlCommand = "SELECT * FROM warehouses";
        resultSet = statement.executeQuery(sqlCommand);
        ObservableList<Warehouse> warehouses = FXCollections.observableArrayList();

        while (resultSet.next()) {
            if (resultSet.getInt("number_warehouse") == selectedWarehouseId) {
                selectedWarehouse = new Warehouse(
                        resultSet.getInt("number_warehouse"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getInt("companyid")
                );
            }

            warehouses.add(
                    new Warehouse(
                            resultSet.getInt("number_warehouse"),
                            resultSet.getString("name"),
                            resultSet.getString("address"),
                            resultSet.getString("phone"),
                            resultSet.getInt("companyid")
                    )
            );
        }

        controller.productCombo.setItems(products);
        controller.warehouseCombo.setItems(warehouses);

        Storage storage = controller.showDialog(stage, selectedProduct, selectedWarehouse, selectedStorage.getAmount());

        if (storage.getProduct_name() == null || storage.getWarehouse_name() == null || storage.getAmount() == null) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Editing error");
            alert.setHeaderText("");
            alert.setContentText("All fields must be filled in!");

            alert.showAndWait();

            return;
        }

        sqlCommand = "UPDATE storage SET product = '" + Integer.valueOf(storage.getProduct_name()) + "', warehouse = '" + Integer.valueOf(storage.getWarehouse_name()) + "', amount = '" + storage.getAmount() + "' WHERE idstorage = '" + selectedStorage.getId_storage() + "'";
        statement.execute(sqlCommand);

        showTableButtonClicked();
    }

    @FXML
    private void deleteButtonClicked() throws IOException, SQLException {
        ObservableList<Storage> storages = storagesTable.getSelectionModel().getSelectedItems();

        for (int i = 0; i < storages.size(); i++) {
            Storage storage = (Storage) storages.get(i);
            Statement statement = Main.conn.createStatement();
            String sqlCommand = "DELETE FROM storage WHERE idstorage = '" + storage.getId_storage() + "'";
            statement.execute(sqlCommand);
        }

        showTableButtonClicked();
    }

    @FXML
    private void handleRowSelect() {
        Storage row = (Storage) storagesTable.getSelectionModel().getSelectedItem();
        if (row == null) return;

        idRowLabel.setText(String.valueOf(row.getId_storage()));
        productRowLabel.setText(row.getProduct_name());
        warehouseRowLabel.setText(row.getWarehouse_name());
        amountRowLabel.setText(row.getAmount().toString());
    }
}