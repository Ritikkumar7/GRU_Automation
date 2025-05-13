package LoginGRU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginGRU {
    WebDriver driver;
    public LoginGRU(WebDriver driver){
        this.driver=driver;
    }
    By search=By.xpath("//input[@name='search']");
    By Enter=By.xpath("//a[@tabindex='0']");
    By ENterr=By.xpath("//a[normalize-space()='ScrreName']");

    public void Login(String username,String pasword){
        WebElement LoginScreen=driver.findElement(By.id("username"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        webDriverWait.until(ExpectedConditions.visibilityOf(LoginScreen));
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(pasword);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void ScreenNavigateion(String ScreenName) throws InterruptedException {
        driver.findElement(search).click();
        driver.findElement(search).sendKeys(ScreenName);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='"+ScreenName+"']")).click();
        Thread.sleep(1000);
    }
}
