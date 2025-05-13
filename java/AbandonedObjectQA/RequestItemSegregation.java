package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RequestItemSegregation {

    WebDriver driver;
    public RequestItemSegregation(WebDriver driver){
        this.driver=driver;
    }

    By awb=By.xpath("//input[@test-id='searchModel.awb']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By create=By.xpath("//label[normalize-space()='Create']");
    By reasonofpull=By.xpath("(//i[@data-type='dropdown'])[6]");
    By auction=By.xpath("//span[normalize-space()='AUCTION']");
    By prpositionNp=By.xpath("//input[@test-id='searchModel.propNoSave']");
    By targetLoaction=By.xpath("//input[@test-id='searchModel.targetLoc']");
    By okBtn=By.xpath("//label[normalize-space()='OK']");
    By cross=By.xpath("//span[@class='fa fa-times']");
    By qtyRequest=By.xpath("//input[@test-id='resultList.0.reqQnty']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");
    By searchReasonofpull=By.xpath("(//i[@data-type='dropdown'])[3]");
    By searchPropositionNo=By.xpath("//input[@test-id='searchModel.propNo']");
    By markAsRequested=By.xpath("//button[@test-id='Mark as segregated']");

    public void SearchRequestItemSegregation(String AWB) throws InterruptedException {
        driver.findElement(awb).sendKeys(AWB);
        driver.findElement(searchBtn).click();
    }

    public void RequestItemSegregation(String Proposition) throws InterruptedException {
        driver.findElement(sel).click();
        driver.findElement(qtyRequest).sendKeys("9");
        driver.findElement(create).click();
        driver.findElement(reasonofpull).click();
        driver.findElement(auction).click();
        driver.findElement(prpositionNp).sendKeys(Proposition);
        driver.findElement(targetLoaction).sendKeys("DESTRUICAO");
        driver.findElement(okBtn).click();
//        driver.findElement(cross).click();
        driver.findElement(saveBtn).click();

    }

    public void ClickOnSegregated(String Proposition) throws InterruptedException {
        driver.findElement(searchReasonofpull).click();
        driver.findElement(auction).click();
        driver.findElement(searchPropositionNo).sendKeys(Proposition);
        driver.findElement(searchBtn).click();
        driver.findElement(sel).click();
        driver.findElement(markAsRequested).click();
    }

}
