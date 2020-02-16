package com.application.aled.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class ObjectsHistory {

    @Column(name = "messageTimestamp")
    private Timestamp messageTimestamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_objects", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Objects object;

    public ObjectsHistory() {
    }

    public ObjectsHistory(Timestamp messageTimestamp, Objects object) {
        this.messageTimestamp = messageTimestamp;
        this.object = object;
    }

    public Timestamp getMessageTimestamp() {
        return messageTimestamp;
    }

    public void setMessageTimestamp(Timestamp messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
    }

    public Objects getObject() {
        return object;
    }

    public void setObject(Objects object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ObjectsHistory{" +
                "messageTimestamp=" + messageTimestamp +
                ", object=" + object +
                '}';
    }
}
