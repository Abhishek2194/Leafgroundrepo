package testleaf;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Window 
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
	public void windowTest()
	{
	
	driver.findElement(By.xpath("//h5[.='Window']")).click();
	//Open home page in new window
	String parent_id = driver.getWindowHandle();
	System.out.println(parent_id);
	driver.findElement(By.id("home")).click();
	Set<String> all_id = driver.getWindowHandles();
	Iterator<String> it=all_id.iterator();
	String p_id = it.next();
	System.out.println(p_id);
	String c_id =it.next();
	System.out.println(c_id);
	
	driver.switchTo().window(c_id);
	String title=driver.getTitle();
	//String page_source=driver.getPageSource();
	String current_url=driver.getCurrentUrl();
	System.out.println("Title is : "+title);
	//System.out.println("Page source is :\n"+page_source);
	System.out.println("Current url is :\n"+current_url);
	driver.close();
	
	//Switch back to parent window
	driver.switchTo().window(parent_id);
	
	
	String title3=driver.getTitle();
    System.out.println(title3);
    //Find the number of opened windows
	driver.findElement(By.xpath("//button[.='Open Multiple Windows']")).click();
	Set<String> all_id1 = driver.getWindowHandles();
	Iterator<String> it1=all_id1.iterator();
	String p_id1= it1.next();
	System.out.println(p_id1);
	String c_id1 =it1.next();
	System.out.println(c_id1);
	String c_id2 =it1.next();
	System.out.println(c_id2);
	driver.switchTo().window(c_id2);
  
	driver.findElement(By.id("home")).click();
	String title2=driver.getTitle();
    System.out.println(title2);
	Set<String> all_id2 = driver.getWindowHandles();
	int num_win=all_id2.size();
	System.out.println("Number of windows opened :"+num_win);
	
	//Closing all the windows except parent window
	for(String id:all_id2)
	{
		System.out.println(id);
		if(!id.equals(parent_id))
		{
			driver.switchTo().window(id);
			driver.close();
		}
	}
	
	//Switch to parent window
	driver.switchTo().window(p_id1);
	
	//Closing all the windows except parent window
	driver.findElement(By.xpath("//button[.='Do not close me ']")).click();
	/*Set<String> all_id3 = driver.getWindowHandles();
	Iterator<String> it3=all_id3.iterator();
	String p_id3= it3.next();
	System.out.println(p_id3);
	String c_id3 =it3.next();
	System.out.println(c_id3);
	String c_id4 =it3.next();
	System.out.println(c_id4);
	//driver.switchTo().window(c_id4);*/
  
	//driver.findElement(By.id("home")).click();
	//String title4=driver.getTitle();
    //System.out.println(title4);
	Set<String> all_id4 = driver.getWindowHandles();
	int num_win1=all_id4.size();
	System.out.println("Number of windows opened :"+num_win1);
	for(String id:all_id4)
	{
		System.out.println(id);
		if(!id.equals(parent_id))
		{
			driver.switchTo().window(id);
			driver.close();
		}
	}
	
	
	//Switch to parent window
	driver.switchTo().window(p_id1);
	
	//Wait for 2 new windows to be open
	driver.findElement(By.id("color")).click();
	WebDriverWait w = new WebDriverWait(driver, 5);
	w.until(ExpectedConditions.numberOfWindowsToBe(3));
	
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
