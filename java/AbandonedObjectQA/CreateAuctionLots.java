package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAuctionLots {
    WebDriver driver;
    public CreateAuctionLots(WebDriver driver) throws InterruptedException {
        this.driver=driver;
    }

    By proposiitonNo=By.xpath("//input[@test-id='searchObjBO.propNo']");
    By createBtn=By.xpath("//label[normalize-space()='Create']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By lotNo=By.xpath("//input[@test-id='searchResultObjBO.lotNo']");
    By saveBtn=By.xpath("//span[normalize-space()='Save']");


    public void SearchCreateAuctionLot(String PropositionNo,String LotNo) throws InterruptedException {
//        Thread.sleep(2000);
        driver.findElement(proposiitonNo).sendKeys(PropositionNo);
        driver.findElement(createBtn).click();
//        Thread.sleep(2000);
        driver.findElement(sel).click();
        driver.findElement(lotNo).sendKeys(LotNo);
        driver.findElement(saveBtn).click();
    }

}
