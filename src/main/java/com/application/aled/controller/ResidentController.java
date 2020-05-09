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
import java.util.logging.Logger;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class ResidentController {

    @Autowired
    private ResidentServiceImpl residentService;

    Logger logger = Logger.getLogger("com.application.aled.controller.ResidentController");

    @PutMapping(value = "/resident/singleton")
    public Resident getResident(@RequestBody User user) {
        logger.info("Call getResident");
        Resident _resident = residentService.getResidentByUser(user);
        logger.info("getResident :" + _resident);
        return _resident;
    }

    @PutMapping(value = "/resident")
    public Resident getResidentByRoom(@RequestBody Rooms room) {
        Resident _resident = residentService.getResidentByRoom(room);
        return _resident;
    }

    private ResidentRepository residentRepository;

    @DeleteMapping(value = "/resident/{idResident}")
    public void deleteCategory(@PathVariable(name = "idResident") Long idResident) {
        residentRepository.deleteById(idResident);
    }

}


