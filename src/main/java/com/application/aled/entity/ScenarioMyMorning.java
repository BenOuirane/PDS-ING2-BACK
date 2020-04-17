package com.application.aled.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/*@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lamp",
        "shutter",
        "alarmClock",
        "coffeeMachine"
})*/
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ScenarioMyMorning {

    //@JsonProperty ("alarmClock")
    private AlarmClock alarmClock;

    //@JsonProperty("shutter")
    private Shutter shutter;

    //@JsonProperty("lamp")
    private Lamp lamp;

    //@JsonProperty("coffeeMachine")
    private CoffeeMachine coffeeMachine;

    public ScenarioMyMorning(){
        super();
    }

    public ScenarioMyMorning(AlarmClock alarmClock, Shutter shutter, Lamp lamp, CoffeeMachine coffeeMachine) {
        this.alarmClock = alarmClock;
        this.shutter = shutter;
        this.lamp = lamp;
        this.coffeeMachine = coffeeMachine;
    }

    public AlarmClock getAlarmClock() {
        return alarmClock;
    }

    public void setAlarmClock(AlarmClock alarmClock) {
        this.alarmClock = alarmClock;
    }

    public Shutter getShutter() {
        return shutter;
    }

    public void setShutter(Shutter shutter) {
        this.shutter = shutter;
    }

    public Lamp getLamp() {
        return lamp;
    }

    public void setLamp(Lamp lamp) {
        this.lamp = lamp;
    }

    public CoffeeMachine getCoffeeMachine() {
        return coffeeMachine;
    }

    public void setCoffeeMachine(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

}
