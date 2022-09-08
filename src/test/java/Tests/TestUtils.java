package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestUtils {

    public WebDriver driver;
    WebDriverWait wait;



    public WebDriverWait getWaitSec(int sec) {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        }
        return wait;
    }

    public void getLoginPage() {
        driver.get("https://birom.biz/test/wp-login.php");
    }

    @BeforeMethod
    public void startDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }



    @AfterMethod
    public void stopDriver() {
        driver.quit();
    }


}
