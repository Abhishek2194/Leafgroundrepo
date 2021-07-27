package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Edit 
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
	public void editTest() 
	{
	
	
	//Click on edit
	driver.findElement(By.xpath("//h5[.='Edit']")).click();
	
	
//Enter Email address	
    driver.findElement(By.id("email")).sendKeys("abhisheka.a@hcl.com");
    
    
    //clear text in textfield
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    
    //Append text and press keyboard tab
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Testing"+Keys.TAB);
    
    
    //Get default text entered 
    String a= driver.findElement(By.xpath("(//input[@type='text'])[3]")).getAttribute("value");
    System.out.println("Default text entered text is  :" +a);
    
    
    //Clear textfield
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
    
   
    //Check textfield is disabled or not
    Boolean enabled = driver.findElement(By.xpath("(//input[@type='text'])[5]")).isEnabled();
    
    Assert.assertFalse(enabled, "Textfield is disabled");
    
    

	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
