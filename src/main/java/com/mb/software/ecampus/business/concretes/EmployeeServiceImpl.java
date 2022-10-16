package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.EmployeeService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.SuccessResult;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.core.utilities.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.EmployeeDao;
import com.mb.software.ecampus.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<Employee> add(Employee entity) {
        return new SuccessDataResult<>(employeeDao.save(entity));
    }

    @Override
    public DataResult<Employee> update(Employee entity) {
        return new SuccessDataResult<>(employeeDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        employeeDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<>(employeeDao.findById(id).get());
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(employeeDao.findAll());
    }
}
