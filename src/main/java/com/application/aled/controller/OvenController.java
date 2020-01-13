package com.application.aled.controller;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Oven;
import com.application.aled.service.OvenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OvenController {


    @Autowired
    OvenServiceImpl ovenService;

    @PutMapping("/oven/list")
    public List<Oven> getOvens(@RequestBody Objects objects){
        System.out.println("Call getOvensObject" + objects);
        List<Oven> ovens =  ovenService.getOven(objects);
        System.out.println("Call getOvens" + ovens);
        return ovens;

    }
}
