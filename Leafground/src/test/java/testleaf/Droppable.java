package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Droppable 
{
	
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
	public void droppableTest()
	{
	
	driver.findElement(By.xpath("//h5[.='Droppable']")).click();
	
	WebElement src = driver.findElement(By.id("draggable"));
	
	WebElement dest = driver.findElement(By.id("droppable"));
	
	Actions act= new Actions(driver);
	act.dragAndDrop(src, dest).build().perform();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}


}
