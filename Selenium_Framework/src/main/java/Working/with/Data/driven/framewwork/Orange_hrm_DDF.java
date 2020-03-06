package Working.with.Data.driven.framewwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orange_hrm_DDF {

	ChromeDriver driver;
	String baseUrl="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void dataTestOperation() throws FileNotFoundException, IOException {
		fis=new FileInputStream(location);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet("Sheet2");
		int rcount=sheet.getLastRowNum();//get no.of rows
		
		for(int i=1;i<=rcount;i++) {
		
		//get username from excel sheet 1st row and traverse till end
		String username=sheet.getRow(i).getCell(0).getStringCellValue();
		
		//get password from excel sheet 2nd row and traverse till end
		String password=sheet.getRow(i).getCell(1).getStringCellValue();
		
		//clear input fields
		driver.findElement(By.name("txtUsername")).clear();
		driver.findElement(By.name("txtPassword")).clear();
		
		//enter data //send excel data in send keys
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		
		//click button
		driver.findElement(By.name("Submit")).click();
		String expected=sheet.getRow(i).getCell(2).getStringCellValue();
		String actual=driver.getCurrentUrl();
		wait=new WebDriverWait(driver, 1);
		
		//logout
//		driver.findElement(By.id("welcome")).click();
//		wait=new WebDriverWait(driver, 1);
//		driver.findElement(By.linkText("Logout")).click();
//		wait=new WebDriverWait(driver, 1);
		
		//print actual link in excel
		sheet.getRow(i).createCell(3).setCellValue(actual);
		System.out.println("actual--->"+  actual);
		System.out.println("expected--->"+  expected);
		//condition check and write result to excel
		if(expected.equalsIgnoreCase(actual)) {
			sheet.getRow(i).createCell(4).setCellValue("pass");
			CellStyle style = book.createCellStyle();  
            // Setting Background color  
			style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
			sheet.getRow(i).createCell(4).setCellStyle(style);
		 }
		else {
			sheet.getRow(i).createCell(4).setCellValue("fail");
			CellStyle style = book.createCellStyle();  
            // Setting Background color  
			style.setFillBackgroundColor(IndexedColors.RED.getIndex());
			sheet.getRow(i).createCell(4).setCellStyle(style);
		}
		driver.close();
		wait=new WebDriverWait(driver, 1);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}	
  }
	@AfterTest
	public void closeBrowser() throws FileNotFoundException, IOException {
		wait=new WebDriverWait(driver, 1);
		fos=new FileOutputStream(location);
		book.write(fos);
		driver.close();
	}
}
