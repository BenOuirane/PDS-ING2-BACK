package com.application.aled.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "failure")
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Objects objects;

    @Column(name = "message")
    private String message;

    @Column(name = "begin_date")
    private Timestamp begin_date;

    @Column(name = "end_date")
    private Timestamp end_date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Timestamp begin_date) {
        this.begin_date = begin_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "Failure{" +
                "id=" + id +
                ", objects=" + objects +
                ", message='" + message + '\'' +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                '}';
    }
}
