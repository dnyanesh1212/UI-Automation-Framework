package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.BaseTest;
import com.utils.CommonUtils;
import com.utils.ExtentReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners implements ITestListener {
    public WebDriver driver = null;
    CommonUtils commonUtils;
    ExtentReports extentReporter;
    ExtentTest extentTest;


    @Override
    public void onStart(ITestContext context) {
        extentReporter = ExtentReporter.generateExtentReport();
        commonUtils = new CommonUtils();
        System.out.println("Project execution started");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReporter.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.SKIP, result.getName()+ " Test skipped");
//        System.out.println(result.getThrowable());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        String path = commonUtils.captureScreenshot(driver, result.getName());

        extentTest.addScreenCaptureFromPath(path);
        extentTest.log(Status.INFO,result.getThrowable());
        extentTest.log(Status.FAIL, "Test execution failed");
//      System.out.println(result.getThrowable());

    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReporter.createTest(result.getName());
        extentTest.log(Status.INFO,"Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"Test passed");

    }
}
