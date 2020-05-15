package com.application.aled.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Mounir dit moumoun
 *
 */

@Entity
public class MedicalThreshold implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int minValue;

    private int maxValue;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "measurementType_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private MedicalMeasurementType measurementType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)  //It indicates that the relationship must be loaded on demand
    @JoinColumn(name = "resident_id", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private Resident resident;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public MedicalMeasurementType getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(MedicalMeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }
}
