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

public class Calender 
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
		driver.get("http://demo.automationtesting.in/Datepicker.html");
	}
	

	@Test
	public void calenderTest()
	{
		//WebElement ele = driver.findElement(By.id("datepicker1"));
	JavascriptExecutor er=(JavascriptExecutor) driver;
	er.executeScript("document.getElementById('datepicker1').value='21/11/1994'");
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
