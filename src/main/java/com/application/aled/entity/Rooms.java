package com.application.aled.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRoom;

    @Column(name = "roomNumber")
    private int roomNumber;

    public Rooms() {
    }
    public Rooms(int roomNumber){
        this.roomNumber = roomNumber;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(long idRoom) {
        this.idRoom = idRoom;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "idRoom=" + idRoom +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
