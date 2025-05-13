package ExportObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExportDeliveryRequest {
    WebDriver driver;
    public ExportDeliveryRequest(WebDriver driver){
        this.driver=driver;
    }

    By flightDropdown=By.xpath("(//i[@data-type='dropdown'])[1]");
    By Flight=By.xpath("//li[normalize-space()='Flight']");
    By flightCarrier=By.xpath("//input[@test-id='deliveryBo.flightCarr']");
    By flightNo=By.xpath("//input[@test-id='deliveryBo.flightNo']");
    By createRequest=By.xpath("//label[normalize-space()='Create Request']");
    By awbNo=By.xpath("//input[@test-id='deliveryBo.createDeliveryList.0.awbNum']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By savePopup=By.xpath("//label[normalize-space()='Save']");
    By cancelPopup=By.xpath("//label[normalize-space()='Cancel']");
    By searchBtn=By.xpath("(//label[normalize-space()='Search'])[3]");
    By sendListToGRU=By.xpath("//label[normalize-space()='Send List to GRU']");
    By date=By.xpath("//input[@test-id='deliveryBo.orgFltDate']");
    By confirmationPopup=By.xpath("//h5[@class='modal-title']");
    By yesbtn=By.xpath("//i[@class='fa fa-check']");

    public void CreateRequest(String Flight_No,String Date) throws InterruptedException {
        driver.findElement(flightDropdown).click();
        driver.findElement(Flight).click();
        driver.findElement(flightNo).click();
        driver.findElement(flightNo).sendKeys(Flight_No);
        driver.findElement(flightCarrier).click();
        driver.findElement(flightCarrier).sendKeys("EK");
        driver.findElement(date).sendKeys(Date);
        driver.findElement(createRequest).click();
    }

    public void AWBDetails(String AWBNo) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(awbNo).click();
        WebElement AWB=driver.findElement(awbNo);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='"+ AWBNo +"';", AWB);
        Thread.sleep(1000);
        driver.findElement(sel).click();
        driver.findElement(savePopup).click();
        Thread.sleep(2000);
        driver.findElement(cancelPopup).click();
        Thread.sleep(1000);
    }

    public void StatusUpdate() throws InterruptedException {
        driver.findElement(searchBtn).click();
        Thread.sleep(1000);
        driver.findElement(sel).click();
        Thread.sleep(1000);
        driver.findElement(sendListToGRU).click();
        Thread.sleep(1000);
    }
}
