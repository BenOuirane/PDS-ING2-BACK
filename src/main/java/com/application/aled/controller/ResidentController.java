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
<<<<<<< Updated upstream
    private ResidentRepository residentRepository;

=======
    private ResidentServiceImpl residentService;
    /*
>>>>>>> Stashed changes
    public ResidentController(ResidentRepository residentRepository) {
        super();
        this.residentRepository = residentRepository;
        
    }

    @GetMapping(value = "/resident")
    Collection<Resident> resident(){
        return residentRepository.findAll();
    }

    @GetMapping(value = "/resident/{idResident}")
    public Resident residentById(@PathVariable(name = "idResident") Long idResident){
        return residentRepository.findById(idResident).get();
    }

    @PostMapping(value = "/resident")
    public Resident saveCategory(@RequestBody Resident res){
        return residentRepository.save(res);
    }

    @PutMapping(value = "/resident/{idResident}")
    public Resident updateCategory(@PathVariable(name = "idResident") Long idResident, @RequestBody Resident res) {
        res.setIdResident(idResident);
        return residentRepository.save(res);
    }
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes

    @DeleteMapping(value = "/resident/{idResident}")
    public void deleteCategory(@PathVariable(name = "idResident") Long idResident) {
        residentRepository.deleteById(idResident);
    }
     */


    @PutMapping(value = "/resident/singleton")
    public Residents getResident(@RequestBody User user) {
        System.out.println("Call getResident");
        Residents _resident = residentService.getResidentByUser(user);
        System.out.println("getResident" + _resident);
        return _resident;
    }


}


