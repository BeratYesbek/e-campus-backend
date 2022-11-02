package com.mb.software.ecampus.core.dataAccess;

import com.mb.software.ecampus.core.entities.DbLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggingDao extends JpaRepository<DbLog, Integer> {
}
