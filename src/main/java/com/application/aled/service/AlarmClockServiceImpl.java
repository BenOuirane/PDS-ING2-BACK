package com.application.aled.service;

import com.application.aled.entity.AlarmClock;
import com.application.aled.service.AlarmClockService;
import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.repository.AlarmClockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AlarmClockServiceImpl implements AlarmClockService {

    @Autowired
    AlarmClockRepository alarmClockRepository;

    Logger logger = Logger.getLogger("com.application.aled.service.AlarmClockServiceImpl");

    public List<AlarmClock> getAlarmClock(Objects objects){
        logger.info("Getting alarmClocks for object : " + objects);
        List<AlarmClock> alarmClocks = new ArrayList<>();
        alarmClockRepository.findAllByObjects(objects).forEach(alarmClocks::add);
        return alarmClocks;
    }

    @Override
    public boolean updateAlarmClock(AlarmClock alarmClock) {
        logger.info("UpdateAlarmClock param...");
        try{
            alarmClockRepository.save(alarmClock);
            return true;
        }catch (Exception e){
            logger.info("Le réveil n'a pas été correctement mis à jour...! => Error : service.AlarmClockServiceImpl");
            logger.info(e.getMessage());
            return false;
        }
    }
}
