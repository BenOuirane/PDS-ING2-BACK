package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Rooms;
import com.application.aled.repository.ObjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.application.aled.repository.RoomRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Transient;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    RoomRepository roomRepository;

    Logger logger = Logger.getLogger("com.application.aled.service.ObjectServiceImpl");
    public List<Objects> getObjectByRoom(Rooms room) {
       List <Objects> objects = new ArrayList<Objects>();
       objectRepository.findByRooms(room).forEach(objects::add);
        logger.info("getObjectByRoom" + objects);
       return objects;
    }
    
    public List<Objects> getObjects() {
        List <Objects> objects = new ArrayList<Objects>();
        objectRepository.findAll().forEach(objects::add);
        return objects;
    }

    @Override
    public List<Objects> getObjectsByObjectType(String objectType) {
        List <Objects> objects = new ArrayList<Objects>();
        objectRepository.findByObjectType(objectType).forEach(objects::add);
        return objects;
    }

    public List<Objects> getObjectByState(boolean state) {
        List <Objects> objects = new ArrayList<Objects>();
        objectRepository.findByState(state).forEach(objects::add);
        logger.info("getObjectByState with state "+state+"return: " + objects);
        return objects;
    }

    @Override
    public Objects updateObjects(Objects objects) {
        Objects _objects = objectRepository.save(objects);
        return _objects;
    }

    @Override
    public boolean scenarioLaunchService(ScenarioMyMorning scenarioMyMorning){
        Lamp lamp = scenarioMyMorning.getLamp();
        Shutter shutter = scenarioMyMorning.getShutter();
        AlarmClock alarmClock = scenarioMyMorning.getAlarmClock();
        CoffeeMachine coffeeMachine = scenarioMyMorning.getCoffeeMachine();


        Date time = new Date(Long.parseLong("1587103200000")); //8h00

         lamp.setHourOn((alarmClock.getAlarm() != null )?alarmClock.getAlarm() : new Timestamp(time.getTime()));
         lamp.setStatus(true);
         lamp.setColor("YELLOW");

         shutter.setHourOn((alarmClock.getAlarm() != null )?alarmClock.getAlarm() : new Timestamp(time.getTime()));
         shutter.setStatus(true);

         alarmClock.setAlarm((alarmClock.getAlarm() != null )?alarmClock.getAlarm() : new Timestamp(time.getTime()));
         alarmClock.setAlarmStatus(true);

         coffeeMachine.setStatus(true);
         coffeeMachine.setScheduleCoffee((alarmClock.getAlarm() != null )?alarmClock.getAlarm() : new Timestamp(time.getTime()));

         try {
             lampRepository.save(lamp);
             coffeeMachineRepository.save(coffeeMachine);
             alarmClockRepository.save(alarmClock);
             shutterRepository.save(shutter);
             return true;
         }catch (Exception e){
             logger.info("ERROR : ObjectServiceImpl.scenarioLaunchService : " + e);
             return false;
         }
    }

    @Override
    public Objects getObjectsById(long id) {
        Objects _objects = objectRepository.findById(id);
        return _objects;
    }

}
