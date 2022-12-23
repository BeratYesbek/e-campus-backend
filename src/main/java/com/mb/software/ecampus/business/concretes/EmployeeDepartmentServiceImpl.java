package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.EmployeeDepartmentService;
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

    @Override
    public DataResult<EmployeeDepartment> add(EmployeeDepartment entity) {
        return new SuccessDataResult<>(employeeDepartmentDao.save(entity));
    }

    @Override
    public DataResult<EmployeeDepartment> update(EmployeeDepartment entity) {
        return new SuccessDataResult<>(employeeDepartmentDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        employeeDepartmentDao.deleteById(id);
        return new SuccessResult("Employee Department has been deleted");
    }

    @Override
    public DataResult<EmployeeDepartment> getById(int id) {
        return new SuccessDataResult<>(employeeDepartmentDao.findById(id).get());
    }


    @Override
    public DataResult<List<EmployeeDepartment>> getAll() {
        return new SuccessDataResult<>(employeeDepartmentDao.findAll());
    }
}
