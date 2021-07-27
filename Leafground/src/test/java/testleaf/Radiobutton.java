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

public class Radiobutton 
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
	public void radioButtonTest() 
	{
	
	driver.findElement(By.xpath("//h5[.='Radio Button']")).click();
	
	//Select yes
	driver.findElement(By.xpath("//input[@id='yes']")).click();
	/*List<WebElement> d = driver.findElements(By.xpath("(//div[@class='large-6 small-12 columns'])[2]//input[@type='radio']"));
	for(WebElement e:d)
	{
		if(e.isSelected())
		{
			String radiobutton=e.getText();
			System.out.println("Default radio button is :"+radiobutton);
		}
		
	}*/
	
	//Default selected radio button
	boolean unchecked = driver.findElement(By.xpath("((//div[@class='large-6 small-12 columns'])[2]//input[@type='radio'])[1]")).isSelected();
	boolean checked = driver.findElement(By.xpath("((//div[@class='large-6 small-12 columns'])[2]//input[@type='radio'])[2]")).isSelected();
	
	if(unchecked)
	{
		System.out.println("Default selected radio button is: Unchecked");
	}
	else if(checked)
	{
		System.out.println("Default selected radio button is: checked");
	}
	
	
	//Select if only not selected
	boolean age = driver.findElement(By.xpath("((//div[@class='large-6 small-12 columns'])[3]//input[@type='radio'])[2]")).isSelected();
	
	if(!age)
	{
		
		driver.findElement(By.xpath("((//div[@class='large-6 small-12 columns'])[3]//input[@type='radio'])[2]")).click();
	}
	
	
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
