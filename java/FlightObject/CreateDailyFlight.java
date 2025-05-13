package FlightObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateDailyFlight {
    WebDriver driver;
    public CreateDailyFlight(WebDriver driver){
        this.driver=driver;
    }


    By dropdownOfArrival=By.xpath("(//div[@role='button'])[1]");
    By deperature=By.xpath("//span[normalize-space()='Departure']");
    By carrier=By.xpath("//input[@type='text' and @test-id='flightBo.flightCarr']");
    By flightNo=By.xpath("//input[@type='text' and @test-id='flightBo.flightNo']");
    By date=By.xpath("//input[@test-id='flightBo.schDate']");
    By from=By.xpath("(//input[@type='text'])[8]");
    By to=By.xpath("(//input[@type='text'])[9]");
    By departureDate=By.xpath("(//input[@type='text'])[10]");
    By arrivalDate=By.xpath("(//input[@type='text'])[11]");
    By aircraft=By.xpath("(//input[@type='text'])[12]");
    By flightPax=By.xpath("(//div[@role='button'])[12]");
    By dropdownOfflightPax=By.xpath("//span[normalize-space()='ALL']");
    By flightPriority=By.xpath("(//div[@role='button'])[14]");
    By getDropdownOfPriority=By.xpath("(//span[normalize-space()='Normal'])[2]");
    By serviceType=By.xpath("(//div[@role='button'])[15]");
    By getDropdownOfService=By.xpath("//span[normalize-space()='Ad Hoc']");
    By micsDetails=By.xpath("//span[normalize-space()='Misc Details']");
    By savebutton=By.xpath("//span[normalize-space()='Save']");



    public void NavigateToCreateDailyFlight() throws InterruptedException {
        Thread.sleep(5000);
        driver.get("http://172.18.151.138/cms-portal/flight/openDailyFlight");
    }

    public void DeperatureFlightSearchDetails(String Carrier,String FlightNo,String Date){
        try{
            driver.findElement(dropdownOfArrival).click();
            driver.findElement(deperature).click();
            driver.findElement(carrier).sendKeys(Carrier);
            driver.findElement(flightNo).sendKeys(FlightNo);
            driver.findElement(date).sendKeys(Date);
        }catch (Exception e){
            System.out.println("Exception Catch "+e.getMessage());
        }
    }

    public void LegDetails(String From, String To,String Departure_Date,String Arrival_Date){
        driver.findElement(from).sendKeys(From);
        driver.findElement(to).sendKeys(To);
        driver.findElement(departureDate).sendKeys(Departure_Date);
        driver.findElement(arrivalDate).sendKeys(Arrival_Date);
        driver.findElement(aircraft).sendKeys("33A");
        driver.findElement(micsDetails).click();
        driver.findElement(flightPax).click();
        driver.findElement(dropdownOfflightPax).click();
        driver.findElement(flightPriority).click();
        driver.findElement(getDropdownOfPriority).click();
        driver.findElement(serviceType).click();
        driver.findElement(getDropdownOfService).click();
        driver.findElement(micsDetails).click();
        driver.findElement(savebutton).click();
    }

}
