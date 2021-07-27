package testleaf;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Filedownload 
{
	WebDriver driver = null;

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://chromedriver.storage.googleapis.com/index.html?path=79.0.3945.36/");	
	}


	@Test
	public void buttonTest()
	{

		driver.findElement(By.linkText("chromedriver_win32.zip")).click();
		File f1=new File("C:\\Users\\hp\\Downloads");
		File[] files=f1.listFiles();
		for(File file_type:files)
		{
			if(file_type.getName().equalsIgnoreCase("chromedriver_win32.zip"))
			{
				System.out.println("File exists in downloads");
				break;
			}
		}
		
		
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
