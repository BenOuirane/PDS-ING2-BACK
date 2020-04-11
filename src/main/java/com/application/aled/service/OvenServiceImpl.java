package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import com.application.aled.repository.OvenRepository;
import com.application.aled.service.runnableservice.ScenarioTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@EnableAsync(proxyTargetClass = true)
public class OvenServiceImpl implements OvenService {
    @Autowired
    OvenRepository ovenRepository;
    private ScenarioTemp t;

    Logger logger = Logger.getLogger("com.application.aled.controller.OvenController");

    @Override
    public List<Oven> getOven(Objects objects) {
        List<Oven> ovens = new ArrayList<>();
        ovenRepository.findAllByObjects(objects).forEach(ovens::add);
        return ovens;
    }



    @Override
    public boolean updateOven(Oven oven) {
        logger.info("Update oven param...");
        try {
            if (oven.getStatus() == true && oven.getEffectiveTemp() != oven.getProgramTemp()) {
                try {
                    if (t != null) {
                        t.stop();
                    }
                    t = new ScenarioTemp(oven, "ON", ovenRepository);
                } catch (Exception e) {
                    logger.info("Le thread n'a pas été arrété correctement => Error : service.OvenServiceImpl");
                    logger.info(e.getMessage());
                }

            } else if (oven.getStatus() == false && oven.getEffectiveTemp() != 0) {
                try {
                    if (t != null) {
                       t.stop();
                    }
                    t = new ScenarioTemp(oven, "OFF", ovenRepository);
                } catch (Exception e) {
                    logger.info("Le thread n'a pas été arrété correctement => Error : service.OvenServiceImpl");
                    logger.info(e.getMessage());
                }
            }
            ovenRepository.save(oven);
            return true;
        } catch (Exception e) {
            logger.info("Le four n'a pas été correctement mis à jour...! => Error : service.OvenServiceImpl");
            logger.info(e.getMessage());
            return false;
        }
    }

}
