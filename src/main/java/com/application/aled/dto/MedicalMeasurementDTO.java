package com.application.aled.dto;

public class MedicalMeasurementDTO {

    private double medicalMeasurementValue;
    private Long bracelet_id;
    private Long medicalMeasurementType_id;

    public MedicalMeasurementDTO(){
    }

    public MedicalMeasurementDTO(double medicalMeasurementValue, Long bracelet_id, Long medicalMeasurementType_id) {
        this.medicalMeasurementValue = medicalMeasurementValue;
        this.bracelet_id = bracelet_id;
        this.medicalMeasurementType_id = medicalMeasurementType_id;
    }

    public double getMedicalMeasurementValue() {
        return medicalMeasurementValue;
    }

    public void setMedicalMeasurementValue(double medicalMeasurementValue) {
        this.medicalMeasurementValue = medicalMeasurementValue;
    }

    public Long getBracelet_id() {
        return bracelet_id;
    }

    public void setBracelet_id(Long bracelet_id) {
        this.bracelet_id = bracelet_id;
    }

    public Long getMedicalMeasurementType_id() {
        return medicalMeasurementType_id;
    }

    public void setMedicalMeasurementType_id(Long medicalMeasurementType_id) {
        this.medicalMeasurementType_id = medicalMeasurementType_id;
    }
}
