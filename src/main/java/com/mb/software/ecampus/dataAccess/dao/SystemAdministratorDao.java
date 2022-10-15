package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.entities.concretes.SystemAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemAdministratorDao extends JpaRepository<SystemAdministrator, Integer> {
}
