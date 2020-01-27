package com.application.aled.repository;

import com.application.aled.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence,Long>{
    //@Query("select size(r.resident) from Residence r where r.id=:id")
    //int countByResidenceId(int id);

}
