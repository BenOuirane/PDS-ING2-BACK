package com.application.aled.entity.history;

import com.application.aled.entity.Objects;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="alarmClockHistory")
public class AlarmClockHistory extends ObjectsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAlarmClock;

    public AlarmClockHistory() {
        super();
    }

    public AlarmClockHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(data, columnData, messageTimestamp, object);

    }

    public long getIdLampHistory() {
        return idAlarmClock;
    }

    public void setIdLampHistory(long idAlarmClock) {
        this.idAlarmClock = idAlarmClock;
    }


    @Override
    public String toString() {
        return "LampHistory{" +
                "idLampHistory=" + idAlarmClock +
                ", data='" + super.getData() + '\'' +
                ", columnData='" + super.getColumnData() + '\'' +
                ", messageTimestamp=" + super.getMessageTimestamp() +
                ", object=" + super.getObject().toString() +
                '}';
    }
}
