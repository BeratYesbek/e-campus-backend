package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicDepartmentDao extends JpaRepository<AcademicDepartment, Integer> {
}
