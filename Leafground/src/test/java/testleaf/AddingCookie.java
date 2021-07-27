package testleaf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddingCookie 
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
		driver.get("http://demo.automationtesting.in/Datepicker.html");
	}
	
@Test
public void adding_all_cookies()
{
	try {
	File f=new File("C:\\Users\\hp\\Documents\\cookies.data");
	FileReader f1=new FileReader(f);
	BufferedReader f2=new BufferedReader(f1);
	String strline;
	while((strline= f2.readLine())!=null)
	{
		StringTokenizer token=new StringTokenizer(strline,";");
		
		while(token.hasMoreTokens())
		{
			String name=token.nextToken();
			String domain=token.nextToken();
			String path=token.nextToken();
			String value=token.nextToken();
			//String secure=token.nextToken();
			//Date expiry=token.nextToken();
			Boolean secure=Boolean.parseBoolean(token.nextToken());
			Date expiry=null;
			
			String val;
			if(!(val=token.nextToken()).equals("null"))
			{
				expiry= new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(val);
				System.out.println(expiry);
			}  
			Cookie ck = new Cookie(name, value, domain, path, expiry, secure);
			driver.manage().addCookie(ck);
			
			Thread.sleep(10000);
		
		}
		
	}
	f2.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

@AfterMethod
public void tearDown()
{
	driver.close();
}
}
