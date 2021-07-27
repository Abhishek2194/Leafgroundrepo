package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Contextclickfeature {
WebDriver driver=null;
	
	@BeforeMethod
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/");
	}
	
	@Test
	public void cclick_dclick_Test() 
	{
	
	
	//Click on edit
	driver.findElement(By.xpath("//h5[.='Edit']")).click();
	
	
//Enter Email address	
    WebElement ele = driver.findElement(By.id("email"));
    
    ele.sendKeys("abhisheka.a@hcl.com");
    
    Actions act= new Actions(driver);
    
  //double click
    act.doubleClick(ele).build().perform();
    
    //Right click on the element
    
    act.contextClick(ele).build().perform();
    
    
    
    
    

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}


}
