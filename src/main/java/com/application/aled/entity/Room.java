package com.application.aled.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRoom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Resident resident;

    @Column(name = "roomNumber")
    private Timestamp roomNumber;
}
