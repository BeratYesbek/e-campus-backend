package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.OperationClaimService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.entities.OperationClaim;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.OperationClaimsDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OperationClaimServiceImpl implements OperationClaimService {

    private final OperationClaimsDao operationClaimsDao;

    public OperationClaimServiceImpl(OperationClaimsDao operationClaimsDao) {
        this.operationClaimsDao = operationClaimsDao;
    }

    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<OperationClaim> add(OperationClaim entity) throws Exception {
        return null;
    }

    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<OperationClaim> update(OperationClaim entity) {
        return null;
    }

    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        return null;
    }

    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<OperationClaim> getById(int id) {
        return null;
    }

    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<OperationClaim>> getAll() {
        return new SuccessDataResult<>(operationClaimsDao.findAll());
    }
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<OperationClaim> getByDefaultRole() {
        return new SuccessDataResult<>(operationClaimsDao.findByName(SecurityRole.USER)) ;
    }
}
