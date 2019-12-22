package com.application.aled.entity;

import com.application.aled.controller.exception.CustomHandler;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column(name = "colorUsine")
    private String colorUsine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Objects objects;

    public Lamp() {

    }

    public Lamp(boolean status, Timestamp hourOn, Timestamp hourOff, int intensity, String color, String colorUsine, boolean statusUsine, Timestamp hourOnUsine, Timestamp hourOffUsine, int intensityUsine, Objects objects) {
        this.status = status;
        this.hourOn = hourOn;
        this.hourOff = hourOff;
        this.intensity = intensity;
        this.color = color;
        this.colorUsine = colorUsine;
        this.statusUsine = statusUsine;
        this.hourOnUsine = hourOnUsine;
        this.hourOffUsine = hourOffUsine;
        this.intensityUsine = intensityUsine;
        this.objects = objects;
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

    public String getColorUsine() {
        return colorUsine;
    }

    public void setColorUsine(String colorUsine) {
        for (ColorType colorType : ColorType.values()) {
            if(colorUsine.equals(colorType.name())){
                this.colorUsine = colorUsine;
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

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
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
                ", colorUsine='" + colorUsine + '\'' +
                ", statusUsine=" + statusUsine +
                ", hourOnUsine=" + hourOnUsine +
                ", hourOffUsine=" + hourOffUsine +
                ", intensityUsine=" + intensityUsine +
                ", object=" + objects +
                '}';
    }
}
