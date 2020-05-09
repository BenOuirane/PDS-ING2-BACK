package com.application.aled.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profil")
public class Profil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_profil;

    @Column(name = "name")
    private String name;

    @Column(name = "typeProfil1")
    private String typeProfil1;

    @Column(name = "typeProfil2")
    private String typeProfil2;

    @Column(name = "objects")
    private String objects;

    public Profil(){

    }

    public Profil(String name, String typeProfil1, String typeProfil2, String objects) {
        this.name = name;
        this.typeProfil1 = typeProfil1;
        this.typeProfil2 = typeProfil2;
        this.objects = objects;
    }

    public long getId() {
        return id_profil;
    }

    public String getName() {
        return name;
    }

    public String getTypeProfil1() {
        return typeProfil1;
    }

    public void setId(long id_profil) {
        this.id_profil = id_profil;
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

    public String getObjects() {
        return objects;
    }

    public void setObjects(String objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "Profil{" +
                "id_profil=" + id_profil +
                ", name='" + name + '\'' +
                ", typeProfil1='" + typeProfil1 + '\'' +
                ", typeProfil2='" + typeProfil2 + '\'' +
                '}';
    }
}
