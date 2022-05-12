package com.automation.web.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    public Logger log = Logger.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Test start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
