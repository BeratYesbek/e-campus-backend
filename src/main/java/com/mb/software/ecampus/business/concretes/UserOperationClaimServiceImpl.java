package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.UserOperationClaimService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.entities.UserOperationClaim;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.UserOperationClaimDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserOperationClaimServiceImpl implements UserOperationClaimService {

    private final UserOperationClaimDao userOperationClaimDao;

    @Autowired
    public UserOperationClaimServiceImpl(UserOperationClaimDao userOperationClaimDao) {
        this.userOperationClaimDao = userOperationClaimDao;
    }

    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<UserOperationClaim> add(UserOperationClaim entity) {
        return new SuccessDataResult<>(userOperationClaimDao.save(entity));
    }
    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<UserOperationClaim> update(UserOperationClaim entity) {
        return new SuccessDataResult<>(userOperationClaimDao.save(entity));
    }
    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        userOperationClaimDao.deleteById(id);
        return new SuccessResult("User operation claim deleted");
    }

    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<UserOperationClaim> getById(int id) {
        return null;
    }

    @SecurityOperation(security = {SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<UserOperationClaim>> getAll() {
        return null;
    }
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<UserOperationClaim>> getByUserId(int userId) {
        return new SuccessDataResult<>(userOperationClaimDao.getUserOperationClaimsByUserId(userId));
    }
}
