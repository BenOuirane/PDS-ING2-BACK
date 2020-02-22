package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Profil;
import com.application.aled.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class ProfilServiceImpl implements ProfilService {

    @Autowired
    ProfilRepository profilRepository;

    @Transactional
    public List<Profil> getProfilByObject(Objects object) {
        List<Profil> profil = new ArrayList<>();
       // profilRepository.findByObjects(object).forEach(profil::add);

        System.out.println("Profil by Object: " + profil);
        return profil;
    }
}
