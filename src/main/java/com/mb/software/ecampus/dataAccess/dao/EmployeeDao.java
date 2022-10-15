package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
