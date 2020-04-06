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
import java.util.logging.Logger;

@Service
@EnableAsync (proxyTargetClass = true)
public class OvenServiceImpl extends Thread  implements OvenService{
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
            if(oven.getStatus() == true && oven.getEffectiveTemp() != oven.getProgramTemp()){

                if (Thread.currentThread().getName().equals("ChangeTemp") && Thread.currentThread().isAlive()){
                    Thread.currentThread().interrupt();
                }
                run("ON", oven);
            }
            else if(oven.getStatus() == false && oven.getEffectiveTemp() != 0){
                if (Thread.currentThread().getName().equals("ChangeTemp") && Thread.currentThread().isAlive()){
                    Thread.currentThread().interrupt();
                }
                run("OFF", oven);
            }

            ovenRepository.save(oven);
            return true;
        }catch (Exception e){
            logger.info("Le four n'a pas été correctement mis à jour...! => Error : service.OvenServiceImpl");
            logger.info(e.getMessage());
            return false;
        }
    }



    @Async
    public void run(String param, Oven oven) throws InterruptedException{
        Thread.currentThread().setName("ChangeTemp");
        if(param.equals("ON")){
            if(oven.getEffectiveTemp() < oven.getProgramTemp()){
                while(oven.getEffectiveTemp() < oven.getProgramTemp()) {
                    oven.setEffectiveTemp(oven.getEffectiveTemp() + 1);
                    ovenRepository.save(oven);
                    Thread.sleep(500);
                }
            }
            else if(oven.getEffectiveTemp() > oven.getProgramTemp()){
                while (oven.getEffectiveTemp() > oven.getProgramTemp()) {
                    oven.setEffectiveTemp((oven.getEffectiveTemp() - 1));
                    ovenRepository.save(oven);
                    Thread.sleep(500);
                }
            }
        } else if (param.equals("OFF")){
           while(oven.getEffectiveTemp() != 0){
               oven.setEffectiveTemp((oven.getEffectiveTemp() -1));
               ovenRepository.save(oven);
               Thread.sleep(500);
           }
        }

        if (Thread.currentThread().getName().equals("ChangeTemp") && Thread.currentThread().isAlive()){
            Thread.currentThread().interrupt();
        }

    }
}
