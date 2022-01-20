package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects
{
    @FindBy(xpath = "//input[@id='login-username']")
    public static WebElement userName;
    @FindBy(xpath = "//input[@id='login-passwd']")
    public static WebElement password;
    @FindBy(xpath = "//p[@class='error-msg']")
    public static WebElement verifyPassword;

}
