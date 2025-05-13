package ExportObject;

//import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExportDiscrepancyList {
    WebDriver driver;
    public ExportDiscrepancyList(WebDriver driver){
        this.driver=driver;
    }

    By AwbNo=By.xpath("//input[@test-id='searchBo.awbNum']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By CCTManualUpdate=By.xpath("//label[normalize-space()='CCT Manual Update']");
    By ManualBillingUpdate=By.xpath("//label[normalize-space()='Manual Billing Update']");
    By CCTremarks=By.xpath("//textarea[@type='text']");
    By submitBtn=By.xpath("//button[@test-id='Submit']");

    public void SeachExportDiscrepancyList(String AWBNo){
        WebElement AWB=driver.findElement(AwbNo);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='"+ AWBNo +"';", AWB);
        driver.findElement(searchBtn).click();
    }

    public void CCTManualUpdate() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(sel).click();
        driver.findElement(CCTManualUpdate).click();
        Thread.sleep(1000);
        driver.findElement(CCTremarks).sendKeys("Test the data");
        driver.findElement(submitBtn).click();
        Thread.sleep(1000);
    }

    public void ManualBillingUpdate() throws InterruptedException {
        driver.findElement(sel).click();
        driver.findElement(ManualBillingUpdate).click();
        Thread.sleep(1000);
        driver.findElement(CCTremarks).sendKeys("Test the data");
        driver.findElement(submitBtn).click();
    }
}
