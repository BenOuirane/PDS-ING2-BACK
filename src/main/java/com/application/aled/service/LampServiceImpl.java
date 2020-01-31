package com.application.aled.service;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.repository.LampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LampServiceImpl implements LampService {

    @Autowired
    LampRepository lampRepository;

    @Override
    public List<Lamp> getLamp(Objects objects) {
        System.out.println("Getting lamp for object : " + objects);
        List<Lamp> lamps = new ArrayList<>();
        lampRepository.findAllByObjects(objects).forEach(lamps::add);
        return lamps;
    }

    @Override
    public boolean updateLamp(Lamp lamp) {
        System.out.println("Update lamp param...");
        try{
            lampRepository.save(lamp);
            return true;
        }catch (Exception e){
            System.out.println("La lampe n'a pas été correctement mise à jour...! => Error : service.lampServiceImpl");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
