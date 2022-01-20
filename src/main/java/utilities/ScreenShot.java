package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot
{
    public static void captureScreen(WebDriver driver,String testName) throws IOException
    {
        String userDir=System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePath=userDir+pathSeparator+"screenshots"+pathSeparator+testName+".png";
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File target=new File(filePath);
        FileUtils.copyFile(source,target);

    }
}
