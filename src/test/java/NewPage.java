import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewPage {

    WebDriver driver;
    @Test
    public void test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://birom.biz/test");
        driver.findElement(By.xpath("//*[@id=\"modal-2-content\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Sample Page - Our Freaking Test Site");
        driver.quit();


    }



}
