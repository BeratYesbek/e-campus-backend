package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.core.entities.OperationClaim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationClaimsDao extends JpaRepository<OperationClaim, Integer> {
    OperationClaim findByName(String name);
}
