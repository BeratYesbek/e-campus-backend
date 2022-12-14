package com.mb.software.ecampus.business.concretes;

import com.mb.software.ecampus.business.abstracts.LessonContentService;
import com.mb.software.ecampus.core.annotations.Logging;
import com.mb.software.ecampus.core.annotations.SecurityOperation;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.DbLogging;
import com.mb.software.ecampus.core.security.roles.SecurityRole;
import com.mb.software.ecampus.core.utilities.results.Result;
import com.mb.software.ecampus.core.utilities.results.SuccessResult;
import com.mb.software.ecampus.core.utilities.results.data.DataResult;
import com.mb.software.ecampus.core.utilities.results.data.SuccessDataResult;
import com.mb.software.ecampus.dataAccess.dao.LessonContentDao;
import com.mb.software.ecampus.entities.concretes.LessonContent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LessonContentServiceImpl implements LessonContentService {

    private final LessonContentDao lessonContentDao;

    @Autowired
    public LessonContentServiceImpl(LessonContentDao lessonContentDao) {
        this.lessonContentDao = lessonContentDao;
    }

    @SecurityOperation(security = {SecurityRole.PROFESSOR})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<LessonContent> add(LessonContent entity) throws Exception {
        return new SuccessDataResult<>(lessonContentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.PROFESSOR})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<LessonContent> update(LessonContent entity) {
        return new SuccessDataResult<>(lessonContentDao.save(entity));
    }

    @SecurityOperation(security = {SecurityRole.PROFESSOR})
    @Logging(logType = DbLogging.class)
    @Override
    public Result delete(int id) {
        lessonContentDao.deleteById(id);
        return new SuccessResult("Lesson Content has been deleted");
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<LessonContent> getById(int id) {
        return new SuccessDataResult<>(lessonContentDao.findById(id).get());
    }

    @SecurityOperation(security = {SecurityRole.USER})
    @Logging(logType = DbLogging.class)
    @Override
    public DataResult<List<LessonContent>> getAll() {
        return new SuccessDataResult<>(lessonContentDao.findAll());
    }
}
