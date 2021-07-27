package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Wait_to_appear 
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
	public void appearTest()
	{
	// Wait to appear
	driver.findElement(By.xpath("//h5[.='Wait to Appear']")).click();
	WebElement ele = driver.findElement(By.id("btn"));
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(ele));
	String s=ele.getText();
	System.out.println(s);
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
