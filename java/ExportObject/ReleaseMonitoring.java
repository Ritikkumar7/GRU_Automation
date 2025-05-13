package ExportObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReleaseMonitoring {
    WebDriver driver;
    public ReleaseMonitoring(WebDriver driver){
        this.driver=driver;
    }

    By searchAWB=By.xpath("//input[@test-id='deliveryBo.awbNo1']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By approve=By.xpath("//button[@test-id='Approve']");
    By shcDateTo=By.xpath("//input[@test-id='deliveryBo.estDate']");



    public void SearchAWB(String AWBNo,String date){
        driver.findElement(searchAWB).click();
        driver.findElement(searchAWB).sendKeys(AWBNo);
        driver.findElement(shcDateTo).sendKeys(date);
        driver.findElement(searchBtn).click();
    }

    public void ApproveStatus(){
        driver.findElement(sel).click();
        driver.findElement(approve).click();
    }
}
