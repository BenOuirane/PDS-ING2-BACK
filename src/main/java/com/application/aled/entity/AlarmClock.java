package com.application.aled.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="alarmClock")
public class AlarmClock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAlarmClock;

    @Column(name = "alarm")
    private Timestamp alarm;

    @Column(name = "radioHrz")
    private float radioHrz;

    @Column(name = "radioStatus")
    private boolean radioStatus;

    @Column(name = "alarmStatus")
    private boolean alarmStatus;

    @Column(name = "alarmUsine")
    private Timestamp alarmUsine;

    @Column(name = "radioHrtzUsine")
    private float radioHrtzUsine;

    @Column(name = "radioStatusUsine")
    private boolean radioStatusUsine;

    @Column(name = "alarmStatusUsine")
    private boolean alarmStatusUsine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Objects objects;

    public AlarmClock() {

    }

    public AlarmClock(Timestamp alarm, int radioHrz, boolean radioStatus, boolean alarmStatus, Timestamp alarmUsine, int radioHrtzUsine, boolean radioStatusUsine, boolean alarmStatusUsine, Objects objects) {
        this.alarm = alarm;
        this.radioHrz = radioHrz;
        this.radioStatus = radioStatus;
        this.alarmStatus = alarmStatus;
        this.alarmUsine = alarmUsine;
        this.radioHrtzUsine = radioHrtzUsine;
        this.radioStatusUsine = radioStatusUsine;
        this.alarmStatusUsine = alarmStatusUsine;
        this.objects = objects;
    }

    public long getIdAlarmClock() {
        return idAlarmClock;
    }

    public void setIdAlarmClock(long idAlarmClock) {
        this.idAlarmClock = idAlarmClock;
    }

    public Timestamp getAlarm() {
        return alarm;
    }

    public void setAlarm(Timestamp alarm) {
        this.alarm = alarm;
    }

    public float getRadioHrz() {
        return radioHrz;
    }

    public void setRadioHrz(float radioHrz) {
        this.radioHrz = radioHrz;
    }

    public boolean isRadioStatus() {
        return radioStatus;
    }

    public void setRadioStatus(boolean radioStatus) {
        this.radioStatus = radioStatus;
    }

    public boolean isAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public Timestamp getAlarmUsine() {
        return alarmUsine;
    }

    public void setAlarmUsine(Timestamp alarmUsine) {
        this.alarmUsine = alarmUsine;
    }

    public float getRadioHrtzUsine() {
        return radioHrtzUsine;
    }

    public void setRadioHrtzUsine(float radioHrtzUsine) {
        this.radioHrtzUsine = radioHrtzUsine;
    }

    public boolean isRadioStatusUsine() {
        return radioStatusUsine;
    }

    public void setRadioStatusUsine(boolean radioStatusUsine) {
        this.radioStatusUsine = radioStatusUsine;
    }

    public boolean isAlarmStatusUsine() {
        return alarmStatusUsine;
    }

    public void setAlarmStatusUsine(boolean alarmStatusUsine) {
        this.alarmStatusUsine = alarmStatusUsine;
    }

    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "AlarmClock{" +
                "idAlarmClock=" + idAlarmClock +
                ", alarm=" + alarm +
                ", radioHrz=" + radioHrz +
                ", radioStatus=" + radioStatus +
                ", alarmStatus=" + alarmStatus +
                ", alarmUsine=" + alarmUsine +
                ", radioHrtzUsine=" + radioHrtzUsine +
                ", radioStatusUsine=" + radioStatusUsine +
                ", alarmStatusUsine=" + alarmStatusUsine +
                ", object=" + objects +
                '}';
    }
}
