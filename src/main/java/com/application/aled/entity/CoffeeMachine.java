package com.application.aled.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="coffeeMachine")
public class CoffeeMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCoffee;

    @Column(name = "nbCapsule")
    private int nbCapsule;

    @Column(name = "scheduleCoffee")
    private Timestamp scheduleCoffee;

    @Column(name = "status")
    private boolean status;

    @Column(name = "waterLevel")
    private int waterLevel;

    @Column(name = "nbCapsuleUsine")
    private int nbCapsuleUsine;

    @Column(name = "scheduleCoffeeUsine")
    private Timestamp scheduleCoffeeUsine;

    @Column(name = "statusUsine")
    private boolean statusUsine;

    @Column(name = "waterLevelUsine")
    private int waterLevelUsine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Objects objects;

    public CoffeeMachine() {

    }

    public CoffeeMachine(int nbCapsule, Timestamp scheduleCoffee, boolean status, int waterLevel, int nbCapsuleUsine, Timestamp scheduleCoffeeUsine, boolean statusUsine, int waterLevelUsine, Objects objects) {
        this.nbCapsule = nbCapsule;
        this.scheduleCoffee = scheduleCoffee;
        this.status = status;
        this.waterLevel = waterLevel;
        this.nbCapsuleUsine = nbCapsuleUsine;
        this.scheduleCoffeeUsine = scheduleCoffeeUsine;
        this.statusUsine = statusUsine;
        this.waterLevelUsine = waterLevelUsine;
        this.objects = objects;
    }

    public long getIdCoffee() {
        return idCoffee;
    }

    public void setIdCoffee(long idCoffee) {
        this.idCoffee = idCoffee;
    }

    public int getNbCapsule() {
        return nbCapsule;
    }

    public void setNbCapsule(int nbCapsule) {
        this.nbCapsule = nbCapsule;
    }

    public Timestamp getScheduleCoffee() {
        return scheduleCoffee;
    }

    public void setScheduleCoffee(Timestamp scheduleCoffee) {
        this.scheduleCoffee = scheduleCoffee;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNbCapsuleUsine() {
        return nbCapsuleUsine;
    }

    public void setNbCapsuleUsine(int nbCapsuleUsine) {
        this.nbCapsuleUsine = nbCapsuleUsine;
    }

    public Timestamp getScheduleCoffeeUsine() {
        return scheduleCoffeeUsine;
    }

    public void setScheduleCoffeeUsine(Timestamp scheduleCoffeeUsine) {
        this.scheduleCoffeeUsine = scheduleCoffeeUsine;
    }

    public boolean isStatusUsine() {
        return statusUsine;
    }

    public void setStatusUsine(boolean statusUsine) {
        this.statusUsine = statusUsine;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getWaterLevelUsine() {
        return waterLevelUsine;
    }

    public void setWaterLevelUsine(int waterLevelUsine) {
        this.waterLevelUsine = waterLevelUsine;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "idCoffee=" + idCoffee +
                ", nbCapsule=" + nbCapsule +
                ", scheduleCoffee=" + scheduleCoffee +
                ", status=" + status +
                ", waterLevel=" + waterLevel +
                ", nbCapsuleUsine=" + nbCapsuleUsine +
                ", scheduleCoffeeUsine=" + scheduleCoffeeUsine +
                ", statusUsine=" + statusUsine +
                ", waterLevelUsine=" + waterLevelUsine +
                ", object=" + objects +
                '}';
    }
}
