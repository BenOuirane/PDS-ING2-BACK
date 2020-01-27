package com.application.aled.service;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import com.application.aled.repository.OvenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OvenServiceImpl implements OvenService {
    @Autowired
    OvenRepository ovenRepository;

    @Override
    public List<Oven> getOven(Objects objects) {
        System.out.println("Getting oven for object : " + objects);
        List<Oven> ovens = new ArrayList<>();
        ovenRepository.findAllByObjects(objects).forEach(ovens::add);
        System.out.println("Getting oven for object 2 : " + ovens);
        return ovens;
    }
}
