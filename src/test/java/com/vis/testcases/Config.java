package com.vis.testcases;

import com.vis.Base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Config extends TestBase {

    public Config() throws IOException {
        super();
    }
    @BeforeSuite
    public void start()
    {
        extent = new ExtentReports("Report\\Report.HTML",true);
        extent.addSystemInfo("vis","Test automation Task");
        extent.addSystemInfo("Tester","Ahmed Gabr");
        extent.addSystemInfo("LinkedIn","linkedin.com/in/amgabr96/");
    }
    @AfterSuite
    public void end()
    {
        extent.flush();
    }

}