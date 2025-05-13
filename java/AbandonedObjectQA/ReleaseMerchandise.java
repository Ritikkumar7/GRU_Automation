package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReleaseMerchandise {
    WebDriver driver;
    public ReleaseMerchandise(WebDriver driver) throws InterruptedException {
        this.driver=driver;
    }
    By propositionNp=By.xpath("//input[@test-id='searchBO.propositionNo']");
    By reasonOfPull=By.xpath("(//i[@data-type='dropdown'])[1]");
    By auction=By.xpath("//span[normalize-space()='AUCTION']");
    By noOfLot=By.xpath("(//i[@data-type='dropdown'])[2]");
    By selectLotNo=By.xpath("(//li[@role='option'])[2]");
    By createBtn=By.xpath("//label[normalize-space()='Create']");
    By sel=By.xpath("//div[@role='checkbox']");
    By deliveryNo=By.xpath("//input[@test-id='releaseMerchandiseBO.deliveryNo']");
    By saveBtn=By.xpath("//span[normalize-space()='Save']");

    public void SearchReleaseMerchandise(String PropositionNo,String DeliveryNo) throws InterruptedException {
        driver.findElement(propositionNp).sendKeys(PropositionNo);
        driver.findElement(reasonOfPull).click();
        driver.findElement(auction).click();
        driver.findElement(noOfLot).click();
        driver.findElement(selectLotNo).click();
        driver.findElement(createBtn).click();
        driver.findElement(sel).click();
        driver.findElement(deliveryNo).clear();
        driver.findElement(deliveryNo).sendKeys(DeliveryNo);
        driver.findElement(saveBtn).click();
    }


}
