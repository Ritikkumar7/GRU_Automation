package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateShipmentSorting {
    WebDriver driver;

    By awb=By.xpath("//input[@test-id='searchBO.awb']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By markassorted=By.xpath("//button[@test-id='Mark As Sorted']");
    By targetLocation=By.xpath("//input[@test-id='searchBO.targetLoc']");
    By Yes=By.xpath("//i[@class='fa fa-check']");
    By sel=By.xpath("//div[@test-id='resultList.0.itmSel']");

    public CreateShipmentSorting(WebDriver driver){
        this.driver=driver;
    }

    public void SearchCreateShipmentSorting(String AWB){
        driver.findElement(awb).click();
        driver.findElement(awb).sendKeys(AWB);
        driver.findElement(searchBtn).click();
    }

    public void CreateShipmentSorting() throws InterruptedException {
//        Thread.sleep(1000);
        driver.findElement(markassorted).click();
//        Thread.sleep(1000);
        driver.findElement(targetLocation).sendKeys("TRIAGEM_01");
        driver.findElement(sel).click();
        driver.findElement(markassorted).click();
//        Thread.sleep(1000);
    }

}
