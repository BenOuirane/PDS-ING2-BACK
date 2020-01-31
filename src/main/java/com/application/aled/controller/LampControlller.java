package com.application.aled.controller;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.service.LampServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LampControlller {

    @Autowired
    LampServiceImpl lampService;

    @PutMapping("/lamp/list")
    public List<Lamp> getLampes(@RequestBody Objects objects){
        List<Lamp> lamp =  lampService.getLamp(objects);
        System.out.println("Call getLampes" + lamp);
        return lamp;

    }

    @PutMapping ("/lamp/updateParam")
    public boolean updateLampes(@RequestBody Lamp lamp){
        System.out.println("Call controller.updateLampes");
        return lampService.updateLamp(lamp);
    }


}
