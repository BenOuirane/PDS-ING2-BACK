package com.application.aled.service;


import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import com.application.aled.repository.ShutterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ShutterServiceImpl implements ShutterService{

    @Autowired
    ShutterRepository shutterRepository;

    Logger logger = Logger.getLogger("com.application.aled.controller.ResidentServiceImpl");

    @Override
    public List<Shutter> getShutter(Objects objects) {
        logger.info("Getting Shutter for object : " + objects);
        List<Shutter> shutters = new ArrayList<>();
        shutterRepository.findAllByObjects(objects).forEach(shutters::add);
        return shutters;
    }

    @Override
    public boolean updateShutter(Shutter shutter) {
        logger.info("Update shutter param...");
        try{
            shutterRepository.save(shutter);
            return true;
        }catch (Exception e){
            logger.info("Le volet n'a pas été correctement mis à jour...! => Error : service.ShutterServiceImpl");
            logger.info(e.getMessage());
            return false;
        }
    }
}
