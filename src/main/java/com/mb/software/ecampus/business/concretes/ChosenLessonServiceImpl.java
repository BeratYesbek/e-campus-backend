package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.ChosenLessonService;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.ChosenLessonDao;
import com.mb.software.ecampus.entities.concretes.ChosenLesson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ChosenLessonServiceImpl implements ChosenLessonService {

    private final ChosenLessonDao chosenLessonDao;

    @Autowired
    public ChosenLessonServiceImpl(ChosenLessonDao chosenLessonDao) {
        this.chosenLessonDao = chosenLessonDao;
    }

    @Override
    public DataResult<ChosenLesson> add(ChosenLesson entity) throws Exception {
        return new SuccessDataResult<>(chosenLessonDao.save(entity));
    }

    @Override
    public DataResult<ChosenLesson> update(ChosenLesson entity) {
        return new SuccessDataResult<>(chosenLessonDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        chosenLessonDao.deleteById(id);
        return new SuccessResult("Choosed Lesson has been deleted");
    }

    @Override
    public DataResult<ChosenLesson> getById(int id) {
        return new SuccessDataResult<>(chosenLessonDao.findById(id).get());
    }

    @Override
    public DataResult<List<ChosenLesson>> getAll() {
        return new SuccessDataResult<>(chosenLessonDao.findAll());
    }
}
