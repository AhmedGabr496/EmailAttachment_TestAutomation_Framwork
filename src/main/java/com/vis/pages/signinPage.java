package com.vis.pages;

import com.vis.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class signinPage extends TestBase {

    public signinPage() throws IOException {
        PageFactory.initElements(driver,this);


    }
    @FindBy(name = "loginfmt")
    WebElement emailfield;
    @FindBy (xpath = "//input[@type='submit']")
    WebElement nextbutton;
    @FindBy (name="passwd")
    WebElement passfield;
    @FindBy (xpath = "//input[@type='submit']")
    WebElement signingbutton;

    public void enteremail(String email)
    {
        emailfield.sendKeys(email);
        nextbutton.click();
    }
    public void  enterpass(String pass)
    {
        passfield.sendKeys(pass);
        signingbutton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='owaSearchBox']")));
    }
}
