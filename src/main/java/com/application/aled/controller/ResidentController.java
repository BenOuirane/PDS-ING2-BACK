package com.application.aled.controller;

import com.application.aled.repository.ResidentRepository;
import com.application.aled.entity.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class ResidentController {

    @Autowired
    private ResidentRepository residentRepository;
    /*
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
    */

    @DeleteMapping(value = "/resident/{idResident}")
    public void deleteCategory(@PathVariable(name = "idResident") Long idResident) {
        residentRepository.deleteById(idResident);
    }

}


