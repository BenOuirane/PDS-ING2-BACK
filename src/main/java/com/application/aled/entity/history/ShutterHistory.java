package com.application.aled.entity.history;

import com.application.aled.entity.Objects;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="shutterHistory")
public class ShutterHistory extends ObjectsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idShutter;

    public ShutterHistory() {
        super();
    }

    public ShutterHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(data, columnData, messageTimestamp, object);

    }

    public long getIdLampHistory() {
        return idShutter;
    }

    public void setIdLampHistory(long idShutter) {
        this.idShutter = idShutter;
    }


    @Override
    public String toString() {
        return "LampHistory{" +
                "idLampHistory=" + idShutter +
                ", data='" + super.getData() + '\'' +
                ", columnData='" + super.getColumnData() + '\'' +
                ", messageTimestamp=" + super.getMessageTimestamp() +
                ", object=" + super.getObject().toString() +
                '}';
    }
}
