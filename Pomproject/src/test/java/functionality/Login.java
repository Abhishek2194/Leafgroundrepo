package functionality;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import elements.Attributes;

public class Login {
	@Test
	public void loginTest()
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://affiliate.flipkart.com/login");
		PageFactory.initElements(driver, Attributes.class);
		Attributes.emailid.sendKeys("abhishetty017@gamil.com");
		Attributes.password.sendKeys("panjurli@1234");
		Attributes.submit.click();
		driver.close();
		
	}

}
