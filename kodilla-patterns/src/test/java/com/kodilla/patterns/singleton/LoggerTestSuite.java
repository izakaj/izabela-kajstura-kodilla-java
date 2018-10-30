package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testLog(){
        //Given

        //When
        Logger.getInstance().log("random log");
        String result = Logger.getInstance().getLastLog();

        //Then
        Assert.assertEquals("random log", result);
    }
}
