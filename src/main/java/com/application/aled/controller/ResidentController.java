package com.application.aled.controller;

import com.application.aled.entity.Residents;
import com.application.aled.entity.User;
import com.application.aled.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ResidentController {

    @Autowired
    ResidentService residentService;

    @PutMapping("/Resident/singleton")
    public Residents getResident(@RequestBody User user){
        System.out.println("Call getResident");

         return residentService.getResidentByUser(user);
    }


}
