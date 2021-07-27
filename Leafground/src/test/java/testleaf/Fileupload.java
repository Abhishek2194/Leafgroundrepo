


	
	package testleaf;
	 
	import java.awt.AWTException;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
	import java.awt.Robot;
	 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
	 
	
	 
	 
	public class Fileupload {
		WebDriver driver=null;
		
		@BeforeMethod
		public void setup()
		{
	       System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			//WebDriver driver;
			driver = new ChromeDriver();
			driver.get("http://demo.guru99.com/selenium/upload/");
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
		}
		
	 @Test
	    public void upload() throws InterruptedException, AWTException {
	   
	 
	 
	 
		//open upload window
	     driver.findElement(By.xpath("//input[@id='uploadfile_0']")).click();

	     

	     //imitate mouse events like ENTER, CTRL+C, CTRL+V
	     Robot robot = new Robot();
	     robot.setAutoDelay(3000);
	     
	   //put path to your image in a clipboard
	     StringSelection ss = new StringSelection("C:\\Users\\hp\\Downloads\\RESUME.rtf");
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	     robot.setAutoDelay(3000);
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_C);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_C);
	     robot.setAutoDelay(3000);
	     
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyRelease(KeyEvent.VK_V);
	     
	     robot.setAutoDelay(3000);

	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.keyRelease(KeyEvent.VK_ENTER);
	     
	     
	     
	   }
	 
	}


