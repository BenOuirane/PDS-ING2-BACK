package com.application.aled.dto;

public class MedicalThresholdDTO {

    private Long resident_id;
    private Long measurementType_id;
    private int minValue;
    private int maxValue;

    public MedicalThresholdDTO() {
    }

    public MedicalThresholdDTO(Long resident_id, Long measurementType_id, int minValue, int maxValue) {
        this.resident_id = resident_id;
        this.measurementType_id = measurementType_id;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public Long getResident_id() {
        return resident_id;
    }

    public void setResident_id(Long resident_id) {
        this.resident_id = resident_id;
    }

    public Long getMeasurementType_id() {
        return measurementType_id;
    }

    public void setMeasurementType_id(Long measurementType_id) {
        this.measurementType_id = measurementType_id;
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

}
