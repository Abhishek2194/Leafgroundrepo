package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dropdown {
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
	public void checkboxTest() throws InterruptedException
	{
	
		driver.findElement(By.xpath("//h5[.='Drop down']")).click();
		
		//Check dropdown is single select or multiselect
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='dropdown1']"));
		Select drop_sel1= new Select(dropdown1);
		if(drop_sel1.isMultiple())
		{
			System.out.println("Dropdown is a multiselect drop down");
		}
		else
		{
			System.out.println("Single select drop down");
		}
		
		//Select drop down by index
		drop_sel1.selectByIndex(1);
		
		//Select drop down by visible Text
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='dropdown2']"));
		Select drop_sel2= new Select(dropdown2);
		drop_sel2.selectByVisibleText("Selenium");
		
		//Select drop down by value
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@id='dropdown3']"));
		Select drop_sel3= new Select(dropdown3);
		drop_sel3.selectByValue("1");
		
		//Total number of drop down options
		WebElement dropdown4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select drop_sel4= new Select(dropdown4);
		
		List<WebElement> options = drop_sel4.getOptions();
		int size =options.size();
		System.out.println("Number of options is :"+size);
		
		//Select through sendkeys
		WebElement dropdown5 = driver.findElement(By.xpath("//option[.='You can also use sendKeys to select']/.."));
		//Select drop_sel5= new Select(dropdown5);
		dropdown5.sendKeys("Selenium"+Keys.ENTER);
		
		//Select multiple options
		WebElement dropdown6 = driver.findElement(By.xpath("//select[@multiple]"));
		Select drop_sel6= new Select(dropdown6);
		
		drop_sel6.selectByValue("1");
		drop_sel6.selectByValue("3");
		
		
}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();	
	}

}
