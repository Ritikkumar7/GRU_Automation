package Flight_Test_Case;
import FlightObject.CreateMasterSchedule;
import FlightObject.MaintainMasterSchedule;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CreateMaster_Test_Case_3 {
    WebDriver driver;
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
    Random r = new Random();
    String flight_no=String.format("%04d", r.nextInt(1001));
    String date=dateFormat.format(currentDate);

    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
    LocalDate tomorrow=LocalDate.now().plusDays(1);
    String String_tomorrow=tomorrow.format(formatter);

    @BeforeTest
    public void beforetest() throws InterruptedException {
        System.out.println("Test Case Start -----------------------------------------------------");
        LoginGRU page=new LoginGRU(driver);
        page.Login("Siddhant","Cargo@123");

    }

    @Test(priority = 1)
    public void LoginOperation() throws InterruptedException {
        LoginGRU page= new LoginGRU(driver);
        page.Login("Ritik","Cargo@123");
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void CreateMasterSchedule() throws InterruptedException, IOException {
        CreateMasterSchedule page= new CreateMasterSchedule(driver);
        System.out.println("Navigating to Flight ");
        page.NavigatetoCreatemasterSchedule();

        Thread.sleep(2000);
        System.out.println("Entering flight details");
        page.createMasterflightLeg("EK",flight_no,date,String_tomorrow);
        System.out.println(String_tomorrow);

        System.out.println("Entering Schedule details");
        page.scheduleDetails();

        Thread.sleep(2000);
        WebElement validateUpdate = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String updateResult = validateUpdate.getAttribute("innerText");
        Assert.assertEquals(updateResult, "common.success: common.success");
        System.out.println(updateResult);
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/createMasterFlight.png"));
    }

    @Test(priority = 3)
    public void MaintainMasterSchedule() throws InterruptedException, IOException {
        MaintainMasterSchedule page= new MaintainMasterSchedule(driver);
        System.out.println("Navigating to maintain Master Schedule");
        page.NavigateToMaintainMasterSchedule();

        System.out.println("Enter flight details");
        page.maintainFLightSearchDetails("EK",flight_no);
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//a[@style='white-space: nowrap;']"));
        String result = element.getAttribute("innerText");
        Assert.assertEquals("EK"+flight_no,result );

        System.out.println("Updating Master Flight");
        page.UpdatingTheMasterFlight();
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/updateMasterFlight.png"));
    }

    @AfterTest()
    public void aftertest() throws Exception{
        Thread.sleep(5000);
        driver.quit();
    }
}
