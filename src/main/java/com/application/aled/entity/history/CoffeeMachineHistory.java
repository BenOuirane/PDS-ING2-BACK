package com.application.aled.entity.history;

import com.application.aled.entity.Objects;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="coffeeMachineHistory")
public class CoffeeMachineHistory extends ObjectsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCoffeeMachine;

    public CoffeeMachineHistory() {
        super();
    }

    public CoffeeMachineHistory(String data, String columnData, Timestamp messageTimestamp, Objects object) {
        super(data, columnData, messageTimestamp, object);

    }

    public long getIdLampHistory() {
        return idCoffeeMachine;
    }

    public void setIdLampHistory(long idCoffeeMachine) {
        this.idCoffeeMachine = idCoffeeMachine;
    }


    @Override
    public String toString() {
        return "LampHistory{" +
                "idLampHistory=" + idCoffeeMachine +
                ", data='" + super.getData() + '\'' +
                ", columnData='" + super.getColumnData() + '\'' +
                ", messageTimestamp=" + super.getMessageTimestamp() +
                ", object=" + super.getObject().toString() +
                '}';
    }
}
