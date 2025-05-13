package ExportObject;

//import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MaintainExportCar {
    WebDriver driver;
    public MaintainExportCar(WebDriver driver){
        this.driver=driver;
    }

    By awbSearch=By.xpath("//input[@test-id='searchBO.awbNo']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By actionBtn=By.xpath("//i[@data-type='edit']");
    By declaredPcs=By.xpath("(//input[@type='text'])[9]");
    By declaredWeight=By.xpath("(//input[@type='text'])[10]");
    By code=By.xpath("//input[@test-id='detailBO.consigneeCNPJ']");
    By shipmentOwner=By.xpath("//input[@test-id='detailBO.airline']");
    By yesPopupBtn=By.xpath("//i[@class='fa fa-check']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");

    public void SearchShipment(String AWBNo) throws InterruptedException {
        driver.findElement(awbSearch).sendKeys(AWBNo);
        driver.findElement(searchBtn).click();
        driver.findElement(actionBtn).click();
    }

    public void UpdateExportCAR() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(shipmentOwner).click();
        driver.findElement(shipmentOwner).clear();
        driver.findElement(shipmentOwner).sendKeys("EK");
        driver.findElement(declaredPcs).click();
        driver.findElement(declaredPcs).sendKeys("9999");
        driver.findElement(declaredWeight).click();
        driver.findElement(declaredWeight).sendKeys("9999999.000");
        driver.findElement(code).click();
        driver.findElement(code).sendKeys("00.008.955/0001-95");
        driver.findElement(saveBtn).click();
        Thread.sleep(1000);
        driver.findElement(yesPopupBtn).click();
    }

}

