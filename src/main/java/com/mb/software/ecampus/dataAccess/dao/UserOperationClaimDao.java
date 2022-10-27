package com.mb.software.ecampus.dataAccess.dao;

import com.mb.software.ecampus.core.entities.UserOperationClaim;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOperationClaimDao extends JpaRepository<UserOperationClaim, Integer> {

    List<UserOperationClaim> getUserOperationClaimsByUserId(int userId);
}
