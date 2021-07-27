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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Unorderedlist 
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
		driver.get("http://demo.automationtesting.in/AutoComplete.html");
	}
	
	@Test
	public void unorderedlistTest() throws IOException 
	{
	
	driver.findElement(By.id("searchbox")).sendKeys("Ind");
	
	WebElement ele = driver.findElement(By.id("ui-id-1"));
	
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(ele));
	
	//Get all the elements
	List<WebElement> all_opt = driver.findElements(By.xpath("//div[@id='menucontainer']//li"));
	
	//Get the size
	int size=all_opt.size();
	System.out.println(size);
	
	
	for(WebElement ele1:all_opt)
	{
		if(ele1.getText().equalsIgnoreCase("India"))
		{
			ele1.click();
		}
	}
	
	
    TakesScreenshot src=(TakesScreenshot)driver;
    File source=src.getScreenshotAs(OutputType.FILE);
    File destination=new File("C:\\Users\\hp\\Desktop\\Screenshots\\screen1.jpg");
    FileHandler.copy(source, destination);

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
