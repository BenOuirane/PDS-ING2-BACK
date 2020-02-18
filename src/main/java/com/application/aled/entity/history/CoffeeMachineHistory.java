package com.application.aled.entity.history;

import com.application.aled.entity.Objects;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="coffeeMachineHistory")
public class CoffeeMachineHistory extends ObjectsHistory {

    public CoffeeMachineHistory() {
        super();
    }

    public CoffeeMachineHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(data, columnData, messageTimestamp, object);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
