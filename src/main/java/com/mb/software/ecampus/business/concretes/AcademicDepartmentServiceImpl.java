package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.AcademicDepartmentDao;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AcademicDepartmentServiceImpl implements AcademicDepartmentService {

    private final AcademicDepartmentDao academicDepartmentDao;

    @Autowired
    public AcademicDepartmentServiceImpl(AcademicDepartmentDao academicDepartmentDao) {
        this.academicDepartmentDao = academicDepartmentDao;
    }

    @Logging(logType = DbLogging.class)
    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN})
    @Override
    public DataResult<AcademicDepartment> add(AcademicDepartment entity) throws Exception {
        return new SuccessDataResult<AcademicDepartment>(academicDepartmentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<AcademicDepartment> update(AcademicDepartment entity) {
        return new SuccessDataResult<>(academicDepartmentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        academicDepartmentDao.deleteById(id);
        return new SuccessResult("Academic department has been deleted");
    }

    @SecurityOperation(security = SecurityRole.USER)
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<AcademicDepartment> getById(int id) {
        return new SuccessDataResult<>(academicDepartmentDao.findById(id).get());
    }

    @SecurityOperation(security = SecurityRole.USER)
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<AcademicDepartment>> getAll() {
        return new SuccessDataResult<>(academicDepartmentDao.findAll());
    }
}
