package com.application.aled.controller;

import com.application.aled.entity.Rooms;
import com.application.aled.entity.User;
import com.application.aled.repository.ResidentRepository;
import com.application.aled.entity.Resident;
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
    public Resident getResident(@RequestBody User user) {
        System.out.println("Call getResident");
        Resident _resident = residentService.getResidentByUser(user);
        System.out.println("getResident :" + _resident);
        return _resident;
    }

    private ResidentRepository residentRepository;

    @DeleteMapping(value = "/resident/{idResident}")
    public void deleteCategory(@PathVariable(name = "idResident") Long idResident) {
        residentRepository.deleteById(idResident);
    }

    @GetMapping(value = "/residents")
    public List<Resident> getAllResidents() {
        List<Resident> residents = residentService.getAllResidents();
        return residents;
    }

    @GetMapping(value = "/resident/{idResident}")
    public Resident getResidentById(@PathVariable(name = "idResident") Long idResident) {
        Resident resident = residentService.getResidentById(idResident);
        return resident;
    }

}


