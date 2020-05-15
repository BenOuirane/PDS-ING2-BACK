package com.application.aled.service;


import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;

import java.util.List;

public interface ShutterService {

    List<Shutter> getShutter(Objects objects);
    boolean updateShutter(Shutter shutter);
}
