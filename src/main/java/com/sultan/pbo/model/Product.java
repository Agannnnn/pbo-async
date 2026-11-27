package com.sultan.pbo.model;

public class Product {
    private String no;
    private String name;
    private int qty;
    private double price;

    public Product(String no, String name, int qty, double price) {
        this.no = no;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return (double) qty * price;
    }

}
