package FlightObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MaintainDailyFlight {
    WebDriver driver;
    public MaintainDailyFlight(WebDriver driver){
        this.driver=driver;
    }

    By carrier= By.xpath("//input[@test-id='criteriaBo.flightCarr']");
    By flightNo= By.xpath("//input[@test-id='criteriaBo.flightNo']");
    By searchbtn=By.xpath("//button[@test-id='Search']");
    By updatebtn=By.xpath("//i[@data-type='edit']");
    By savebtn=By.xpath("//span[normalize-space()='Save']");


    public void NavigateTOMaintainDailyFlight() throws InterruptedException{
        Thread.sleep(5000);
        driver.get("http://172.18.151.138/cms-portal/flight/openDailyFlightEnquiry");
    }

    public void EnterFlightDetails(String Carrier,String Flight){
//        driver.findElement(carrier).sendKeys(Carrier);
        driver.findElement(flightNo).sendKeys(Flight);
        driver.findElement(searchbtn).click();
    }

    public void UpdatingFlightDetails(){
        driver.findElement(updatebtn).click();
        driver.findElement(savebtn).click();
    }

}

