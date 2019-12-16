package com.application.aled.entity;

import javax.persistence.*;
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

    @Column(name = "begin_date")
    private Timestamp begin_date;

    @Column(name = "end_date")
    private Timestamp end_date;
}
