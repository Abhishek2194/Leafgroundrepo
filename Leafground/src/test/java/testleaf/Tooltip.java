package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tooltip {
WebDriver driver=null;
	
	@BeforeMethod
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/tooltip.html");
	}
	

	@Test
	public void tooltipTest()
	{
		WebElement ele = driver.findElement(By.id("age"));
		
		 Actions actions = new Actions(driver); 
		  
		 
		 // Use action class to mouse hover 
		 actions.moveToElement(ele).perform(); 
		 
		 WebElement ele1 = driver.findElement(By.xpath("(//div[.='Enter your Name'])[1]"));
		 String toolTipText = ele1.getText();
		  
		 
		 System.out.println(toolTipText);
		 
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
