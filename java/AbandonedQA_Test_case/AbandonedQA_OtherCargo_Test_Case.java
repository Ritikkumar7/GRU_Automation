package AbandonedQA_Test_case;

import AbandonedObjectQA.*;
import LoginGRU.LoginGRU;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class AbandonedQA_OtherCargo_Test_Case {

    WebDriver driver;
    Random r = new Random();
    String AWB=String.format("%08d", r.nextInt(1001));
    String DocumentNo=String.format("%04d", r.nextInt(1001));
    String EDTNo=String.format("%04d", r.nextInt(1001));
    String ProcessNo=String.format("%04d", r.nextInt(1001));
    String  PropositionNo=String.format("%04d", r.nextInt(1001));
    String SearchPropositionNo="AUC"+PropositionNo;
    String LotNo=String.format("%04d", r.nextInt(1001));
    String DeliveryNo=String.format("%06d", r.nextInt(1001));


    static ExtentTest test;
    static ExtentReports report;


    @BeforeTest
    public void beforetest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://172.18.151.138/cms-portal/");
        Thread.sleep(5000);
        report = new ExtentReports("C:\\java_Eclipes\\Intellij_code\\ScreenShot\\Abandoned\\reports\\AbandonedOtherCargo.html");
        test = report.startTest("Test Case Start");
    }

    @AfterTest()
    public void aftertest(){
        driver.close();
        report.endTest(test);
        report.flush();
    }

    @Test(priority = 1)
    public void LoginOperation() throws InterruptedException {
        System.out.println("Test Case Start -----------------------------------------------------");
        LoginGRU page=new LoginGRU(driver);
        page.Login("Siddhant","Cargo@123");
        test.log(LogStatus.PASS, "User successfully login");
    }

    @Test(priority = 2)
    public void CreateAcceptAbandoned() throws InterruptedException, IOException {
        AcceptAbandoned page=new AcceptAbandoned(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(3000);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Accept Abandoned Cargo");
        test.log(LogStatus.PASS, "Navigate to Accept Abandoned Cargo Screen");
        page.SearchAcceptAbandonedCargoListOtherCargo(AWB);
        page.CreateAcceptAbandoned();
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        test.log(LogStatus.PASS, "Other Cargo AWB is created ->"+AWB);
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/Acceptabandoned.png"));
    }

    @Test(priority = 3)
    public void CreateShipmentSorting() throws InterruptedException, IOException {
        CreateShipmentSorting page=new CreateShipmentSorting(driver);
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Create Shipment Sorting");
        page.SearchCreateShipmentSorting(AWB);
        page.CreateShipmentSorting();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/CreateShipmentsorting.png"));
        if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "Create shipment sorting is completed");
        }
        else{
            test.log(LogStatus.FAIL,"Shipment is not sorted");
//            driver.close();
        }

    }

    @Test(priority = 4)
    public void RecordMerchandise() throws InterruptedException, IOException {
        RecordMerchandise page=new RecordMerchandise(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Record Merchandise");
        test.log(LogStatus.PASS,"Navigate to Record Merchandise Screen");
        page.SearchRecordMerchandise(AWB);
        page.RecordMerchandise(DocumentNo);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/RecordMerchandise.png"));
        if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "Record Merchandise is Created");
        }
        else{
            test.log(LogStatus.FAIL,"Error is showing in EDT Detials");
            driver.close();
        }
    }

    @Test(priority = 5)
    public void RecordEDTDetails() throws InterruptedException, IOException {
        RecordEDTDetails page=new RecordEDTDetails(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Record EDT Details");
        test.log(LogStatus.INFO, "Navigate to Record EDT Details");
        page.SearchRecordEDTDetails(AWB);
        page.RecordEDTDetails(EDTNo,ProcessNo);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/EDT.png"));
        if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "EDT and Process no is Saved");
        }
        else{
            test.log(LogStatus.FAIL,"Error is showing in EDT Detials");
            driver.close();
        }
    }

    @Test(priority = 6)
    public void RequestItemSegregation() throws InterruptedException, IOException {
        RequestItemSegregation page=new RequestItemSegregation(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Request Item Segregation");
        test.log(LogStatus.PASS, "Navigate to Request Item Seggregation Screen");
        page.SearchRequestItemSegregation(AWB);
        test.log(LogStatus.PASS, "Enter the Proposition Details");
        page.RequestItemSegregation(PropositionNo);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/RequestItemSegg.png"));
        if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "Proposition No is Enter"+PropositionNo);
        }
        else{
            test.log(LogStatus.FAIL,"Error is showing when creating propostion no");
            driver.close();
        }
        Thread.sleep(1000);
        page.ClickOnSegregated("AUC"+PropositionNo);
          if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "Proposition No is created AUC"+PropositionNo);
        }
        else{
            test.log(LogStatus.FAIL,"Error is showing when user click on mark as seggregated");
            driver.close();
        }
    }

    @Test(priority = 7)
    public void CreateAuctionLot() throws InterruptedException, IOException {
        CreateAuctionLots page=new CreateAuctionLots(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Create Auction Lots");
        test.log(LogStatus.PASS, "Navigate to Auction Lots Screen");
        page.SearchCreateAuctionLot(SearchPropositionNo,LotNo);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/AuctionLOt.png"));
        if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "Auction No is created");
        }
        else{
            test.log(LogStatus.FAIL,"Error is showing in Auction Lot Screen");
            driver.close();
        }}

    @Test(priority = 8)
    public void ReleaseMerchandise() throws InterruptedException, IOException {
        ReleaseMerchandise page=new ReleaseMerchandise(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Release Merchandise");
        test.log(LogStatus.PASS, "Navigate to Release Merchandise Screen");
        page.SearchReleaseMerchandise(SearchPropositionNo,DeliveryNo);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/Releasemerchandise.png"));
        if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "Data is saved in Release Merchandise Screen with Delivery No"+DeliveryNo);
        }
        else{
            test.log(LogStatus.FAIL,"Error is showing in Release merchandise screen");
            driver.close();
        }}

    @Test(priority = 9)
    public void CaptureDelivery() throws InterruptedException, IOException {
        CaptureDelivery page=new CaptureDelivery(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Capture Delivery");
        test.log(LogStatus.PASS, "Navigate to Capture Delivery Screen");
        page.SearchCaptureDelivery(DeliveryNo);
        WebElement element = driver.findElement(By.xpath("//p[@class='ng-star-inserted']"));
        String result = element.getAttribute("innerText");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/Capturedelivery.png"));
        if(result.equals("Operation Completed Successfully.")){
            test.log(LogStatus.PASS, "Data is saved in Release Merchandise Screen");
        }
        else{
            test.log(LogStatus.FAIL,"Error is showing in Release merchandise screen");
            driver.close();
        }}

    @Test(priority = 10)
    public void EnquireAbandonedCargo() throws InterruptedException, IOException {
        EnquireAbandonedCargo page=new EnquireAbandonedCargo(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoginGRU navigate=new LoginGRU(driver);
        navigate.ScreenNavigateion("Enquire Abandoned Cargo");
        test.log(LogStatus.PASS, "Navigate to Enquire Abandoned Cargo");
        page.SearchEnquireAbandonedCargo(AWB);
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:/java_Eclipes/Intellij_code/ScreenShot/Abandoned/EnquireAbandondCargo.png"));
        test.log(LogStatus.PASS, "All Abandoned data is showing in Enquire");
        System.out.println("Test Case End -----------------------------------------------------------");
    }
}
