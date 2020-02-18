package com.application.aled.entity.history;

import com.application.aled.entity.Objects;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="ovenHistory")
public class OvenHistory extends ObjectsHistory {

    public OvenHistory() {
        super();
    }

    public OvenHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(data, columnData, messageTimestamp, object);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
