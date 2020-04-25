package com.vis.testcases;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.relevantcodes.extentreports.LogStatus;
import com.vis.Base.TestBase;
import com.vis.pages.HomePage;
import com.vis.pages.mailPage;
import com.vis.pages.signinPage;
import com.vis.utils.TestUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class recivemessagae extends TestBase {
    public recivemessagae() throws IOException {
    super();
    }
    HomePage homePage;
    signinPage signinpage;
    mailPage mailpage;
    TestUtils testUtils;
    @DataProvider
    public Object[][] testData() throws IOException {
        testUtils = new TestUtils();
        return testUtils.getDataFromExcel("sheet3");
    }
    @BeforeMethod
    public void setup(Method method) throws ATUTestRecorderException, IOException, InterruptedException {
        intialize(pro.getProperty("browser"));
        logger = extent.startTest(method.getName());
        recorder = new ATUTestRecorder("Report\\", method.getName(), false);
        homePage = new HomePage();
        recorder.start();
        homePage.clicksignin();
    }

    @Test(dataProvider = "testData")
    public void recivemessage(String email , String pass) throws IOException, InterruptedException {
        mailpage=new mailPage();
        signinpage = new signinPage();
        signinpage.enteremail(email);
        Thread.sleep(3000);
        signinpage.enterpass(pass);
        mailpage.recivemessage();
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
