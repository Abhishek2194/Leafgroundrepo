package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Draggable
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
	public void draggableTest()
	{
		WebElement ele = driver.findElement(By.xpath("//h5[.='Draggable']"));
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(ele));
	
	ele.click();
	
	WebElement src = driver.findElement(By.id("draggable"));
	
     Point pos = src.getLocation();
     
     System.out.println(pos);
	
	Actions act= new Actions(driver);
	act.dragAndDropBy(src, 275, 125).build().perform();
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

	

}
