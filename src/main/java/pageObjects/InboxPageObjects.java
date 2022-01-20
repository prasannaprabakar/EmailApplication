package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InboxPageObjects
{
    @FindBy(xpath = "//div[@class='D_F o_h G_e em_N']/span[@class='o_h J_x em_N G_e']/child::*")
    public static List<WebElement> sender;
    @FindBy(xpath = "//span[@data-test-id='message-subject']")
    public static List<WebElement> subject;
    @FindBy(xpath = "//time/span")
    public static List<WebElement> time;

}
