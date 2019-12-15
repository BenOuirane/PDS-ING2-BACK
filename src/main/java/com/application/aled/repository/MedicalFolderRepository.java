package com.application.aled.repository;

import com.application.aled.entity.MedicalFolder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalFolderRepository extends JpaRepository<MedicalFolder,Long> {
}
