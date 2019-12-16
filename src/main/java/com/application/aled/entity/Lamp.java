package com.application.aled.entity;

import com.application.aled.controller.exception.CustomHandler;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "lamp")
public class Lamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLamp;

    @Column(name = "status")
    private boolean status;

    @Column(name = "hourOn")
    private Timestamp hourOn;

    @Column(name = "hourOff")
    private Timestamp hourOff;

    @Column(name = "intensity")
    private int intensity;

    @Column(name = "color")
    private String color;

    @Column(name = "statusUsine")
    private boolean statusUsine;

    @Column(name = "hourOnUsine")
    private Timestamp hourOnUsine;

    @Column(name = "hourOffUsine")
    private Timestamp hourOffUsine;

    @Column(name = "intensityUsine")
    private int intensityUsine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Object object;

    public Lamp() {

    }

    public Lamp(boolean status, Timestamp hourOn, Timestamp hourOff, int intensity, String color, boolean statusUsine, Timestamp hourOnUsine, Timestamp hourOffUsine, int intensityUsine, Object object) {
        this.status = status;
        this.hourOn = hourOn;
        this.hourOff = hourOff;
        this.intensity = intensity;
        this.color = color;
        this.statusUsine = statusUsine;
        this.hourOnUsine = hourOnUsine;
        this.hourOffUsine = hourOffUsine;
        this.intensityUsine = intensityUsine;
        this.object = object;
    }

    public long getIdLamp() {
        return idLamp;
    }

    public void setIdLamp(long idLamp) {
        this.idLamp = idLamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        for (ColorType colorType : ColorType.values()) {
            if(color.equals(colorType.name())){
                this.color = color;
                return;
            }
        }
        throw new CustomHandler("Color Type not respected");
    }

    public boolean isStatusUsine() {
        return statusUsine;
    }

    public void setStatusUsine(boolean statusUsine) {
        this.statusUsine = statusUsine;
    }

    public Timestamp getHourOnUsine() {
        return hourOnUsine;
    }

    public void setHourOnUsine(Timestamp hourOnUsine) {
        this.hourOnUsine = hourOnUsine;
    }

    public Timestamp getHourOffUsine() {
        return hourOffUsine;
    }

    public void setHourOffUsine(Timestamp hourOffUsine) {
        this.hourOffUsine = hourOffUsine;
    }

    public int getIntensityUsine() {
        return intensityUsine;
    }

    public void setIntensityUsine(int intensityUsine) {
        this.intensityUsine = intensityUsine;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Lamp{" +
                "idLamp=" + idLamp +
                ", status=" + status +
                ", hourOn=" + hourOn +
                ", hourOff=" + hourOff +
                ", intensity=" + intensity +
                ", color='" + color + '\'' +
                ", statusUsine=" + statusUsine +
                ", hourOnUsine=" + hourOnUsine +
                ", hourOffUsine=" + hourOffUsine +
                ", intensityUsine=" + intensityUsine +
                ", object=" + object +
                '}';
    }
}
