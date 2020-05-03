package com.application.aled.entity;
import javax.persistence.*;

@Entity
@Table(name = "total_subscription")
public class TotalSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "total")
    private int total;

    @Column(name = "average")
    private int average;


    public TotalSubscription() {

    }

    public TotalSubscription(String name,  int year, int total, int average) {
        super();
        this.name = name;
        this.year = year;
        this.total = total;
        this.average = average;
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
}




