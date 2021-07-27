package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selectable 
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
	public void selectableTest()
	{
	driver.findElement(By.xpath("//h5[.='Selectable']")).click();
	
	// To select all the selectables one by one
	List<WebElement> sel = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	
	Actions act= new Actions(driver);
	act.keyDown(Keys.CONTROL)
	.click(sel.get(0))
	.click(sel.get(3))
	.click(sel.get(5)).build().perform();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
