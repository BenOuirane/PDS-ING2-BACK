package com.application.aled.entity.history;

import com.application.aled.entity.Objects;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="alarmClockHistory")
public class AlarmClockHistory extends ObjectsHistory {

    public AlarmClockHistory() {
        super();
    }

    public AlarmClockHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(data, columnData, messageTimestamp, object);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
