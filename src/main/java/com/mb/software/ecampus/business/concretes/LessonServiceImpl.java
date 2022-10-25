package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.LessonService;
import com.mb.software.ecampus.core.utilities.Result;
import com.mb.software.ecampus.core.utilities.SuccessResult;
import com.mb.software.ecampus.core.utilities.data.DataResult;
import com.mb.software.ecampus.core.utilities.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.LessonDao;
import com.mb.software.ecampus.entities.concretes.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonDao lessonDao;

    @Autowired
    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @Override
    public DataResult<Lesson> add(Lesson entity) {
        return new SuccessDataResult<>(lessonDao.save(entity));
    }

    @Override
    public DataResult<Lesson> update(Lesson entity) {
        return new SuccessDataResult<>(lessonDao.save(entity));
    }

    @Override
    public Result delete(int id) {
        return new SuccessResult("Lesson has been deleted");
    }

    @Override
    public DataResult<Lesson> getById(int id) {
        return new SuccessDataResult<>(lessonDao.findById(id).get());
    }

    @Override
    public DataResult<List<Lesson>> getAll() {
        return new SuccessDataResult<>(lessonDao.findAll());
    }
}
