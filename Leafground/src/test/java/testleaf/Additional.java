package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Additional 
{
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void additionalTest()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver;
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.get("http://www.leafground.com/");
	driver.navigate().to("http://www.leafground.com/");
	String url=driver.getCurrentUrl();
	System.out.println(url);
	String pagesource=driver.getPageSource();
	System.out.println(pagesource);
	String title=driver.getTitle();
	System.out.println(title);
	driver.findElement(By.xpath("//h5[.='Wait to Disappear']")).click();
	driver.navigate().refresh();
	driver.navigate().forward();
	driver.navigate().back();
	Dimension dim=new Dimension(250,250);
	driver.manage().window().setSize(dim);
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();	
	}
}
