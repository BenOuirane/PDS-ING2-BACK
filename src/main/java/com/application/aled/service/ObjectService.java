package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Rooms;
import java.util.List;

public interface ObjectService {

    List<Objects> getObjectByRoom(Rooms room);

    List<Objects> getObjects();

    List<Objects> getObjectsByObjectType(String objectType);
}
