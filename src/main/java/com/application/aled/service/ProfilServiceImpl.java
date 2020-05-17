package com.application.aled.service;

import com.application.aled.entity.Profil;
import com.application.aled.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfilServiceImpl implements ProfilService {

    @Autowired
    ProfilRepository profilRepository;


    @Override
    public Profil getProfilByName(String name) {
        Profil profil;
        profil = profilRepository.findByName(name);
        System.out.println("Profil : " + profil);
        return profil;
    }

    @Override
    public List<Profil> getAllProfil() {
        List<Profil> profil = new ArrayList<Profil>();
        profilRepository.findAll().forEach(profil::add);
        return profil;
    }
}
