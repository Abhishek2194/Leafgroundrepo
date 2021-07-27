package testleaf;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Popup 
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
		
	}
	
	@Test
	public void popup_aut_test_in_Test() throws InterruptedException, AWTException, IOException
	{
	
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("//a[.='Alert with Textbox ']")).click();
		
		driver.findElement(By.xpath("//button[.='click the button to demonstrate the prompt box ']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Robot r=new Robot();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(screensize);
		BufferedImage img = r.createScreenCapture(rect);
		File dest=new File("C:\\Users\\hp\\Desktop\\Screenshots\\screen3.jpg");
		ImageIO.write(img, "jpg", dest);
		
		
		Alert a1 = driver.switchTo().alert();
		a1.sendKeys("Abhi");
		
		
		
		a1.accept();	
		
	}
	
	
	@Test
	public void popup_Test() throws InterruptedException
	{
	
		driver.get("http://www.leafground.com/");
		
		driver.findElement(By.xpath("//h5[.='Alert']")).click();
		
		//Alert box
		driver.findElement(By.xpath("//button[.='Alert Box']")).click();
		Alert a1 = driver.switchTo().alert();
		String s1=a1.getText();
		System.out.println(s1);
		
		a1.accept();
		
		/*driver.findElement(By.xpath("//button[.='Alert Box']")).click();
		Alert a2 = driver.switchTo().alert();
		a2.dismiss();*/
		
		//Confirmation box
		driver.findElement(By.xpath("//button[.='Confirm Box']")).click();
		Alert a3 = driver.switchTo().alert();
		String s2 = a3.getText();
		System.out.println(s2);
		a3.accept();
		
		driver.findElement(By.xpath("//button[.='Confirm Box']")).click();
		Alert a4 = driver.switchTo().alert();
		a4.dismiss();
		
		//Prompt box
		driver.findElement(By.xpath("//button[.='Prompt Box']")).click();
		Alert a5 = driver.switchTo().alert();
		a5.sendKeys("Hello all");
		
		a5.accept();
		
		// Check line breaks 
		driver.findElement(By.xpath("//button[.='Line Breaks?']")).click();
		Alert a6 = driver.switchTo().alert();
		String text=a6.getText();
		
		System.out.println(text);
		if(text.contains("\n"))
		{
			System.out.println("Line break is present");
		}
		else
		{
			System.out.println("line break is not present");
		}
		a6.accept();
		
		
		//Inspectable pop up
		driver.findElement(By.xpath("//button[.='Sweet Alert']")).click(); 
		/*Alert al1 = driver.switchTo().alert();
		String text5 = al1.getText();
		System.out.println(text5);
		al1.accept();*/
		String text2 = driver.findElement(By.xpath("//div[.='Happy Coding!']")).getText();
		System.out.println("text is "+text2);
		driver.findElement(By.xpath("//button[.='OK']")).click();
		
		
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
}
