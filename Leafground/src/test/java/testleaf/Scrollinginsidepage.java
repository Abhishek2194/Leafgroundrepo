package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scrollinginsidepage 
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
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/grid_and_snap_while_scrolling_example.html");
	}
	

	@Test
	public void scrollinginsideTest()
	{
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr[.='Row 30']"));
	JavascriptExecutor er=(JavascriptExecutor) driver;
	er.executeScript("arguments[0].scrollIntoView(true);",ele);
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
