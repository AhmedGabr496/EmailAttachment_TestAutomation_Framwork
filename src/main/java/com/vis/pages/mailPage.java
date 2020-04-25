package com.vis.pages;

import com.vis.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class mailPage extends TestBase {
    public mailPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="id__3")
    WebElement newMessage;
    @FindBy(xpath = "//input[@class='ms-BasePicker-input pickerInput_8d9d7e4e']")
    WebElement reciver;
    @FindBy (xpath =" //div[@class='_4utP_vaqQ3UQZH0GEBVQe B1QSRkzQCtvCtutReyNZ _17ghdPL1NLKYjRvmoJgpoK _2s9KmFMlfdGElivl0o-GZb']")
    WebElement messageBody;
    @FindBy(xpath = "//button[@name='Attach']")
    WebElement attachmentButton;
    @FindBy(xpath = "//button[@name='Browse this computer']")
    WebElement choosePc;
    @FindBy (xpath = "(//span[@data-automationid='splitbuttonprimary'])[39]")
    WebElement sendButton;
    @FindBy(xpath = "//input[contains(@id,'TextField1')]")
    WebElement subject;
    @FindBy (xpath = "(//div[@class='_1xP-XmXM1GGHpRKCCeOKjP'])[1]")
    WebElement emailmessage;
    @FindBy (xpath = "//div[@aria-label='attachment.docx Open']")
    WebElement attachment;
    @FindBy (xpath = "//button[@name='Download']")
    WebElement download;
    public void sendmessage(String reciveremail) throws InterruptedException, IOException {
        Thread.sleep(5000);
        newMessage.click();
        WebDriverWait wait = new WebDriverWait(driver,12);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='ms-BasePicker-input pickerInput_8d9d7e4e']")));
        subject.sendKeys("VIS_TEST");
        reciver.sendKeys(reciveremail);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        messageBody.sendKeys(dtf.format(now));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='Attach']")));
        attachmentButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='Browse this computer']")));
        Thread.sleep(5000);
        choosePc.click();
        Thread.sleep(5000);
        Runtime.getRuntime().exec("src/main/java/com/vis/DesktopAutomationScript/Upload attachment.exe");
        Thread.sleep(5000);
        sendButton.click();
    }

    public void recivemessage() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,12);
        emailmessage.click();
        Thread.sleep(3000);
        attachment.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='Download']")));
        download.click();
        Thread.sleep(3500);
    }

}
