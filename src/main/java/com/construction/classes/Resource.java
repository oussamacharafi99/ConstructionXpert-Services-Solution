package com.construction.classes;

public class Resource {

    public Resource() {
    }

    public Resource(int task_id, String name, String type, int quantity, String supplier) {
        this.task_id = task_id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.supplier = supplier;
    }
    public Resource(int id , int task_id, String name, String type, int quantity, String supplier) {
        this.id = id;
        this.task_id = task_id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    private int id;
    private int task_id;
    private String name;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
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

    private int quantity;
    private String supplier;


}
