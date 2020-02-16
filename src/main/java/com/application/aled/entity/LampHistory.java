package com.application.aled.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="lampHistory")
public class LampHistory extends ObjectsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLampHistory;

    @Column(name = "data")
    private String data;

    @Column(name = "columnData")
    private String columnData;


    public LampHistory() {
        super();
    }

    public LampHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(messageTimestamp, object);
        this.data = data;
        this.columnData = columnData;
    }

    public long getIdLampHistory() {
        return idLampHistory;
    }

    public void setIdLampHistory(long idLampHistory) {
        this.idLampHistory = idLampHistory;
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


    @Override
    public String toString() {
        return "LampHistory{" +
                "idLampHistory=" + idLampHistory +
                ", data='" + data + '\'' +
                ", columnData='" + columnData + '\'' +
                ", messageTimestamp=" + super.getMessageTimestamp() +
                ", object=" + super.getObject().toString() +
                '}';
    }
}
