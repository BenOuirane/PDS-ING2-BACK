package com.application.aled.controller;


import com.application.aled.entity.Objects;
import com.application.aled.entity.Shutter;
import com.application.aled.service.ShutterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ShutterController {

    @Autowired
    ShutterServiceImpl shutterService;

    Logger logger = Logger.getLogger("com.application.aled.controller.ShutterController");

    @PutMapping("/shutter/list")
    public List<Shutter> getShutter(@RequestBody Objects objects){
        List<Shutter> shutters =  shutterService.getShutter(objects);
        logger.info("Call getShutter " + shutters);
        return shutters;

    }

    @PutMapping("/shutter/updateParam")
    public boolean updateShutters(@RequestBody Shutter shutter){
        logger.info("Call updateShutters :" + shutter.toString());
        return shutterService.updateShutter(shutter);
    }
}
