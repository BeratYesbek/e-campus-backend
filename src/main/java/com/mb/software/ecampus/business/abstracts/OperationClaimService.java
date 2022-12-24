package com.mb.software.ecampus.business.abstracts;

import com.mb.software.ecampus.business.abstracts.common.ServiceRepository;
import com.mb.software.ecampus.core.entities.OperationClaim;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;

public interface OperationClaimService extends ServiceRepository<OperationClaim> {
    DataResult<OperationClaim> getByDefaultRole();
}
