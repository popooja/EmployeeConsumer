package com.example.DemoConsumer.model;

public class EmployeeDTO {

    private String id;

    private String name;

    private String address;

    public String getId() {
        return id;
    }

    public EmployeeDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "ID:"+this.id+","+ "Name;"+this.name +","+this.address;
    }
}
