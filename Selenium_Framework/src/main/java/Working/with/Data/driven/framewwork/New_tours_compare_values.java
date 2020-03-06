package Working.with.Data.driven.framewwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class New_tours_compare_values {

	ChromeDriver driver;
	String baseUrl="http://www.newtours.demoaut.com/";
	FileInputStream fis;
	String location="C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Excel Files Framework\\Data driven.xlsx";
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileOutputStream fos;
	WebDriverWait wait;
	@BeforeTest
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Test
	public void dataTestOperation() throws FileNotFoundException, IOException {
		fis=new FileInputStream(location);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet("Sheet3");
		//click on register link
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement country=driver.findElement(By.name("country"));
		List<WebElement> list=country.findElements(By.tagName("option"));
			for(int i=0;i<list.size();i++) {
				//get country names
				String actual=list.get(i).getText();
				
				//enter data into excel i+1 cuz row is starting from 1
				sheet.getRow(i+1).createCell(1).setCellValue(actual);
				String expected=sheet.getRow(i+1).getCell(0).getStringCellValue();
				
				if(expected.equalsIgnoreCase(actual)) {
					sheet.getRow(i+1).createCell(2).setCellValue("pass");
				}
				else {
					sheet.getRow(i+1).createCell(2).setCellValue("fail");
				}
			}
  }
	@AfterTest
	public void closeBrowser() throws FileNotFoundException, IOException {
		wait=new WebDriverWait(driver, 1);
		fos=new FileOutputStream(location);
		book.write(fos);
		book.close();
		driver.close();
	}
}