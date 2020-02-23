package com.application.aled.repository;

import com.application.aled.entity.Objects;
import com.application.aled.entity.Profil;
import org.springframework.data.repository.CrudRepository;

public interface ProfilRepository  extends CrudRepository<Profil, Long> {

    Profil findByObjects(Objects object);

}
