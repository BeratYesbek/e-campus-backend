package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.AcademicPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicPersonalDao extends JpaRepository<AcademicPersonal,Integer> {
}
