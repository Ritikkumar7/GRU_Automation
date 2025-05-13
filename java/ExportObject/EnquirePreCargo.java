package ExportObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EnquirePreCargo {
    WebDriver driver;
    public EnquirePreCargo(WebDriver driver){
        this.driver=driver;
    }

    By dueNo=By.xpath("//input[@test-id='searchBO.due']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By actionBtn=By.xpath("//i[@data-type='edit']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");

    public void SeacrhShipment(String AWBNo) throws InterruptedException {
        driver.findElement(dueNo).click();
        driver.findElement(dueNo).sendKeys(AWBNo);
        driver.findElement(searchBtn).click();
    }

    public void UpdatePreCargo() throws InterruptedException {
        driver.findElement(actionBtn).click();
        driver.findElement(saveBtn).click();
    }
}
