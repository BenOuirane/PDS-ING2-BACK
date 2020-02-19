package com.application.aled.controller;


import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import com.application.aled.service.ShutterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ShutterController {

    @Autowired
    ShutterServiceImpl shutterService;

    @PutMapping("/shutter/list")
    public List<Shutter> getShutter(@RequestBody Objects objects){
        List<Shutter> shutters =  shutterService.getShutter(objects);
        System.out.println("Call getShutter " + shutters);
        return shutters;

    }

    @PutMapping("/shutter/updateParam")
    public boolean updateShutters(@RequestBody Shutter shutter){
        System.out.println("Call updateShutters :" + shutter.toString());
        return shutterService.updateShutter(shutter);
    }
}
