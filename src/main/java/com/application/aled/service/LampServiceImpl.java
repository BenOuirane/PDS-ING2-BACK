package com.application.aled.service;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Notification;
import com.application.aled.entity.Objects;
import com.application.aled.repository.LampRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LampServiceImpl implements LampService {

    @Autowired
    LampRepository lampRepository;

    @Override
    public List<Lamp> getLamp(Objects objects) {
        System.out.println("Getting lamp for object : " + objects);
        return lampRepository.getLampByObject(objects);
    }
}
