package com.application.aled.entity.history;

import com.application.aled.entity.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class ObjectsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "data")
    private String data;

    @Column(name = "columnData")
    private String columnData;

    @Column(name = "messageTimestamp")
    private Timestamp messageTimestamp;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_objects", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Objects object;

    public ObjectsHistory() {
    }

    public ObjectsHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        this.data = data;
        this.columnData = columnData;
        this.messageTimestamp = messageTimestamp;
        this.object = object;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getColumnData() {
        return columnData;
    }

    public void setColumnData(String columnData) {
        this.columnData = columnData;
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
                "id='" + id + '\'' +
                "data='" + data + '\'' +
                ", columnData='" + columnData + '\'' +
                ", messageTimestamp=" + messageTimestamp +
                ", object=" + object +
                '}';
    }
}
