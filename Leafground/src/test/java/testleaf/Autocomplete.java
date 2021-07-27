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

public class Autocomplete {
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
	public void autocompleteTest()
	{
	driver.findElement(By.xpath("//h5[.='Auto Complete']")).click();
	
	driver.findElement(By.id("tags")).sendKeys("a");
	
	// all the options
	List<WebElement> sel = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
	
	for(WebElement ele:sel)
	{
		if(ele.getText().equalsIgnoreCase("Protractor"))
		{
			ele.click();
		}
	}
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
