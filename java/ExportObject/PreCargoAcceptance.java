package ExportObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PreCargoAcceptance {
    WebDriver driver;
    public PreCargoAcceptance(WebDriver driver){
        this.driver=driver;
    }

    By awb=By.xpath("//input[@test-id='mrclBulkHeader.awbNo']");
    By awbOrigin=By.xpath("//input[@test-id='mrclBulkHeader.awbOrg']");
    By awbDestination=By.xpath("//input[@test-id='mrclBulkHeader.awbDest']");
    By pieces=By.xpath("//input[@test-id='mrclBulkHeader.pieces']");
    By weight=By.xpath("//input[@test-id='mrclBulkHeader.weight']");
    By shc=By.xpath("//input[@test-id='mrclBulkHeader.splCode1']");
    By exporterCNPJ=By.xpath("//input[@test-id='mrclBulkHeader.exporterCnpjId']");
    By agentCNPJ=By.xpath("//input[@test-id='mrclBulkHeader.agentCnpjId']");
    By typeOfPackaging=By.xpath("(//i[@data-type='dropdown'])[1]");
    By valueOfPackaging=By.xpath("//span[normalize-space()='01 Tambor de Plastico']");
    By generateChargerFor=By.xpath("(//i[@data-type='dropdown'])[2]");
    By valueOfGenertae=By.xpath("//span[normalize-space()='Agente']");
    By manualDseRuc=By.xpath("//input[@test-id='mrclBulkHeader.manualDSE']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");

    public void CreatePreCargoAcceptance(String AWBNo,String DueNo) throws InterruptedException {
        driver.findElement(awb).click();
        driver.findElement(awb).sendKeys(AWBNo);
        driver.findElement(awbOrigin).click();
        driver.findElement(awbOrigin).sendKeys("GRU");
        driver.findElement(awbDestination).click();
        driver.findElement(awbDestination).sendKeys("SIN");
        driver.findElement(pieces).sendKeys("9999");
        driver.findElement(weight).sendKeys("9999999");
        driver.findElement(shc).sendKeys("NOR");
        driver.findElement(exporterCNPJ).click();
        driver.findElement(exporterCNPJ).sendKeys("00.074.635/0001-33");
        driver.findElement(agentCNPJ).click();
        driver.findElement(agentCNPJ).sendKeys("00.026.733/0001-03");
        driver.findElement(typeOfPackaging).click();
        driver.findElement(valueOfPackaging).click();
        driver.findElement(generateChargerFor).click();
        driver.findElement(valueOfGenertae).click();
        driver.findElement(manualDseRuc).sendKeys(DueNo);
        driver.findElement(saveBtn).click();
    }
}

