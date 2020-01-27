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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rooms")

    private List<Objects> objects;

    public Rooms() {
    }
    public Rooms(int roomNumber, List<Objects> objects){
        this.roomNumber = roomNumber;
        this.objects = objects;
    }

   public List<Objects> getObjects() {
        return objects;
    }

    public void setObjects(List<Objects> objects) {
        this.objects = objects;
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
