package com.vis.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.relevantcodes.extentreports.LogStatus;
import com.vis.Base.TestBase;
import com.vis.pages.HomePage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class HomePageTest extends TestBase {

    public HomePageTest() throws IOException {
    super();
    }
    boolean assert_res = false;
    HomePage homePage;
    @BeforeMethod
    public void setup(Method method) throws ATUTestRecorderException {
        intialize(pro.getProperty("browser"));
        logger = extent.startTest(method.getName());
        recorder = new ATUTestRecorder("Report\\", method.getName(), false);
        recorder.start();
    }
    @Test
    public void checkUrl()
    {
        String actualurl = driver.getCurrentUrl();
        String expectedUrl = pro.getProperty("HomePage");
        Assert.assertEquals(actualurl,expectedUrl);
        boolean assert_res = true;
    }
    @Test
    public void signinbutton() throws IOException, InterruptedException {
        homePage = new HomePage();
        homePage.clicksignin();
    }

    @AfterMethod
    public void endAll(Method method , ITestResult result) throws IOException, ATUTestRecorderException {
        Screenshot(method.getName());
        if (result.getStatus()==ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, "TestPassed");
            logger.log(LogStatus.PASS, "<a href = '" + result.getName() + ".png" + "'><span class='lable info'>Download SnapShot</span></a>");
            logger.log(LogStatus.PASS, "<a href = '" + result.getName() + ".mov" + "'><span class='lable info'>Download video</span></a>");

        }
        else if(result.getStatus()==ITestResult.FAILURE)
        {
            logger.log(LogStatus.FAIL, "TestPassed");
            logger.log(LogStatus.FAIL, "<a href = '" + result.getName() + ".png" + "'><span class='lable info'>Download SnapShot</span></a>");
            logger.log(LogStatus.FAIL, "<a href = '" + result.getName() + ".mov" + "'><span class='lable info'>Download video</span></a>");
        }
        else {
            logger.log(LogStatus.SKIP,"Test Skipped"+result.getThrowable());

        }
        recorder.stop();
        driver.quit();
    }

}
