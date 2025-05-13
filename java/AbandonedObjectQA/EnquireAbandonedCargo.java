package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnquireAbandonedCargo {
    WebDriver driver;
    public EnquireAbandonedCargo(WebDriver driver) throws InterruptedException {
        this.driver=driver;
    }

    By awbNo=By.xpath("//input[@test-id='searchAbnBO.awbNo']");
    By searchBtn=By.xpath("//span[normalize-space()='Search']");
    By actionBtn=By.xpath("//i[@data-type='edit']");



    public void SearchEnquireAbandonedCargo(String AWBNo) throws InterruptedException {
        driver.findElement(awbNo).sendKeys(AWBNo);
        driver.findElement(searchBtn).click();
        driver.findElement(actionBtn).click();
    }





}
