package com.application.aled.entity.history;

import com.application.aled.entity.Objects;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="lampHistory")
public class LampHistory extends ObjectsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idLampHistory;

    public LampHistory() {
        super();
    }

    public LampHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(data, columnData, messageTimestamp, object);

    }

    public long getIdLampHistory() {
        return idLampHistory;
    }

    public void setIdLampHistory(long idLampHistory) {
        this.idLampHistory = idLampHistory;
    }


    @Override
    public String toString() {
        return "LampHistory{" +
                "idLampHistory=" + idLampHistory +
                ", data='" + super.getData() + '\'' +
                ", columnData='" + super.getColumnData() + '\'' +
                ", messageTimestamp=" + super.getMessageTimestamp() +
                ", object=" + super.getObject().toString() +
                '}';
    }
}
