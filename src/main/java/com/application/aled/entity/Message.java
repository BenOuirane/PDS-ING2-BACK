package com.application.aled.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/*
 * The class 'Message' has TODO nb attributes
 * will become the table 'messages' with three columns :
 * - Id --> This will automaticaly be a sequence on our database
 * - mac_address
 * - Lastname
 */
@XmlRootElement(name="message")
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "mac_address")
    private String mac_address;

    @Column(name = "effective_temperature")
    private String effective_temperature;

    @Column(name = "programmed_temperature")
    private String programmed_temperature;

    @Column(name = "dateTime")
    private Timestamp dateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    public String getEffective_temperature() {
        return effective_temperature;
    }

    public void setEffective_temperature(String effective_temperature) {
        this.effective_temperature = effective_temperature;
    }

    public String getProgrammed_temperature() {
        return programmed_temperature;
    }

    public void setProgrammed_temperature(String programmed_temperature) {
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
                ", mac_address='" + mac_address + '\'' +
                ", effective_temperature='" + effective_temperature + '\'' +
                ", programmed_temperature='" + programmed_temperature + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
