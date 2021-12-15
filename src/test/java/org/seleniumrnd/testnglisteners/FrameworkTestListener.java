package org.seleniumrnd.testnglisteners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.seleniumrnd.base.BaseTest;
import org.seleniumrnd.extentreport.ExtentManager;
import org.seleniumrnd.extentreport.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.seleniumrnd.extentreport.ExtentManager.OUTPUT_FOLDER_SCREENSHOTS;

public class FrameworkTestListener implements ITestListener {

    private static long endTime;

    private static void setStartTime(long startTime) {
    }

    private static void setEndTime(long endTime) {
        FrameworkTestListener.endTime = endTime;
    }


    public void onStart(ITestContext context) {
        System.out.println("*** Test Suite " + context.getName() + " started ***");
    }

    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        setStartTime(context.getStartDate().getTime());
        setEndTime(context.getEndDate().getTime());
        //ExtentTestManager.endTest();
        //ExtentManager.getInstance().flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println("--------- Executing :- " + getSimpleMethodName(result) + " ---------");
        ExtentTestManager.createTest(result.getName(), result.getMethod().getDescription());
        ExtentTestManager.setCategoryName(getSimpleClassName(result));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        BaseTest test = (BaseTest) result.getInstance();
        if (test == null) {
            return;
        }
        WebDriver driver = test.driver;

        ExtentTestManager.getTest().assignCategory(getSimpleClassName(result));
        ExtentTestManager.getTest().log(Status.FAIL, result.getName() + " Test is failed" +result.getThrowable());
        try {
            ExtentTestManager.getTest().fail("<br><font color= red>"+"Screenshot of Web"+"</font></b>",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot(getSimpleMethodName(result),driver)).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        addExtentLabelToTest(result);
        ExtentTestManager.endTest();
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, result.getName() + " Test is Skipped" + result.getThrowable());
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    private synchronized String getSimpleClassName(ITestResult result) {
        return result.getMethod().getRealClass().getSimpleName();
    }

    private synchronized String getSimpleMethodName(ITestResult result) {
        return result.getName();
    }

    private synchronized void addExtentLabelToTest(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            ExtentTestManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
        else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
        } else
            ExtentTestManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
    }

    private static synchronized String takeScreenshot(String methodName, WebDriver driver) {
        DateFormat dateFormat = new SimpleDateFormat("MMM_dd_yyyy_HH_mm_ss_SSS");
        Date date = new Date();
        String dateName = dateFormat.format(date);
        String filePathExtent = OUTPUT_FOLDER_SCREENSHOTS + "Web"+ methodName + "_" + dateName + ".png";
        String filePath = ExtentManager.getReportBaseDirectory() + filePathExtent;
        String encodedBase64=null;
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileInputStream fileInputStreamReader ;
            fileInputStreamReader = new FileInputStream(screenshotFile);
            byte[] bytes = new byte[(int) screenshotFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = Base64.encodeBase64String(bytes);
            FileUtils.copyFile(screenshotFile, new File(filePath));
        }catch (IOException e){
            e.getStackTrace();
            Reporter.log("Failed To Take screenshot " + e, true);
        }
        return encodedBase64;
    }
}