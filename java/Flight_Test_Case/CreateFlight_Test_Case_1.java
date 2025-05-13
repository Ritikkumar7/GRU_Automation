package Flight_Test_Case;

import FlightObject.CreateDailyFlight;
import FlightObject.MaintainDailyFlight;
import LoginGRU.LoginGRU;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class CreateFlight_Test_Case_1 {

    WebDriver driver;
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
    Random r = new Random();
    String flight_no=String.format("%04d", r.nextInt(1001));
    String date=dateFormat.format(currentDate);
    SimpleDateFormat departure_date_Format=new SimpleDateFormat("ddMMMyyyy"+"22");
    SimpleDateFormat arrival_date_Format=new SimpleDateFormat("ddMMMyyyy"+"23");
    String departure_date=departure_date_Format.format(currentDate);
    String arrival_date=arrival_date_Format.format(currentDate);



    @BeforeTest
    public void beforetest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://172.18.151.138/cms-portal/");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void LoginOperation() throws InterruptedException {
        System.out.println("Test Case Start -----------------------------------------------------");
        LoginGRU page=new LoginGRU(driver);
        page.Login("Siddhant","Cargo@123");
    }

    @Test(priority = 2)
    public void CreateDepartureFlight() throws InterruptedException, IOException {
        CreateDailyFlight page= new CreateDailyFlight(driver);
        System.out.println("Navigating to Flight ");
        page.NavigateToCreateDailyFlight();

        System.out.println("Entering Flight Details");
        page.DeperatureFlightSearchDetails("EK",flight_no,date);

        System.out.println("Entering Flight Leg Details");
        page.LegDetails("GRU","SIN",departure_date,arrival_date);

        System.out.println("Saving the Result");
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        Assert.assertEquals("001: Flight Created Successfully", result);
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/createFlight.png"));
    }

    @Test(priority = 3)
    private void MaintainDailyFlight() throws InterruptedException, IOException {
        MaintainDailyFlight page= new MaintainDailyFlight(driver);
        System.out.println("Navigating to Maintain Daily Flight");
        page.NavigateTOMaintainDailyFlight();

        System.out.println("Enter Flight Details to Maintain Daily Flight Screen");
        page.EnterFlightDetails("EK",flight_no);

        Thread.sleep(3000);
        System.out.println("Validating the Flight");
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyy");
        WebElement element = driver.findElement(By.xpath("//span[@class='label-nl' and contains(text(),'EK')]"));
        String result = element.getAttribute("innerText");
        Assert.assertEquals("EK"+flight_no+"-"+dateFormat.format(currentDate),result );


        System.out.println("Updating the Flight Details");
        page.UpdatingFlightDetails();
        Thread.sleep(2000);
        WebElement validateUpdate = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String updateResult = validateUpdate.getAttribute("innerText");
        Assert.assertEquals("001: Flight Updated Successfully",updateResult);
        System.out.println(updateResult);
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/maintainFlight.png"));
    }

    @AfterTest()
    public void aftertest() throws Exception{
        Thread.sleep(5000);
        driver.quit();
    }
}