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

    @Column(name = "nbCapsuleUsine")
    private int nbCapsuleUsine;

    @Column(name = "scheduleCoffeeUsine")
    private Timestamp scheduleCoffeeUsine;

    @Column(name = "statusUsine")
    private boolean statusUsine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Object object;

    public CoffeeMachine() {

    }

    public CoffeeMachine(int nbCapsule, Timestamp scheduleCoffee, boolean status, int nbCapsuleUsine, Timestamp scheduleCoffeeUsine, boolean statusUsine, Object object) {
        this.nbCapsule = nbCapsule;
        this.scheduleCoffee = scheduleCoffee;
        this.status = status;
        this.nbCapsuleUsine = nbCapsuleUsine;
        this.scheduleCoffeeUsine = scheduleCoffeeUsine;
        this.statusUsine = statusUsine;
        this.object = object;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "idCoffee=" + idCoffee +
                ", nbCapsule=" + nbCapsule +
                ", scheduleCoffee=" + scheduleCoffee +
                ", status=" + status +
                ", nbCapsuleUsine=" + nbCapsuleUsine +
                ", scheduleCoffeeUsine=" + scheduleCoffeeUsine +
                ", statusUsine=" + statusUsine +
                ", object=" + object +
                '}';
    }
}
