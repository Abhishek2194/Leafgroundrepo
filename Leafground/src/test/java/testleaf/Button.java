package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Button 
{
	
WebDriver driver = null;

@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("http://www.leafground.com/");	
}


@Test
public void buttonTest()
{

	driver.findElement(By.xpath("//h5[.='Button']")).click();
	//Click on go to homepage button
	driver.findElement(By.xpath("//button[.='Go to Home Page']")).click();
	driver.navigate().back();
	//Position of the button(x,y)
	 Point d = driver.findElement(By.id("position")).getLocation();
	System.out.println(d);
	//Color of the button
	String col = driver.findElement(By.id("color")).getCssValue("background-color");
	System.out.println("Button color is  :" +col);
	 String hexcolorvalue = Color.fromString(col).asHex();
	System.out.println("Button color in hexvalue  :" +hexcolorvalue);
	//Height and width of the button
	Dimension size = driver.findElement(By.id("size")).getSize();
	
	System.out.println("Button size is : "+ size);
	
	
}

@AfterMethod
public void tearDown()
{
	driver.close();
}
}
