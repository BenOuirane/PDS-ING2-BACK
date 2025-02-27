package com.application.aled.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/*
 * The class 'Message' has five attributes
 * will become the table 'messages' with three columns :
 * - Id --> This will automaticaly be a sequence on our database
 * - mac_address
 * - effective_temperature
 * - programmed_temperature
 * - dateTime
 */
@XmlRootElement(name="message")
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Objects objects;

    @Column(name = "effective_temperature")
    private int effective_temperature;

    @Column(name = "programmed_temperature")
    private int programmed_temperature;

    @Column(name = "dateTime")
    private Timestamp dateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Objects getObjects() { return objects;}

    public void setObjects(Objects objects) { this.objects = objects;}

    public int getEffective_temperature() {
        return effective_temperature;
    }

    public void setEffective_temperature(int effective_temperature) {
        this.effective_temperature = effective_temperature;
    }

    public int getProgrammed_temperature() {
        return programmed_temperature;
    }

    public void setProgrammed_temperature(int programmed_temperature) {
        this.programmed_temperature = programmed_temperature;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", objects=" + objects +
                ", effective_temperature=" + effective_temperature +
                ", programmed_temperature=" + programmed_temperature +
                ", dateTime=" + dateTime +
                '}';
    }
}
