package com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices;

import com.mb.software.ecampus.core.crossCuttingConcerns.logging.BaseLoggingService;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.details.LogDetail;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.details.LogErrorDetail;
import com.mb.software.ecampus.core.dataAccess.LoggingDao;
import com.mb.software.ecampus.core.entities.DbLog;
import org.springframework.boot.logging.LogLevel;

public class DbLogging extends BaseLoggingService {
    private final LoggingDao loggingDao;

    public DbLogging(LoggingDao loggingDao) {
        this.loggingDao = loggingDao;
    }


    @Override
    public void info(LogDetail logDetail) {
        DbLog dbLog = setDbLogDetail(logDetail, LogLevel.INFO);
        loggingDao.save(dbLog);
    }

    @Override
    public void error(LogErrorDetail logErrorDetail) {
        DbLog dbLog = setDbLogErrorDetail(logErrorDetail, LogLevel.ERROR);
        loggingDao.save(dbLog);
    }

    private DbLog setDbLogDetail(LogDetail logDetail, LogLevel logLevel) {
        DbLog dbLog = DbLog.builder().logLevel(logLevel).message(logDetail.getMessage()).build();
        dbLog.setLogDetail(logDetail);
        dbLog.setCreatedAt();
        return dbLog;
    }

    private DbLog setDbLogErrorDetail(LogErrorDetail logErrorDetail, LogLevel logLevel) {
        DbLog dbLog = DbLog.builder().logLevel(logLevel).message(logErrorDetail.getMessage()).build();
        dbLog.setLogErrorDetail(logErrorDetail);
        dbLog.setCreatedAt();
        return dbLog;
    }
}
