package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.ChoosedLessonService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.ChoosedLessonDao;
import com.mb.software.ecampus.entities.concretes.ChoosedLesson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChoosedLessonServiceImpl implements ChoosedLessonService {

    private final ChoosedLessonDao choosedLessonDao;

    @Autowired
    public ChoosedLessonServiceImpl(ChoosedLessonDao choosedLessonDao) {
        this.choosedLessonDao = choosedLessonDao;
    }

    @Override
    public DataResult<ChoosedLesson> add(ChoosedLesson entity) throws Exception {
        return new SuccessDataResult<>(choosedLessonDao.save(entity));
    }

    @Override
    public DataResult<ChoosedLesson> update(ChoosedLesson entity) {
        return new SuccessDataResult<>(choosedLessonDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        choosedLessonDao.deleteById(id);
        return new SuccessResult("Choosed Lesson has been deleted");
    }

    @Override
    public DataResult<ChoosedLesson> getById(int id) {
        return new SuccessDataResult<>(choosedLessonDao.findById(id).get());
    }

    @Override
    public DataResult<List<ChoosedLesson>> getAll() {
        return new SuccessDataResult<>(choosedLessonDao.findAll());
    }
}
