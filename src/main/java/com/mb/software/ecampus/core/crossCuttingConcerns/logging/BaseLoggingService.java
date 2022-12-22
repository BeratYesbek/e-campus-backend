package com.mb.software.ecampus.core.crossCuttingConcerns.logging;

import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.details.LogDetail;
import com.mb.software.ecampus.core.crossCuttingConcerns.logging.logServices.details.LogErrorDetail;

public abstract class BaseLoggingService {

    public void info(LogDetail logDetail) {
    }

    public void error(LogErrorDetail logErrorDetail) {
    }

    public void waning(LogDetail logDetail) {

    }

}
