package org.example.entity;

import javax.persistence.*;

@Entity
public class PurchaseProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;
    private double price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
