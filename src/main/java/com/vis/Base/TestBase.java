package com.vis.Base;

import atu.testrecorder.ATUTestRecorder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties pro;
    public static ExtentTest logger;
    public static ExtentReports extent;
    public static ATUTestRecorder recorder;

    public TestBase () throws IOException {
        pro = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/com/vis/config/config.properties");
        pro.load(fis);
    }
    public void intialize(String browser)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","src/main/java/com/vis/resources/chrome/chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","src/main/java/com/vis/resources/firefox/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.get(pro.getProperty("HomePage"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void Screenshot(String name) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("Report\\"+name+".png"));

    }
}
