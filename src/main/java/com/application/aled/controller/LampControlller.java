package com.application.aled.controller;

import com.application.aled.entity.Lamp;
import com.application.aled.entity.Objects;
import com.application.aled.service.LampServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LampControlller {

    LampServiceImpl lampService;

    @PutMapping("/lamp/list")
    public List<Lamp> getLampes(@RequestBody Objects objects){
        System.out.println("Call getLampes");

        return lampService.getLamp(objects);

    }


}
