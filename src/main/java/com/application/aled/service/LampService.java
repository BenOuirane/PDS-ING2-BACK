package com.application.aled.service;


import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;

import java.util.List;

public interface LampService {

    List<Lamp> getLamp(Objects objects);
    boolean updateLamp(Lamp lamp);
}
