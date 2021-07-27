package testleaf;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Ordered_list {
WebDriver driver=null;
	
	@BeforeMethod
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Selectable.html");
	}
	
	@Test
	public void orderedlistTest() throws IOException 
	{
	
	driver.findElement(By.xpath("//a[.='Serialize ']")).click();
	
	//Get all the elements
	List<WebElement> all_opt = driver.findElements(By.xpath("//div[@id='Serialize']//li"));
	
	//Get the size
	int size=all_opt.size();
	System.out.println(size);
	
	Actions act= new Actions(driver);
	act.keyDown(Keys.CONTROL)
	.click(all_opt.get(0))
	.click(all_opt.get(3))
	.click(all_opt.get(5)).build().perform();

    TakesScreenshot src=(TakesScreenshot)driver;
    File source=src.getScreenshotAs(OutputType.FILE);
    File destination=new File("C:\\Users\\hp\\Desktop\\Screenshots\\screen.jpg");
    FileHandler.copy(source, destination);

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
