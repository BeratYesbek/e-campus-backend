package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.AcademicPersonalService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.AcademicPersonalDao;
import com.mb.software.ecampus.entities.concretes.AcademicPersonal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicPersonalServiceImpl implements AcademicPersonalService {

    private final AcademicPersonalDao academicPersonalDao;

    @Autowired
    public AcademicPersonalServiceImpl(AcademicPersonalDao academicPersonalDao) {
        this.academicPersonalDao = academicPersonalDao;
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN, SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<AcademicPersonal> add(AcademicPersonal entity) {
        return new SuccessDataResult<>(academicPersonalDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN, SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<AcademicPersonal> update(AcademicPersonal entity) {
        return new SuccessDataResult<>(academicPersonalDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN, SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        academicPersonalDao.deleteById(id);
        return new SuccessResult("Academic Personal has been deleted");
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<AcademicPersonal> getById(int id) {
        return new SuccessDataResult<>(academicPersonalDao.findById(id).get());
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<AcademicPersonal>> getAll() {
        return new SuccessDataResult<>(academicPersonalDao.findAll());
    }
}
