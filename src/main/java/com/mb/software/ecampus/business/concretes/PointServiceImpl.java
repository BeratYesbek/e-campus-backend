package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.PointService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.PointDao;
import com.mb.software.ecampus.entities.concretes.Point;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PointServiceImpl implements PointService {

    private final PointDao pointDao;

    @Autowired
    public PointServiceImpl(PointDao pointDao) {
        this.pointDao = pointDao;
    }

    @Override
    public DataResult<Point> add(Point entity) throws Exception {
        return new SuccessDataResult<>(pointDao.save(entity));
    }

    @Override
    public DataResult<Point> update(Point entity) {
        return new SuccessDataResult<>(pointDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        pointDao.deleteById(id);
        return new SuccessResult("Point has been deleted");
    }

    @Override
    public DataResult<Point> getById(int id) {
        return new SuccessDataResult<>(pointDao.findById(id).get());
    }

    @Override
    public DataResult<List<Point>> getAll() {
        return new SuccessDataResult<>(pointDao.findAll());
    }
}
