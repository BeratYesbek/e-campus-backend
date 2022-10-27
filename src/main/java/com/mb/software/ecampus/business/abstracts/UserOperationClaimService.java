package com.mb.software.ecampus.business.abstracts;

import com.mb.software.ecampus.business.abstracts.common.ServiceRepository;
import com.mb.software.ecampus.core.entities.UserOperationClaim;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;

import java.util.List;

public interface UserOperationClaimService extends ServiceRepository<UserOperationClaim> {

    DataResult<List<UserOperationClaim>> getByUserId(int userId);
}
