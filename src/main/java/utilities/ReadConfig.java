package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
    public static Properties properties;
    public static void loadPropertyFile(){
        String userDir=System.getProperty("user.dir");
        String pathSeparator = System.getProperty("file.separator");
        String filePath=userDir+pathSeparator+"configuration"+pathSeparator+"config.properties";
        try
        {
            FileInputStream fileInputStream=new FileInputStream(filePath);
            properties =new Properties();
            properties.load(fileInputStream);
        }
        catch (Exception e){
            System.out.println("Exception is "+e.getMessage());
        }
    }
    public static String getBrowser(){
        String browser=properties.getProperty("browser");
        return browser;
    }
    public static String geturl(){
        String url=properties.getProperty("url");
        return url;
    }
    public static String getUserName(){
        String userName=properties.getProperty("userName");
        return userName;
    }
    public static String getPassword(){
        String password=properties.getProperty("password");
        return password;
    }



}
