package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.AcademicPersonalService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.SuccessResult;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.core.utilities.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.AcademicPersonalDao;
import com.mb.software.ecampus.entities.concretes.AcademicPersonal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicPersonalServiceImpl implements AcademicPersonalService {

    private final AcademicPersonalDao academicPersonalDao;

    @Autowired
    public AcademicPersonalServiceImpl(AcademicPersonalDao academicPersonalDao) {
        this.academicPersonalDao = academicPersonalDao;
    }

    @Override
    public DataResult<AcademicPersonal> add(AcademicPersonal entity) {
        return new SuccessDataResult<>(academicPersonalDao.save(entity));
    }

    @Override
    public DataResult<AcademicPersonal> update(AcademicPersonal entity) {
        return new SuccessDataResult<>(academicPersonalDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        academicPersonalDao.deleteById(id);
        return new SuccessResult("Academic Personal has been deleted");
    }

    @Override
    public DataResult<AcademicPersonal> getById(int id) {
        return new SuccessDataResult<>(academicPersonalDao.findById(id).get());
    }

    @Override
    public DataResult<List<AcademicPersonal>> getAll() {
        return new SuccessDataResult<>(academicPersonalDao.findAll());
    }
}
