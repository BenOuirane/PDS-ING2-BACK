package com.application.aled.repository;

import com.application.aled.entity.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence,Long>{
    @Query("select r.idResidence from Residence r")
    int[] findResidence();
    //@Query("select size(r.resident) from Residence r where r.id=:id")
    //int countByResidenceId(int id);

}
