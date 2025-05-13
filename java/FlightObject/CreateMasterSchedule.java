package FlightObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateMasterSchedule {
    WebDriver driver;
    public CreateMasterSchedule(WebDriver driver){
        this.driver=driver;
    }
    By carrier= By.xpath("//input[@test-id='scheduleBO.flightCarr']");
    By flightNo=By.xpath("//input[@test-id='scheduleBO.flightNo']");
    By startDate=By.xpath("//input[@test-id='scheduleBO.startDate']");
    By endDate=By.xpath("//input[@test-id='scheduleBO.endDate']");
    By primaryModule=By.xpath("(//div[@role='button'])[5]");
    By dropdownOfPrimaryModule=By.xpath("//span[normalize-space()='ALFA']");
    By secondaryModule=By.xpath("(//div[@role='button'])[6]");
    By dropdownOfSecondaryModule=By.xpath("//span[normalize-space()='FOX']");
    By pax=By.xpath("(//div[@role='button'])[8]");
    By dropdownOfPax=By.xpath("//span[normalize-space()='ALL']");
    By service=By.xpath("(//div[@role='button'])[9]");
    By dropdownOfService=By.xpath("//span[normalize-space()='Ferry Flight']");
    By tue=By.xpath("//div[@test-id='tuesday']");
    By boardPoint=By.xpath("//input[@test-id='legs.0.boardPoint']");
    By offPoint=By.xpath("//input[@test-id='legs.0.offPoint']");
    By depDayChange=By.xpath("//input[@test-id='legs.0.depDayChange']");
    By arrDayChange=By.xpath("//input[@test-id='legs.0.arrDayChange']");
    By acType=By.xpath("//input[@test-id='legs.0.aircraftType']");
    By dta=By.xpath("//input[@test-id='legs.0.scheduleDepTime']");
    By sta=By.xpath("//input[@test-id='legs.0.scheduleArrTime']");
    By save=By.xpath("//span[normalize-space()='Save']");



    public void NavigatetoCreatemasterSchedule() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("http://172.18.151.138/cms-portal/flight/scheduleAction");
    }

    public void createMasterflightLeg(String Carrier,String Flight,String StartDate,String EndDate){
        driver.findElement(flightNo).sendKeys(Flight);
        driver.findElement(carrier).sendKeys(Carrier);
        driver.findElement(startDate).sendKeys(StartDate);
        driver.findElement(endDate).sendKeys(EndDate);
        driver.findElement(primaryModule).click();
        driver.findElement(dropdownOfPrimaryModule).click();
        driver.findElement(secondaryModule).click();
        driver.findElement(dropdownOfSecondaryModule).click();
        driver.findElement(pax).click();
        driver.findElement(dropdownOfPax).click();
        driver.findElement(service).click();
        driver.findElement(dropdownOfService).click();
    }

    public void scheduleDetails(){
        driver.findElement(boardPoint).sendKeys("GRU");
        driver.findElement(offPoint).sendKeys("SIN");
        driver.findElement(depDayChange).sendKeys("0");
        driver.findElement(arrDayChange).sendKeys("0");
        driver.findElement(acType).sendKeys("33A");
        driver.findElement(dta).sendKeys("12:02");
        driver.findElement(sta).sendKeys("22:02");
        driver.findElement(tue).click();
        driver.findElement(save).click();
    }

}
