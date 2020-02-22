package com.application.aled.service;


import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import com.application.aled.repository.ShutterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShutterServiceImpl implements ShutterService{

    @Autowired
    ShutterRepository shutterRepository;
    @Override
    public List<Shutter> getShutter(Objects objects) {
        System.out.println("Getting Shutter for object : " + objects);
        List<Shutter> shutters = new ArrayList<>();
        shutterRepository.findAllByObjects(objects).forEach(shutters::add);
        return shutters;
    }

    @Override
    public boolean updateShutter(Shutter shutter) {
        System.out.println("Update shutter param...");
        try{
            shutterRepository.save(shutter);
            return true;
        }catch (Exception e){
            System.out.println("Le volet n'a pas été correctement mis à jour...! => Error : service.ShutterServiceImpl");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
