package com.application.aled.controller;

import com.application.aled.entity.Profil;
import com.application.aled.service.ProfilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProfilController {

    @Autowired
    ProfilServiceImpl profilService;

    @GetMapping("/subscription")
    public List<Profil> getAllProfil(){
        List<Profil> profil = profilService.getAllProfil();

        return profil;
    }

    @GetMapping("/subscription/")
    public Profil getProfilByName(String name){
        Profil profil = profilService.getProfilByName(name);

        return profil;
    }
}
