package testleaf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CacheFeature 
{
	WebDriver driver=null;
	
	@BeforeMethod
	public void setup()
	{
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Datepicker.html");
	}
	

	@Test
	public void getCacheTest()
	{
		File f1=new File("C:\\Users\\hp\\Documents\\cookies4.data");
		try {
			f1.createNewFile();
			FileWriter f2=new FileWriter(f1);
			BufferedWriter f3= new BufferedWriter(f2);
			for(Cookie ck:driver.manage().getCookies())
			{
				f3.write(ck.getName()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getValue()+";"+ck.isSecure()+";"+ck.getExpiry());
				f3.newLine();
			}
			f3.close();
			f2.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
}
