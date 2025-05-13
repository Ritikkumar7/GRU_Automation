package Flight_Test_Case;

import FlightObject.TruckFlight;
import LoginGRU.LoginGRU;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TruckFlight_Test_Case_2 {
    WebDriver driver;
    Date currentDate = new Date();
    Random r = new Random();
    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
    String date=dateFormat.format(currentDate);
    String truck_no=String.format("%06d", r.nextInt(1001));

    @BeforeTest()
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
    public void CreateTruckFlight() throws InterruptedException, IOException {
        TruckFlight page=new TruckFlight(driver);
        System.out.println("navigiting to Truck Flight");
        page.NavigatetoTruckFlight();
        System.out.println("Creating truck");
        Thread.sleep(2000);
        page.CreateFlight(truck_no);

        System.out.println("Validating truck details");
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        Assert.assertEquals("save.success: Record(s) Saved Successfully: "+truck_no+"/"+date, result);
        System.out.println(result);
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/truckFlight.png"));
    }

    @AfterTest()
    public void aftertest() throws Exception{
        Thread.sleep(5000);
        driver.quit();
    }

}
