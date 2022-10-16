package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.EmployeeDepartmentService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.SuccessResult;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.core.utilities.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.EmployeeDepartmentDao;
import com.mb.software.ecampus.entities.concretes.EmployeeDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
