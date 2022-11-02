package com.mb.software.ecampus.core.crossCuttingConcerns.logging;

public abstract class BaseLoggingService {

    public void info(String message) {
        System.out.println("This is your message" + message);
    }

}
