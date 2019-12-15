package com.application.aled.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MedicalFolder implements Serializable {
    @Id
    @GeneratedValue
    private Long idMedicalFolder;
    private Long idResident;
    private Integer age;
    private String bloodGroup;
    private Date lastDiagnostic;
    private String medicalFolderArchive;

    public MedicalFolder() {
        super();
    }

    public MedicalFolder(Long idMedicalFolder, Long idResident, Integer age, String bloodGroup,
                         Date lastDiagnostic, String medicalFolderArchive) {
        this.idMedicalFolder = idMedicalFolder;
        this.idResident = idResident;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.lastDiagnostic = lastDiagnostic;
        this.medicalFolderArchive = medicalFolderArchive;
    }

    @Override
    public String toString() {
        return "MedicalFolder{" +
                "idMedicalFolder=" + idMedicalFolder +
                ", idResident=" + idResident +
                ", age=" + age +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", lastDiagnostic=" + lastDiagnostic +
                ", medicalFolderArchive='" + medicalFolderArchive + '\'' +
                '}';
    }

    public Long getIdMedicalFolder() {
        return idMedicalFolder;
    }

    public void setIdMedicalFolder(Long idMedicalFolder) {
        this.idMedicalFolder = idMedicalFolder;
    }

    public Long getIdResident() {
        return idResident;
    }

    public void setIdResident(Long idResident) {
        this.idResident = idResident;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getLastDiagnostic() {
        return lastDiagnostic;
    }

    public void setLastDiagnostic(Date lastDiagnostic) {
        this.lastDiagnostic = lastDiagnostic;
    }

    public String getMedicalFolderArchive() {
        return medicalFolderArchive;
    }

    public void setMedicalFolderArchive(String medicalFolderArchive) {
        this.medicalFolderArchive = medicalFolderArchive;
    }
}
