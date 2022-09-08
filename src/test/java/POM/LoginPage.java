package POM;
import Tests.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

    public LoginPage(WebDriver driver) {
      PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_login")
    WebElement usernameText;

    @FindBy(id = "user_pass")
    WebElement passwordText;

    @FindBy(id = "wp-submit")
    WebElement submitButton;



    public LoginPage sendUser(String username) {
        usernameText.sendKeys(username);
        return this;
    }

    public LoginPage sendPassword(String password) {
        passwordText.sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

}
