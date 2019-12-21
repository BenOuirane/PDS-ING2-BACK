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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sender", referencedColumnName = "id")
    private User sender;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "receiver", referencedColumnName = "id")
    private User receiver;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
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

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
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

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
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
                ", customData='" + customData + '\'' +
                '}';
    }
}
