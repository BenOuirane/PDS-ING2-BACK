package com.application.aled.controller;

import com.application.aled.entity.Residents;
import com.application.aled.entity.User;
import com.application.aled.repository.ResidentRepository;
import com.application.aled.entity.Resident;
import com.application.aled.service.ResidentService;
import com.application.aled.service.ResidentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class ResidentController {

    @Autowired
    private ResidentServiceImpl residentService;

    @PutMapping(value = "/resident/singleton")
    public Residents getResident(@RequestBody User user) {
        System.out.println("Call getResident");
        Residents _resident = residentService.getResidentByUser(user);
        System.out.println("getResident" + _resident);
        return _resident;
    }


}


