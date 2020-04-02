package com.application.aled.service;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import com.application.aled.entity.Shutter;
import com.application.aled.repository.OvenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class OvenServiceImpl implements OvenService {
    @Autowired
    OvenRepository ovenRepository;

    Logger logger = Logger.getLogger("com.application.aled.controller.OvenController");

    @Override
    public List<Oven> getOven(Objects objects) {
        logger.info("Getting oven for object : " + objects);
        List<Oven> ovens = new ArrayList<>();
        ovenRepository.findAllByObjects(objects).forEach(ovens::add);
        return ovens;
    }

    @Override
    public boolean updateOven(Oven oven) {
        logger.info("Update oven param...");
        try{
            ovenRepository.save(oven);
            return true;
        }catch (Exception e){
            logger.info("Le four n'a pas été correctement mis à jour...! => Error : service.OvenServiceImpl");
            logger.info(e.getMessage());
            return false;
        }
    }
}
