package testCases;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import static utilities.ReadConfig.*;

public class BaseClass
{
        public static WebDriver driver=null;
        public static Logger logger=Logger.getLogger( BaseClass.class);
        @BeforeTest
        public void setup()
        {
            loadPropertyFile();
            PropertyConfigurator.configure("Logs.properties");
            String browser=getBrowser();
            String url=geturl();
            if (browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();

            }
            else if (browser.equalsIgnoreCase("fireFox")){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }
            else if(browser.equalsIgnoreCase("InternetExplorer")){
                WebDriverManager.edgedriver().setup();
                driver= new EdgeDriver();
            }
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("Launching the "+getBrowser());
            logger.info("Navigate to yahoo.com");
        }


        @AfterTest
        public void close(){
           driver.quit();
           logger.info("quit the browser");
        }

    }

