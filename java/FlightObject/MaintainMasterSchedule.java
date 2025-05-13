package FlightObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MaintainMasterSchedule {
    WebDriver driver;
    public MaintainMasterSchedule(WebDriver driver){
        this.driver=driver;
    }

    public void NavigateToMaintainMasterSchedule() throws InterruptedException {
        Thread.sleep(3000);
        driver.get("http://172.18.151.138/cms-portal/flight/openFlightScheduleEnquiry");
    }

    By carrier= By.xpath("//input[@test-id='criteriaBo.flightCarr']");
    By flightNo=By.xpath("//input[@test-id='criteriaBo.flightNo']");
    By searchbtn=By.xpath("//button[@test-id='Search']");
    By actiobtn=By.xpath("//i[@class='fa fa-edit fa-md ng-star-inserted']");
    By savebtn=By.xpath("//span[normalize-space()='Save']");

    public void maintainFLightSearchDetails(String Carrier, String FlightNo) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(carrier).sendKeys(Carrier);
        driver.findElement(flightNo).sendKeys(FlightNo);
        driver.findElement(searchbtn).click();

    }

    public void UpdatingTheMasterFlight() throws InterruptedException {
        driver.findElement(actiobtn).click();
        Thread.sleep(2000);
        driver.findElement(savebtn).click();
        Thread.sleep(2000);
    }
}
