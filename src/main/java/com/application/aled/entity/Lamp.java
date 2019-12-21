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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Object object;

    public Lamp() {

    }

    public Lamp(boolean status, Timestamp hourOn, Timestamp hourOff, int intensity, String color) {
        this.status = status;
        this.hourOn = hourOn;
        this.hourOff = hourOff;
        this.intensity = intensity;
        this.color = color;
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

    @Override
    public String toString() {
        return "Lamp{" +
                "id=" + idLamp +
                ", status=" + status +
                ", hourOn=" + hourOn +
                ", hourOff=" + hourOff +
                ", intensity=" + intensity +
                ", color=" + color +
                '}';
    }
}
