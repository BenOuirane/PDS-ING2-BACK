package com.application.aled.service;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Profil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfilService {

    List<Profil> getProfilByObject(Objects object);
}
