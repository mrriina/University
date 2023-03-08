package com.example.spp_lab3;

public class Warehouse {
    private Integer id_warehouse;
    private String name;
    private String address;
    private String phone;
    private Integer companyid;

    public Warehouse(Integer id, String nm, String addr, String ph, Integer ci) {
        this.id_warehouse = id;
        this.name = nm;
        this.address = addr;
        this.phone = ph;
        this.companyid = ci;
    }

    public Integer getId_warehouse() {
        return this.id_warehouse;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public Integer getCompanyid() {
        return this.companyid;
    }

    public void setId_warehouse(Integer value) {
        this.id_warehouse = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public void setCompanyid(Integer value) {
        this.companyid = value;
    }
}
