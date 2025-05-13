package FlightObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TruckFlight {
    WebDriver driver;
    public TruckFlight(WebDriver driver){
        this.driver=driver;
    }


    By createbtn= By.xpath("//button[@test-id='Create']");
    By truckNo=By.xpath("//input[@test-id='createTruckLst.0.truckFltNo']");
    By savebtn=By.xpath("//span[normalize-space()='Save']");

    public void NavigatetoTruckFlight() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("http://172.18.151.138/cms-portal/flight/truckFlight");
    }


    public void CreateFlight(String TruckNo) throws InterruptedException {
        driver.findElement(createbtn).click();
        Thread.sleep(2000);
        driver.findElement(truckNo).sendKeys(TruckNo);
        driver.findElement(savebtn).click();
        Thread.sleep(2000);
    }

}
