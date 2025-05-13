package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecordEDTDetails {
    WebDriver driver;
    public RecordEDTDetails(WebDriver driver){
        this.driver=driver;
    }


    By awb=By.xpath("//input[@test-id='edtDetailsBO.awbNo']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By edtNo=By.xpath("//input[@test-id='edtDetailsBO.edtNoSave']");
    By processNo=By.xpath("//input[@test-id='edtDetailsBO.processNoSave']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");
    By confirm=By.xpath("//label[normalize-space()='Confirm']");



    public void SearchRecordEDTDetails(String AWB) throws InterruptedException {
        driver.findElement(awb).sendKeys(AWB);
        driver.findElement(searchBtn).click();
//        Thread.sleep(2000);
    }

    public void RecordEDTDetails(String EDTNo,String ProcessNo) throws InterruptedException {
        driver.findElement(sel).click();
        driver.findElement(edtNo).click();
        driver.findElement(edtNo).sendKeys(EDTNo);
        driver.findElement(processNo).click();
        driver.findElement(processNo).sendKeys(ProcessNo);
        driver.findElement(saveBtn).click();
//        Thread.sleep(2000);
        driver.findElement(confirm).click();
    }
}
