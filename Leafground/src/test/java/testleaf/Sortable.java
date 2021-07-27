package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Sortable 
{
	WebDriver driver = null;
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
	public void sortableTest()
	{
	
	driver.findElement(By.xpath("//h5[.='Sortable']")).click();
	
	WebElement pos1 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[1]"));
	
	WebElement pos2 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[2]"));
	WebElement pos3 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[3]"));
	WebElement pos4 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[4]"));
	WebElement pos5 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[5]"));
	WebElement pos6 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[6]"));
	WebElement pos7 = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-sortable-handle'])[7]"));
	
	Actions act= new Actions(driver);
	act.dragAndDrop(pos1, pos7).build().perform();
	//act.dragAndDrop(pos2, pos7).build().perform();
	//act.dragAndDrop(pos3, pos7).build().perform();
	//act.dragAndDrop(pos4, pos7).build().perform();
	//act.dragAndDrop(pos5, pos7).build().perform();
	//act.dragAndDrop(pos6, pos7).build().perform();
	//act.dragAndDrop(pos7, pos7).build().perform();
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}


}
