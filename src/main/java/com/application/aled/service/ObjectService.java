package com.application.aled.service;

import com.application.aled.entity.*;

import java.util.List;

public interface ObjectService {

    List<Objects> getObjectByRoom(Rooms room);

    List<Objects> getObjects();

    List<Objects> getObjectsByObjectType(String objectType);

    List<Objects> getObjectByState(boolean state);

    Objects updateObjects(Objects objects);

    boolean scenarioLaunchService(ScenarioMyMorning scenarioMyMorning);
}
