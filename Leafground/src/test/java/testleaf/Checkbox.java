package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Checkbox 
{
	WebDriver driver=null;
	@BeforeMethod
	public void setUp()
	{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com/");
	}
	
	
	@Test
	public void checkboxTest() throws InterruptedException
	{
	
		driver.findElement(By.xpath("//h5[.='Checkbox']")).click();
		
		//Select the language JAVA and SQL
		driver.findElement(By.xpath("(//div[@class='example'][1]//input)[1]")).click();
        driver.findElement(By.xpath("(//div[@class='example'][1]//input)[3]")).click();
		
		//driver.findElement(By.xpath("//div[.='Java']")).click();
        //driver.findElement(By.xpath("//div[.='SQL']")).click();
        
        
        //Confirm Selenium is selected
      String isc = driver.findElement(By.xpath("//div[.='Selenium']")).getAttribute("checked");
      System.out.println(isc);
      if(isc==null)
      {
      	System.out.println("Selenium is selected");
      }
      else
      {
      	System.out.println("Selenium is not selected");
      }
        
     /*   boolean sel_checked = driver.findElement(By.xpath("//div[.='Selenium']")).isSelected();
        if(sel_checked)
        {
        	System.out.println("Selenium is selected");
        }
        else
        {
        	System.out.println("Selenium is not selected");
        }
        */
        //Deselect only selected
        List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='example'][3]//input"));
        
        for(WebElement d:checkbox)
        {
        	String a=d.getAttribute("checked");
        	if(a==null)
        	{
        		d.click();
        		System.out.println("Deselected");
        	}
        	
        	
        	/*if(d.isSelected()) {
        		d.click();
        	}*/
        }
        
        
//select all check boxes        
List<WebElement> checkbox1 = driver.findElements(By.xpath("//div[@class='example'][4]//input"));
        
        for(WebElement d:checkbox1)
        {
        	
        		d.click();
        	
        }
        
        //Thread.sleep(5000);
        
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
