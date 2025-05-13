package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CaptureDelivery {
    WebDriver driver;
    By deliveryNo=By.xpath("//input[@test-id='searchBO.deliveryNo']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By devileredBtn=By.xpath("//label[normalize-space()='Delivered']");


    public CaptureDelivery(WebDriver driver) throws InterruptedException {
        this.driver=driver;
    }

    public void SearchCaptureDelivery(String DeliveryNo) throws InterruptedException {
        driver.findElement(deliveryNo).sendKeys(DeliveryNo);
        driver.findElement(searchBtn).click();
//        Thread.sleep(5000);
        driver.findElement(sel).click();
        driver.findElement(devileredBtn).click();
    }
}
