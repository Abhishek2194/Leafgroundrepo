package testleaf;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Settingpropfile 
{
	WebDriver driver=null;
	
	
 @Test
    public void settingProperty() throws InterruptedException, AWTException, IOException {
   
 FileInputStream f1= new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\Leafground\\src\\test\\java\\testleaf\\config.properties");
 
 Properties prop =new Properties();
 
 prop.load(f1);
 String browser_name=prop.getProperty("browser");
 String path_name=prop.getProperty("path");
 
 if(browser_name.equalsIgnoreCase("chrome"))
 {
	 System.setProperty("webdriver.chrome.driver", path_name);
	 driver=new ChromeDriver();
	
   }
 else if(browser_name.equalsIgnoreCase("firefox"))
 {
	 System.setProperty("webdriver.gecko.driver", path_name);
	 driver=new FirefoxDriver(); 
 }
 else
 {
	 System.setProperty("webdriver.ie.driver", path_name);
	 driver=new InternetExplorerDriver();  
 }
 
 driver.get("http://demo.guru99.com/selenium/upload/");
 driver.close();
 
}



}
