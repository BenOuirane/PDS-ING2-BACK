package com.application.aled.service;

import com.application.aled.entity.AlarmClock;
import com.application.aled.entity.Objects;

import java.util.List;

public interface AlarmClockService {

    List<AlarmClock> getAlarmClock(Objects objects);
}
