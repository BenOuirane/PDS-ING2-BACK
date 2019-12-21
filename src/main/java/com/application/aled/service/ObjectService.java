package com.application.aled.service;

import com.application.aled.entity.Object;
import com.application.aled.entity.Rooms;
import java.util.List;

public interface ObjectService {

    List<Object> getObjectByRoom(Rooms room);
}
