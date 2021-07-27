package testleaf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadriven 
{
	WebDriver driver;
	XSSFWorkbook w;
    XSSFSheet sheet;
    XSSFCell cell;
    
	@Test
	public void dataDriverTest() throws IOException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//WebDriver driver;
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://affiliate.flipkart.com/login");
	File src=new File("C:\\Users\\hp\\Documents\\Corel\\demo.xlsx");
	FileInputStream fis = new FileInputStream(src);
	w = new XSSFWorkbook(fis);
	sheet= w.getSheetAt(0);
	for(int i=0; i<=sheet.getLastRowNum(); i++){
		cell = sheet.getRow(i).getCell(0);
		 cell.setCellType(CellType.STRING);
		 driver.findElement(By.id("inputEmail")).clear();
		 driver.findElement(By.id("inputEmail")).sendKeys(cell.getStringCellValue());
		 
		 cell = sheet.getRow(i).getCell(1);
		 cell.setCellType(CellType.STRING);
		 driver.findElement(By.id("inputPassword")).clear();
		 driver.findElement(By.id("inputPassword")).sendKeys(cell.getStringCellValue());
		 
		 driver.findElement(By.id("submitLogin")).click();
		 driver.close();
	}
	
	}
	
}
