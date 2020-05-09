package com.application.aled.controller;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.service.LampServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LampController {

    @Autowired
    LampServiceImpl lampService;

    Logger logger = Logger.getLogger("com.application.aled.controller.LampController");

    @PutMapping("/lamp/list")
    public List<Lamp> getLampes(@RequestBody Objects objects){
        List<Lamp> lamp =  lampService.getLamp(objects);
        logger.info("Call getLampes" + lamp);
        return lamp;

    }

    @PutMapping("/lamp/updateParam")
    public boolean updateLampes(@RequestBody Lamp lamp){
        logger.info("Call updateLampes :" + lamp.toString());
        return lampService.updateLamp(lamp);
    }


}
