package testCases;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.LoginPageObjects;
import java.io.IOException;
import static utilities.ReadConfig.*;
import static utilities.ScreenShot.captureScreen;

public class loginTest_001 extends BaseClass
{
    @Test
    public void loginTest() throws IOException
    {
        PageFactory.initElements(driver, LoginPageObjects.class);
        LoginPageObjects.userName.sendKeys(getUserName()+Keys.ENTER);
        LoginPageObjects.password.sendKeys(getPassword() + Keys.ENTER);
        logger.info("Entering the username "+getUserName()+" and password "+getPassword());
        try
        {

            if(LoginPageObjects.verifyPassword.isDisplayed()){
                logger.info(getUserName()+" "+getPassword()+" is invalid username and password");
                captureScreen(driver,"loginTest");
            }
        }
        catch (NoSuchElementException exception){
            logger.info(getUserName()+" "+getPassword()+" is valid username and password");
        }
    }

}
