package com.vis.pages;

import com.vis.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class HomePage extends TestBase {

    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "(//a[@data-task='signin'])[1]")
    WebElement signinbutton;

    public void clicksignin() throws InterruptedException {
        signinbutton.click();


    }
}
