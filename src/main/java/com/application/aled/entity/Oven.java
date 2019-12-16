package com.application.aled.entity;

import com.application.aled.controller.exception.CustomHandler;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="oven")
public class Oven {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOven;

    @Column(name = "effectiveTemp")
    private int effectiveTemp;

    @Column(name = "programTemp")
    private int programTemp;

    @Column(name = "scheduleTime")
    private Timestamp scheduleTime;

    @Column(name = "status")
    private boolean status;

    @Column(name = "mode")
    private String mode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Object object;

    @Column(name = "modeUsine")
    private String modeUsine;

    @Column(name = "programTempUsine")
    private int programTempUsine;

    @Column(name = "statusUsine")
    private boolean statusUsine;

    @Column(name = "effectiveTempUsine")
    private int effectiveTempUsine;

    @Column(name = "scheduleTimeUsine")
    private Timestamp scheduleTimeUsine;

    public Oven() {

    }

    public Oven(int effectiveTemp, int programTemp, Timestamp scheduleTime, boolean status, String mode, String modeUsine, Object object, int programTempUsine, boolean statusUsine, Timestamp scheduleTimeUsine, int effectiveTempUsine) {
        this.effectiveTemp = effectiveTemp;
        this.programTemp = programTemp;
        this.scheduleTime = scheduleTime;
        this.status = status;
        this.mode = mode;
        this.modeUsine = modeUsine;
        this.object = object;
        this.programTempUsine = programTempUsine;
        this.statusUsine = statusUsine;
        this.effectiveTempUsine = effectiveTempUsine;
        this.scheduleTimeUsine = scheduleTimeUsine;
    }

    public long getIdOven() {
        return idOven;
    }

    public void setIdOven(long idOven) {
        this.idOven = idOven;
    }

    public int getEffectiveTemp() {
        return effectiveTemp;
    }

    public void setEffectiveTemp(int effectiveTemp) {
        this.effectiveTemp = effectiveTemp;
    }

    public int getProgramTemp() {
        return programTemp;
    }

    public void setProgramTemp(int programTemp) {
        this.programTemp = programTemp;
    }

    public Timestamp getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Timestamp scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getProgramTempUsine() {
        return programTempUsine;
    }

    public int getEffectiveTempUsine() {
        return effectiveTempUsine;
    }

    public void setEffectiveTempUsine(int effectiveTempUsine) {
        this.effectiveTempUsine = effectiveTempUsine;
    }

    public void setProgramTempUsine(int programTempUsine) {
        this.programTempUsine = programTempUsine;
    }

    public boolean isStatusUsine() {
        return statusUsine;
    }

    public void setStatusUsine(boolean statusUsine) {
        this.statusUsine = statusUsine;
    }

    public Timestamp getScheduleTimeUsine() {
        return scheduleTimeUsine;
    }

    public void setScheduleTimeUsine(Timestamp scheduleTimeUsine) {
        this.scheduleTimeUsine = scheduleTimeUsine;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        for (ModeType modeType : ModeType.values()) {
            if(mode.equals(modeType.name())){
                this.mode = mode;
                return;
            }
        }
        throw new CustomHandler("Mode Type not respected");
    }

    public String getModeUsine() {
        return modeUsine;
    }

    public void setModeUsine(String modeUsine) {
        for (ModeType modeType : ModeType.values()) {
            if(modeUsine.equals(modeType.name())){
                this.modeUsine = modeUsine;
                return;
            }
        }
        throw new CustomHandler("Mode Type not respected");
    }

    @Override
    public String toString() {
        return "Oven{" +
                "idOven=" + idOven +
                ", effectiveTemp=" + effectiveTemp +
                ", effectiveTempUsine=" + effectiveTempUsine +
                ", programTemp=" + programTemp +
                ", scheduleTime=" + scheduleTime +
                ", status=" + status +
                ", mode='" + mode + '\'' +
                ", modeUsine='" + modeUsine + '\'' +
                ", object=" + object +
                ", programTempUsine=" + programTempUsine +
                ", statusUsine=" + statusUsine +
                ", scheduleTimeUsine=" + scheduleTimeUsine +
                '}';
    }
}
