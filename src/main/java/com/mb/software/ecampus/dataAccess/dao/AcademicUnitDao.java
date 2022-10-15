package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicUnitDao extends JpaRepository<AcademicUnit, Integer> {
}
