package com.example.spp_lab3;

public class Storage {
    private Integer id_storage;
    private String product_name;
    private String warehouse_name;
    private Integer amount;

    public Storage(Integer id, String pr_name, String war_name, Integer am) {
        this.id_storage = id;
        this.product_name = pr_name;
        this.warehouse_name = war_name;
        this.amount = am;
    }

    public Integer getId_storage() {
        return this.id_storage;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public String getWarehouse_name() {
        return this.warehouse_name;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setId_storage(Integer value) {
        this.id_storage = value;
    }

    public void setProduct_name(String value) {
        this.product_name = value;
    }

    public void setWarehouse_name(String value) {
        this.warehouse_name = value;
    }

    public void setAmount(Integer value) {
        this.amount = value;
    }
}
