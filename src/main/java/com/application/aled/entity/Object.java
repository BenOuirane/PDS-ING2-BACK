package com.application.aled.entity;

import com.application.aled.controller.exception.CustomHandler;

import javax.persistence.*;

@Entity
@Table(name = "objects")
public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "state")
    private boolean state;

    @Column(name = "macAddress")
    private String macAddress;

    @Column(name = "ipAddress")
    private String ipAddress;

    @Column(name = "objectType")
    private String objectType;

    public Object() { }

    public Object(boolean state, String macAddress, String ipAddress, String objectType) {
        this.state = state;
        this.macAddress = macAddress;
        this.ipAddress = ipAddress;
        this.objectType = objectType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        for (ObjectType object : ObjectType.values()) {
            if(objectType.equals(object.name())){
                this.objectType = objectType;
                return;
            }
        }
        throw new CustomHandler("Object Type not respected");
    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", state=" + state +
                ", macAddress='" + macAddress + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", objectType='" + objectType + '\'' +
                '}';
    }
}
