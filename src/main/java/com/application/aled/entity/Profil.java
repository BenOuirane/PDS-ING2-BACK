package com.application.aled.entity;

import javax.persistence.*;

@Entity
@Table(name = "profil")
public class Profil {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "typeProfil1")
    private String typeProfil1;

    @Column(name = "typeProfil2")
    private String typeProfil2;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypeProfil1() {
        return typeProfil1;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeProfil(String typeProfil1) {
        for (TypeProfil typeProfils : TypeProfil.values()) {
            if (typeProfil1.equals(typeProfils.name())) {
                this.typeProfil1 = typeProfil1;
                return;
            }
        }
    }

    public String getTypeProfil2() {
        return typeProfil2;
    }

    public void setTypeProfil2(String typeProfil2) {
        for (TypeProfil typeProfils : TypeProfil.values()) {
            if (typeProfil2.equals(typeProfils.name())) {
                this.typeProfil2 = typeProfil2;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Profil{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeProfil1='" + typeProfil1 + '\'' +
                ", typeProfil2='" + typeProfil2 + '\'' +
                '}';
    }
}
