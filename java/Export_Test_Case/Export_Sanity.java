package Export_Test_Case;

import ExportObject.*;
import FlightObject.CreateDailyFlight;
import LoginGRU.LoginGRU;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
//import org.hyperic.sigar.cmd.Du;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Export_Sanity {
    WebDriver driver;
    Random r = new Random();
    public static String getRandomSuffix(){
        Random random = new Random();
        int num = random.nextInt(10000000);
        String suffix = String.valueOf(num) + String.valueOf((num%7));
        return String.format("%08d", Integer.parseInt(suffix));
    }
    String AWBNo = "000"+getRandomSuffix();
    String DueNo = getRandomSuffix();
    Date currentDate = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
    String flight_no="000";
    String date="03MAY2025";


    @BeforeTest
    public void beforetest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://172.18.151.138/cms-portal/");
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void LoginOperation() throws InterruptedException {
        System.out.println("Test Case Start -----------------------------------------------------");
        LoginGRU page=new LoginGRU(driver);
        page.Login("utkarsh","Arsh@1231001");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void PreCargoAcceptance() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        PreCargoAcceptance page = new PreCargoAcceptance(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Pre Cargo Acceptance");
        page.CreatePreCargoAcceptance(AWBNo, DueNo);
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        Assert.assertEquals("Pre-Cargo acceptance successfully", result);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/preCargoAcceptance.png"));
        System.out.println("Pre Cargo Acceptance Completed");
    }

    @Test(priority = 4)
    public void EnquirePreCargoAcceptance() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        EnquirePreCargo page = new EnquirePreCargo(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Enquire Pre Cargo Acceptance");
        page.SeacrhShipment(DueNo);
        page.UpdatePreCargo();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        Assert.assertEquals("Pre-Cargo updated successfully", result);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/enquirePreCargoAcceptance.png"));
        System.out.println("Enquire Pre Cargo Acceptance Completed");
    }

    @Test(priority = 5)
    public void CargoAcceptance() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CargoAcceptance page = new CargoAcceptance(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Cargo Acceptance");
        page.SeacrhShipment(AWBNo);
        page.CargoAceptance();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        Assert.assertEquals("Operation Completed Successfully.", result);
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(result);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/CargoAcceptance.png"));
        System.out.println("Cargo Acceptance Completed");
    }

    @Test(priority = 6)
    public void MaintainExportCar() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MaintainExportCar page=new MaintainExportCar(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Maintain Export CAR");
        page.SearchShipment(AWBNo);
        page.UpdateExportCAR();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println(result);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/MaintainExportCar.png"));
        System.out.println("Maintain Export Car Completed");
    }

    @Test(priority = 7)
    public void ExportDiscrapancyList() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ExportDiscrepancyList page=new ExportDiscrepancyList(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Export Discrepancy List");
        page.SeachExportDiscrepancyList(AWBNo);
        page.CCTManualUpdate();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/preCargoAcceptance.png"));
        page.ManualBillingUpdate();
        System.out.println("Export Discrapancy List Completed");
    }

    @Test(priority = 8)
    public void ExportDeliveryRequest() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ExportDeliveryRequest page=new ExportDeliveryRequest(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Export Delivery Request");
        page.CreateRequest(flight_no,date);
        page.AWBDetails(AWBNo);
        page.StatusUpdate();
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/ExportDeliveryRequest.png"));
    }

    @Test(priority = 9)
    public void ReleaseMonitoring() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ReleaseMonitoring page=new ReleaseMonitoring(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Release Monitoring");
        page.SearchAWB(AWBNo,date);
        page.ApproveStatus();
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/ReleaseMon.png"));

    }

    @Test(priority = 10)
    public void DesktopDelivery() throws InterruptedException, IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DesktopDelivery page=new DesktopDelivery(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Desktop Delivery");
        page.SeachDesktopDelivery(AWBNo,date);
        page.DeliverAWB();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Export/Desktopdelivery.png"));
    }

}