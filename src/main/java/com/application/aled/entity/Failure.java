package com.application.aled.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

@Entity
@Table(name = "failure")
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "message")
    private String message;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
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

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
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

    @Override
    public String toString() {
        return "Failure{" +
                "id=" + id +
                ", macAddress='" + macAddress + '\'' +
                ", message='" + message + '\'' +
                ", begin_date=" + begin_date +
                ", end_date=" + end_date +
                '}';
    }
}
