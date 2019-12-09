package com.application.aled.entity;

import com.application.aled.controller.exception.CustomHandler;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sender")
    private long sender;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "receiver")
    private long receiver;

    @CreationTimestamp
    private Date date;

    @Column(name = "state")
    private String state;

    @Column(name = "type")
    private String type;

    @Column(name = "customData")
    private String customData;

    public Notification() {
    }

    public Notification(long sender, String title, String message, long receiver, String state, String type, String customData) {
        this.sender = sender;
        this.title = title;
        this.message = message;
        this.receiver = receiver;
        this.state = state;
        this.type = type;
        this.customData = customData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSender() {
        return sender;
    }

    public void setSender(long sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getReceiver() {
        return receiver;
    }

    public void setReceiver(long receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        for (StateType stateType : StateType.values()) {
            if(state.equals(stateType.name())){
                this.state = state;
                return;
            }
        }
        throw new CustomHandler("StateType not respected");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        for (NotificationType notificationType : NotificationType.values()) {
            if(type.equals(notificationType.name())){
                this.type = type;
                return;
            }
        }
        throw new CustomHandler("Notification Type not respected");
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", sender=" + sender +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", receiver=" + receiver +
                ", date=" + date +
                ", state='" + state + '\'' +
                ", type='" + type + '\'' +
                ", customData=" + customData +
                '}';
    }
}
