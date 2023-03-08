package com.example.spp_lab3;

public class Product {
    private Integer id_product;
    private String name;
    private String model;
    private Integer price;

    public Product(Integer id, String pr_name, String mod, Integer pr) {
        this.id_product = id;
        this.name = pr_name;
        this.model = mod;
        this.price = pr;
    }

    public Integer getId_product() {
        return this.id_product;
    }

    public String getName() {
        return this.name;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setId_product(Integer value) {
        this.id_product = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setModel(String value) {
        this.model = value;
    }

    public void setPrice(Integer value) {
        this.price = value;
    }
}
