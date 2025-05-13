package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AcceptAbandoned {
    WebDriver driver;
    public AcceptAbandoned(WebDriver driver){
        this.driver=driver;
    }

    By awb= By.xpath("//input[@test-id='abandndCargoBO.awbDsic']");
    By createBtn=By.xpath("//button[@test-id='Create']");
    By otherCargo=By.xpath("//div[@test-id='abandndCargoBO.cargoTypeOWH']");
    By Baggage=By.xpath("//div[@test-id='abandndCargoBO.cargoTypeBaggage']");
    By location=By.xpath("//input[@test-id='storageDtlLst.0.loc']");
    By pcs=By.xpath("//input[@test-id='storageDtlLst.0.pcs']");
    By wt=By.xpath("//input[@test-id='storageDtlLst.0.wt']");
    By shc=By.xpath("(//input[@class='ui-dropdown-label-input'])[3]");
    By target=By.xpath("//input[@test-id='storageDtlLst.0.alvo']");
    By pkg=By.xpath("(//div[@role='button'])[8]");
    By pkgType=By.xpath("//span[normalize-space()='01 Tambor de Plastico']");
    By dim=By.xpath("(//i[@data-type='dropdown'])[3]");
    By dimValue=By.xpath("//span[normalize-space()='03 Manual']");
    By print=By.xpath("(//div[@role='button'])[1]");
    By printValue=By.xpath("//span[normalize-space()='DESTRUICAO']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");
    By shc2=By.xpath("(//input[@class='ui-dropdown-label-input'])[4]");
    By sel=By.xpath("//div[@role='radio']");
    By savePopup=By.xpath("//button[@test-id='Save']");


    public void SearchAcceptAbandonedCargoListOtherCargo(String AWB) throws InterruptedException {
        driver.findElement(awb).sendKeys(AWB);
        driver.findElement(otherCargo).click();
        driver.findElement(createBtn).click();
        Thread.sleep(1000);
        driver.findElement(sel).click();
        Thread.sleep(1000);
        driver.findElement(savePopup).click();
    }

    public void SearchAcceptAbandonedCargoBaggage(String AWB) throws InterruptedException {
        driver.findElement(awb).sendKeys(AWB);
        driver.findElement(Baggage).click();
        driver.findElement(createBtn).click();
        Thread.sleep(1000);
    }

    public void CreateAcceptAbandoned() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(location).sendKeys("BUFFER_CF");
        driver.findElement(pcs).click();
        driver.findElement(pcs).sendKeys("10");
        driver.findElement(wt).click();
        driver.findElement(wt).sendKeys("100");
        driver.findElement(shc).sendKeys("NOR");
        driver.findElement(dim).click();
        Thread.sleep(1000);
        driver.findElement(dimValue).click();
        driver.findElement(print).click();
        driver.findElement(printValue).click();
        Thread.sleep(2000);
        driver.findElement(pkg).click();
        driver.findElement(pkgType).click();
        driver.findElement(saveBtn).click();
    }



}
