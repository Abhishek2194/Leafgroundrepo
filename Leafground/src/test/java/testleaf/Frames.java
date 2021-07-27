package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames 
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
	public void frameTest()
	{
	
	driver.findElement(By.xpath("//h5[.='Frame']")).click();
	
	//Switch to frame and click on button
	WebElement d1 = driver.findElement(By.xpath("//iframe[@src='default.html']"));
	driver.switchTo().frame(d1);
	driver.findElement(By.id("Click")).click();
	
	//Switch back to default page
	driver.switchTo().defaultContent();
	
	//Switch to nested frame
	driver.switchTo().frame(1);
	driver.switchTo().frame("frame2");
	driver.findElement(By.id("Click1")).click();
	
	//Switch back to default page
	driver.switchTo().defaultContent();
	
	//Total number of frames
	int size=driver.findElements(By.xpath("//iframe")).size();
	
	System.out.println("Number of iframes are :"+size);
	
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
