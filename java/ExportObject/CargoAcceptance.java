package ExportObject;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.time.Duration;

public class CargoAcceptance {
    WebDriver driver;
    public CargoAcceptance(WebDriver driver){
        this.driver=driver;
    }

    By awbNo=By.xpath("(//input[@type='text'])[3]");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By actionBtn=By.xpath("//i[@data-type='edit']");
    By pieces=By.xpath("//input[@test-id='acceptance.locations.0.pieces']");
    By weight=By.xpath("//input[@test-id='acceptance.locations.0.weight']");
    By location=By.xpath("//input[@test-id='acceptance.locations.0.location']");
    By shc=By.xpath("//input[@test-id='acceptance.locations.0.shc1']");
    By typeOfPackaging=By.xpath("(//i[@data-type='dropdown'])[4]");
    By metal=By.xpath("//span[normalize-space()='02 Tambor de Metal']");
    By dimension=By.xpath("(//i[@data-type='dropdown'])[5]");
    By valueOfDimension=By.xpath("//span[normalize-space()='03 Manual']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");



    public void SeacrhShipment(String AWBNo) throws InterruptedException {
        Thread.sleep(1000);
        WebElement AWB=driver.findElement(awbNo);
        driver.findElement(awbNo).click();
        driver.findElement(awbNo).sendKeys(AWBNo);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='"+ AWBNo +"';", AWB);
        driver.findElement(searchBtn).click();
        driver.findElement(actionBtn).click();
    }

    public void CargoAceptance() throws InterruptedException, IOException {
        driver.findElement(pieces).sendKeys("9999");
        driver.findElement(weight).sendKeys("9999999");
        driver.findElement(location).sendKeys("BAGAGEM");
        driver.findElement(shc).sendKeys("NOR");
        driver.findElement(typeOfPackaging).click();
        driver.findElement(metal).click();
        driver.findElement(dimension).click();
        driver.findElement(valueOfDimension).click();
        driver.findElement(saveBtn).click();
    }


}
