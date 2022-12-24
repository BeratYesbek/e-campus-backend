package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.EmployeeService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.EmployeeDao;
import com.mb.software.ecampus.entities.concretes.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @SecurityOperation(security = {SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Employee> add(Employee entity) {
        return new SuccessDataResult<>(employeeDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Employee> update(Employee entity) {
        return new SuccessDataResult<>(employeeDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        employeeDao.deleteById(id);
        return new SuccessResult();
    }

    @SecurityOperation(security = {SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<>(employeeDao.findById(id).get());
    }

    @SecurityOperation(security = {SecurityRole.HUMAN_RESOURCES})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(employeeDao.findAll());
    }
}
