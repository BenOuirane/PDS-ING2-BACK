package com.application.aled.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="shutter")
public class Shutter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idShutter;

    @Column(name = "hourOn")
    private Timestamp hourOn;

    @Column(name = "hourOff")
    private Timestamp hourOff;

    @Column(name = "status")
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Object object;

    public Shutter() {

    }

    public Shutter(Timestamp hourOn, Timestamp hourOff, boolean status, Object object) {
        this.hourOn = hourOn;
        this.hourOff = hourOff;
        this.status = status;
        this.object = object;
    }

    public long getIdShutter() {
        return idShutter;
    }

    public void setIdShutter(long idShutter) {
        this.idShutter = idShutter;
    }

    public Timestamp getHourOn() {
        return hourOn;
    }

    public void setHourOn(Timestamp hourOn) {
        this.hourOn = hourOn;
    }

    public Timestamp getHourOff() {
        return hourOff;
    }

    public void setHourOff(Timestamp hourOff) {
        this.hourOff = hourOff;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Shutter{" +
                "idShutter=" + idShutter +
                ", hourOn=" + hourOn +
                ", hourOff=" + hourOff +
                ", status=" + status +
                ", object=" + object +
                '}';
    }
}
