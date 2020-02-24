package com.application.aled.service;

import com.application.aled.entity.Profil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfilService {

    Profil getProfilByName(String name);

    List<Profil> getAllProfil();

}
