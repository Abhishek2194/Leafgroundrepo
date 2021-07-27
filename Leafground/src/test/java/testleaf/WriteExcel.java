package testleaf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WriteExcel 
{
	WebDriver driver;
	XSSFWorkbook w;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    
	
	@Test
	public void dataDriverTest() throws IOException
	{
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//WebDriver driver;
	//driver = new ChromeDriver();
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	File src=new File("C:\\Users\\hp\\Documents\\Corel\\demo4.xlsx");
	FileOutputStream fis = new FileOutputStream(src);
	w = new XSSFWorkbook();
	sheet= w.createSheet("selenium");
	ArrayList<String> s1=new ArrayList<String>();
	s1.add("test1");
	s1.add("test2");
	s1.add("test3");
	System.out.println(s1.size());
	for(int i=0; i<s1.size(); i++){
		//cell=sheet.createRow(i).createCell(0);
		row = sheet.createRow(i);
		cell=row.createCell(0);
		//c1.setCellType(CellType.STRING);
		cell.setCellType(CellType.STRING);
		//cell.setCellValue(s1.get(i));
		String val=s1.get(i);
		cell.setCellValue(val);
		System.out.println(val);
		
		// driver.close();
	}
	w.write(fis);
	fis.flush();
	fis.close();
	w.close();
	}
}
