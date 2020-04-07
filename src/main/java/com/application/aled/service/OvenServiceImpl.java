package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import com.application.aled.repository.OvenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
@EnableAsync(proxyTargetClass = true)
public class OvenServiceImpl extends Thread implements OvenService {
    @Autowired
    OvenRepository ovenRepository;

    Logger logger = Logger.getLogger("com.application.aled.controller.OvenController");

    @Override
    public List<Oven> getOven(Objects objects) {
        List<Oven> ovens = new ArrayList<>();
        ovenRepository.findAllByObjects(objects).forEach(ovens::add);
        return ovens;
    }

    Thread t = new Thread();

    @Override
    public boolean updateOven(Oven oven) {
        logger.info("Update oven param...");
        try {
            if (oven.getStatus() == true && oven.getEffectiveTemp() != oven.getProgramTemp()) {
                try {
                    if (t.isAlive()) {
                        System.out.println("TREAD 1: " + t.getId() + t.getName() + t.isAlive());
                        t.interrupt();
                    }
                    System.out.println("TREAD 1: " + t.getId() + " " + t.getName() + " " +t.isAlive());
                    run("ON", oven);
                } catch (Exception e) {
                    logger.info("Le thread n'a pas été arrété correctement => Error : service.OvenServiceImpl");
                    logger.info(e.getMessage());
                }

            } else if (oven.getStatus() == false && oven.getEffectiveTemp() != 0) {
                try {
                    if (t.currentThread().isAlive()) {
                        t.interrupt();
                    }
                    run("OFF", oven);
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


    @Async
    public void run(String param, Oven oven) throws InterruptedException {
        t.setName("ChangeTemp");
        if (param.equals("ON")) {
            if (oven.getEffectiveTemp() < oven.getProgramTemp()) {
                while (oven.getEffectiveTemp() < oven.getProgramTemp()) {
                    oven.setEffectiveTemp(oven.getEffectiveTemp() + 1);
                    ovenRepository.save(oven);
                    TimeUnit.SECONDS.sleep(3);
                }
            } else if (oven.getEffectiveTemp() > oven.getProgramTemp()) {
                while (oven.getEffectiveTemp() > oven.getProgramTemp()) {
                    oven.setEffectiveTemp((oven.getEffectiveTemp() - 1));
                    ovenRepository.save(oven);
                    TimeUnit.SECONDS.sleep(3);
                }
            }
        } else if (param.equals("OFF")) {
            while (oven.getEffectiveTemp() != 0) {
                oven.setEffectiveTemp((oven.getEffectiveTemp() - 1));
                ovenRepository.save(oven);
                TimeUnit.SECONDS.sleep(3);
            }
        }

        t.interrupt();

    }
}
