package com.application.aled.entity;

import javax.persistence.*;
@Entity
@Table(name = "subscription_history")
public class SubscriptionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "month")
    private String month;
    @Column(name = "year")
    private int year;

    public SubscriptionHistory() {

    }

    public SubscriptionHistory(String name, int price, String month, int year) {
        super();
        this.name = name;
        this.price = price;
        this.month = month;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Subscription [id=" + id + ", name=" + name + ", price=" + price + ", month=" + month
                + ", year=" + year + "]";
    }

}

