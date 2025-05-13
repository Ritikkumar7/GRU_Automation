package ExportObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DesktopDelivery {
    WebDriver driver;
    public DesktopDelivery(WebDriver driver){
        this.driver=driver;
    }

    By AwbNo=By.xpath("//input[@test-id='awbNo']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By sel=By.xpath("//div[@role='radio']");
    By Remarks=By.xpath("//textarea[@type='text']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");
    By yesbtn=By.xpath("//i[@class='fa fa-check']");
    By scheduleTo=By.xpath("//input[@test-id='scheduledTo']");

    public void SeachDesktopDelivery(String AWBNo,String Date) throws InterruptedException {
        driver.findElement(AwbNo).click();
        WebElement AWB=driver.findElement(AwbNo);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='"+ AWBNo +"';", AWB);
        driver.findElement(scheduleTo).sendKeys(Date);
        driver.findElement(searchBtn).click();
    }

    public void DeliverAWB() throws InterruptedException {
        driver.findElement(sel).click();
        driver.findElement(Remarks).sendKeys("Deliver the PCG");
        driver.findElement(saveBtn).click();
        driver.findElement(yesbtn).click();
    }

}
