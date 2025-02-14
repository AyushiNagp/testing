package FailedTestRetryListener;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: "+result.getMethod().getMethodName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: "+result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test Finished: "+context.getName());
    }
}
