package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.EmployeeDepartmentService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.EmployeeDepartmentDao;
import com.mb.software.ecampus.entities.concretes.EmployeeDepartment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {

    private final EmployeeDepartmentDao employeeDepartmentDao;

    @Autowired
    public EmployeeDepartmentServiceImpl(EmployeeDepartmentDao employeeDepartmentDao) {
        this.employeeDepartmentDao = employeeDepartmentDao;
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN, SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<EmployeeDepartment> add(EmployeeDepartment entity) {
        return new SuccessDataResult<>(employeeDepartmentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN, SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<EmployeeDepartment> update(EmployeeDepartment entity) {
        return new SuccessDataResult<>(employeeDepartmentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.ADMIN, SecurityRole.SUPER_ADMIN, SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        employeeDepartmentDao.deleteById(id);
        return new SuccessResult("Employee Department has been deleted");
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<EmployeeDepartment> getById(int id) {
        return new SuccessDataResult<>(employeeDepartmentDao.findById(id).get());
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<EmployeeDepartment>> getAll() {
        return new SuccessDataResult<>(employeeDepartmentDao.findAll());
    }
}
