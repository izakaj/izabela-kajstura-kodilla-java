package com.kodilla.patterns2.facade.api;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacadeWatcher.class);

    @Before("execution (* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void infoBefore() {
        LOGGER.info("Starting the operation...");
    }

    @After("execution (* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void infoAfter() {
        LOGGER.info("...operation finished.");
    }

    @AfterThrowing("execution (* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void inCaseOfErrors() {
        LOGGER.info("There were errors.");
    }

    @Around("execution (* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object around(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;

        try {
            long begin = System.currentTimeMillis();
            LOGGER.info("Begin time: " + begin);
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("End time: " + end);
            LOGGER.info("Time consumed: " + (end - begin) + " [ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
