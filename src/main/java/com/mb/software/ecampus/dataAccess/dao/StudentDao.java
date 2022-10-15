package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
