package Tests;

import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class CommonTests extends TestUtils {

    @Test
    public void testTitle() {
        driver.get("http://birom.biz/test");
        WebElement title = driver.findElement(By.xpath("//*[@id=\"modal-2-content\"]/ul/li[2]/a"));
        title.click();

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Sample Page – Our Freaking Test Site");
    }

    @Test
    public void testVisibility() {
        driver.get("http://birom.biz/test");
        WebElement title = driver.findElement(By.xpath("//*[@id=\"modal-2-content\"]/ul/li[2]/a"));
        Assert.assertTrue(title.isDisplayed());

    }

    @Test
    public void loginTest() {
        driver.get("https://birom.biz/test/wp-login.php");
        driver.findElement(By.id("user_login")).sendKeys("gurar1986@gmail.com");
        driver.findElement(By.id("user_pass")).sendKeys("cyo*@dPuM8$IIJ4oyx4jP@aw");
        driver.findElement(By.id("wp-submit")).click();

        WebElement welcomeTitle = driver.findElement(By.xpath("//div[contains(@class,'welcome')]/h2"));

        getWaitSec(6).until(ExpectedConditions.visibilityOf(welcomeTitle));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(welcomeTitle.getText(), "Welcome to your WordPress site!");
    }

    @Test
    public void loginTestWithPOM() throws InterruptedException {

        getLoginPage();

        new LoginPage(driver)
                .sendUser("gurar1986@gmail.com")
                .sendPassword("cyo*@dPuM8$IIJ4oyx4jP@aw")
                .clickSubmit();

        WebElement welcomeTitle = driver.findElement(By.xpath("//div[contains(@class,'welcome')]/h2"));
        getWaitSec(6).until(ExpectedConditions.visibilityOf(welcomeTitle));
        Assert.assertEquals(welcomeTitle.getText(), "Welcome to your WordPress site!");
    }

    @Test @Ignore
    public void restassuredTest() {
        

    }

}
