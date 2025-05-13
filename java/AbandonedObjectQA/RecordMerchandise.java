package AbandonedObjectQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecordMerchandise {
    WebDriver driver;
    public RecordMerchandise(WebDriver driver){
        this.driver=driver;
    }

    By awb=By.xpath("//input[@test-id='searchObjBO.awbNo']");
    By searchBtn=By.xpath("//button[@test-id='Search']");
    By documentNo=By.xpath("//input[@test-id='searchResultObjBO.numberofDocument']");
    By documentDropdown=By.xpath("(//i[@data-type='dropdown'])[3]");
    By documentvalue=By.xpath("//span[normalize-space()='EMAP']");
    By customAgetName=By.xpath("//input[@test-id='searchResultObjBO.customAgentName']");
    By sel=By.xpath("(//div[@role='checkbox'])[2]");
    By NCM=By.xpath("//input[@test-id='resultMerchandiseList.0.ncm']");
    By description=By.xpath("//textarea[@type='text']");
    By pcs=By.xpath("//input[@test-id='resultMerchandiseList.0.customQty']");
    By wt=By.xpath("//input[@test-id='resultMerchandiseList.0.unitValueRDollar']");
    By unit=By.xpath("(//i[@data-type='dropdown'])[4]");
    By unitValue=By.xpath("//span[normalize-space()='KG']");
    By saveBtn=By.xpath("//span[normalize-space()='F8']");

    public void SearchRecordMerchandise(String AWB) throws InterruptedException {
        driver.findElement(awb).sendKeys(AWB);
        driver.findElement(searchBtn).click();
    }

    public void RecordMerchandise(String DocumentNo){
        driver.findElement(documentDropdown).click();
        driver.findElement(documentvalue).click();
        driver.findElement(documentNo).sendKeys(DocumentNo);
        driver.findElement(customAgetName).sendKeys("Ritik");
        driver.findElement(sel).click();
        driver.findElement(NCM).sendKeys("8429.11.10");
        driver.findElement(description).sendKeys("This is descriptions");
        driver.findElement(unit).click();
        driver.findElement(unitValue).click();
        driver.findElement(pcs).click();
        driver.findElement(pcs).sendKeys("9999");
        driver.findElement(wt).click();
        driver.findElement(wt).sendKeys("99999");
        driver.findElement(saveBtn).click();
    }


}
