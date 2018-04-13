package com.mahdi.ordermanager.dbmanager.model;

public abstract class Product {
    private int id;
    private String name;
    private int type;
    private int subType;
    private int taste;
    private int size;
    private int stock;
    private String description;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public int getTaste() {
        return taste;
    }

    public void setTaste(int taste) {
        this.taste = taste;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
