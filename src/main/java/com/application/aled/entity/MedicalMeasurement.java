package com.application.aled.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * @author Mounir
 *
 * Une mesure est :
 *  - d'un type donnée,
 *  - effectuée par un objet connecté
 *  - prise pour un patient donné
 *  */

@Entity
public class MedicalMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // La date et l'heure à laquelle ont été effectuées la mesure
    @Column(name = "dateAndTime", columnDefinition = "TIMESTAMP")
    private LocalDateTime measurementDateAndTime;

    private double measurementValue;

    // A measurement is done by ONE bracelet, but a connected Object can send measures many times
    @ManyToOne(fetch = FetchType.LAZY, optional = false)  //It indicates that the relationship must be loaded on demand
    @JoinColumn(name = "bracelet_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Bracelet bracelet;

    // A measurement is related to ONE measurementType, but a measurementType can be involved in  many measurements
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "medicalMeasurementType_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private MedicalMeasurementType medicalMeasurementType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getMeasurementDateAndTime() {
        return measurementDateAndTime;
    }

    public void setMeasurementDateAndTime(LocalDateTime measurementDateAndTime) {
        this.measurementDateAndTime = measurementDateAndTime;
    }

    public double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public Bracelet getBracelet() {
        return bracelet;
    }

    public void setBracelet(Bracelet bracelet) {
        this.bracelet = bracelet;
    }

    public MedicalMeasurementType getMedicalMeasurementType() {
        return medicalMeasurementType;
    }

    public void setMedicalMeasurementType(MedicalMeasurementType medicalMeasurementType) {
        this.medicalMeasurementType = medicalMeasurementType;
    }


}
