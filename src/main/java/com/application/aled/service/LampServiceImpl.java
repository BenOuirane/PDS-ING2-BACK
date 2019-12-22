package com.application.aled.service;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Notification;
import com.application.aled.entity.Objects;
import com.application.aled.entity.User;
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
<<<<<<< Updated upstream
        return lampRepository.getLampByObject(objects);
=======
        List<Lamp> lamps = new ArrayList<>();
        lampRepository.findAllByObjects(objects).forEach(lamps::add);
        return lamps;
>>>>>>> Stashed changes
    }
}
