package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.AcademicDepartmentService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.SuccessResult;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.core.utilities.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.AcademicDepartmentDao;
import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.entities.concretes.AcademicDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicDepartmentServiceImpl implements AcademicDepartmentService {

    private final AcademicDepartmentDao academicDepartmentDao;

    @Autowired
    public AcademicDepartmentServiceImpl(AcademicDepartmentDao academicDepartmentDao) {
        this.academicDepartmentDao = academicDepartmentDao;
    }

    @Override
    public DataResult<AcademicDepartment> add(AcademicDepartment entity) {
        return new SuccessDataResult<AcademicDepartment>(academicDepartmentDao.save(entity));
    }

    @Override
    public DataResult<AcademicDepartment> update(AcademicDepartment entity) {
        return new SuccessDataResult<>(academicDepartmentDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        academicDepartmentDao.deleteById(id);
        return new SuccessResult("Academic department has been deleted");
    }

    @Override
    public DataResult<AcademicDepartment> getById(int id) {
        return new SuccessDataResult<>(academicDepartmentDao.findById(id).get());
    }

    @Override
    public DataResult<List<AcademicDepartment>> getAll() {
        return new SuccessDataResult<>(academicDepartmentDao.findAll());
    }
}
