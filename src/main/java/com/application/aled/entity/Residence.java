package com.application.aled.entity;

import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Residence{

    @Id
    @Column(name = "idResidence")
    private int idResidence;
    private String name;
    //@Formula("(select count(*) from Resident r where r.idResidence=idResidence) ")
    private int numberOfResident;
    @OneToMany(fetch = FetchType.LAZY , mappedBy="residence")
    private List<Resident> residents;

    public Residence() {
        super();
    }
    public Residence(int idResidence, String name, int numberOfResident) {
        this.idResidence = idResidence;
        this.name = name;
        this.numberOfResident=numberOfResident;

    }

    public int getNumberOfResident() {
        return numberOfResident;
    }

    public void setNumberOfResident(int numberOfResident) {
        this.numberOfResident = numberOfResident;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdResidence() {
        return idResidence;
    }

    public void setIdResidence(int idResidence) {
        this.idResidence = idResidence;
    }


}
