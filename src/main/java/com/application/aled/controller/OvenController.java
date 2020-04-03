package com.application.aled.controller;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import com.application.aled.service.OvenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OvenController {


    @Autowired
    OvenServiceImpl ovenService;

    Logger logger = Logger.getLogger("com.application.aled.controller.OvenController");

    @PutMapping("/oven/list")
    public List<Oven> getOvens(@RequestBody Objects objects){
        logger.info("Call getOvensObject" + objects);
        List<Oven> ovens =  ovenService.getOven(objects);
        logger.info("Call getOvens" + ovens);
        return ovens;
    }

    @PutMapping("/oven/updateParam")
    public boolean updateOven(@RequestBody Oven oven){
        logger.info("Call updateOven :" + oven.toString());
        return ovenService.updateOven(oven);
    }
}
