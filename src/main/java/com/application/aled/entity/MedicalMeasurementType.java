package com.application.aled.entity;

import javax.persistence.*;

/**
 *
 * @author Mounir
 *
 */
@Entity
public class MedicalMeasurementType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //nom pour le type de mesure ex "Rythme cardiaque"
    @Column(nullable = false , unique = true)
    private String name;

    // l'unité de mesure dans sa forme abrégée, par exemple "bpm"
    @Column(nullable = false )
    private String shortFormUnit;

    // l'unité de mesure dans sa forme explicite, par exemple "battement par minute"
    @Column(nullable = true )
    private String longFormUnit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortFormUnit() {
        return shortFormUnit;
    }

    public void setShortFormUnit(String shortFormUnit) {
        this.shortFormUnit = shortFormUnit;
    }

    public String getLongFormUnit() {
        return longFormUnit;
    }

    public void setLongFormUnit(String longFormUnit) {
        this.longFormUnit = longFormUnit;
    }

}
