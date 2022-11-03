package com.mb.software.ecampus.core.dataAccess;

import com.mb.software.ecampus.core.entities.DbLog;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface LoggingDao extends JpaRepository<DbLog, Integer> {
}
