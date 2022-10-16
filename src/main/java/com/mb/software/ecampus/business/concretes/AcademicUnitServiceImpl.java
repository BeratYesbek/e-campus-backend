package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.AcademicUnitService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.SuccessResult;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.core.utilities.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.AcademicUnitDao;
import com.mb.software.ecampus.entities.concretes.AcademicUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicUnitServiceImpl implements AcademicUnitService {

    private final AcademicUnitDao unitDao;

    @Autowired
    public AcademicUnitServiceImpl(AcademicUnitDao unitDao) {
        this.unitDao = unitDao;
    }

    @Override
    public DataResult<AcademicUnit> add(AcademicUnit entity) {
        return new SuccessDataResult<AcademicUnit>(unitDao.save(entity));
    }

    @Override
    public DataResult<AcademicUnit> update(AcademicUnit entity) {
        return new SuccessDataResult<AcademicUnit>(unitDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        unitDao.deleteById(id);
        return new SuccessResult("Academic unit has been deleted");
    }

    @Override
    public DataResult<AcademicUnit> getById(int id) {
        return new SuccessDataResult<>(unitDao.findById(id).get());
    }

    @Override
    public DataResult<List<AcademicUnit>> getAll() {
        return new SuccessDataResult<>(unitDao.findAll());
    }
}
