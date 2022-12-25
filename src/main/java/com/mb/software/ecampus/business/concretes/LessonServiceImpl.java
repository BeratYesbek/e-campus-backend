package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.LessonService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.LessonDao;
import com.mb.software.ecampus.entities.concretes.Lesson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LessonServiceImpl implements LessonService {

    private final LessonDao lessonDao;

    @Autowired
    public LessonServiceImpl(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @SecurityOperation(security = {SecurityRole.STUDENT_AFFAIRS})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Lesson> add(Lesson entity) {
        return new SuccessDataResult<>(lessonDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.STUDENT_AFFAIRS})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Lesson> update(Lesson entity) {
        return new SuccessDataResult<>(lessonDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.STUDENT_AFFAIRS})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        return new SuccessResult("Lesson has been deleted");
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<Lesson> getById(int id) {
        return new SuccessDataResult<>(lessonDao.findById(id).get());
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<Lesson>> getAll() {
        return new SuccessDataResult<>(lessonDao.findAll());
    }
}
