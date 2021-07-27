package testleaf;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Hyperlink 
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
	public void hyperlinkTest() throws MalformedURLException, IOException 
	{
	
	driver.findElement(By.xpath("//h5[.='HyperLink']")).click();
	//Click on go to home page link
	driver.findElement(By.xpath("(//a[.='Go to Home Page'])[1]")).click();
	
	//Navigate back
	driver.navigate().back();
	
	//Finding the url without clicking the link
	String s1=driver.findElement(By.xpath("//a[.='Find where am supposed to go without clicking me?']")).getAttribute("href");
    System.out.println("url is : "+s1);
    
    //Verifying link is broken or not
    String url=driver.findElement((By.xpath("//a[.='Verify am I broken?']"))).getAttribute("href");
    
    if(url==null || url.isEmpty()) 
    {
    	System.out.println("Either url is not configured or url is empty");
    }
    else
    {
    	driver.findElement(By.xpath("//a[.='Verify am I broken?']")).click();
    }
    HttpURLConnection connection = null;
    
    connection =(HttpURLConnection)(new URL(url).openConnection());
    connection.setRequestMethod("HEAD");
    
    connection.connect();
    int responsecode = connection.getResponseCode();
    
    if(responsecode>=400)
    {
    	System.out.println(responsecode+" link is broken");
    }
    else
    {
    	System.out.println("link is valid");
    }

    //Navigate back
    driver.navigate().back();
    
    //Click on go to home page link
    driver.findElement(By.xpath("(//a[.='Go to Home Page'])[2]")).click();
    
    //Navigate back
    driver.navigate().back();
    
    //Total number of links
    int size = driver.findElements(By.xpath("//a")).size();
    System.out.println("Total number of link count is : "+size);
    
	
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
