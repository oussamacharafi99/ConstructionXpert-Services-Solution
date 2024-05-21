package com.construction.classes;

public class Resource {

    public Resource() {
    }

    public Resource(int resource_id, String name, String type, int quantity, String supplier) {
        this.resource_id = resource_id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.supplier = supplier;
    }
    public Resource(int id , int resource_id, String name, String type, int quantity, String supplier) {
        this.id = id;
        this.resource_id = resource_id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    private int id;
    private int resource_id;
    private String name;
    private String type;
    private int quantity;
    private String supplier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }
}
