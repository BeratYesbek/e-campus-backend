package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.EmployeeDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDepartmentDao extends JpaRepository<EmployeeDepartment, Integer> {
}
