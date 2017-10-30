package com.order;


public class Item {
    private int id;
    private String prodName;
    private int quantity;
    private int price;
    private String orderDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOrderdate(String orderdate) {
        this.orderDate = orderdate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", prodName='" + prodName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", orderDate='" + orderDate + '\'' +
                '}';
    }
}
