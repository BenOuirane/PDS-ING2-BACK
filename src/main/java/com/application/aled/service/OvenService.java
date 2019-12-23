package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;

import java.util.List;

public interface OvenService {

    List<Oven> getOven(Objects objects);
}
