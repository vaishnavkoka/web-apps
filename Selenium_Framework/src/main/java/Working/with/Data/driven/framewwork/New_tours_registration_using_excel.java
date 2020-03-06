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

public class New_tours_registration_using_excel {

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
	sheet=book.getSheet("Sheet4");
	// -1 cuz 1st row is for headings
	int rcount=sheet.getLastRowNum()-1;
	System.out.println(rcount);
	for(int i=0;i<rcount;i++) {
		String firstName= sheet.getRow(i+1).getCell(0).getStringCellValue();
		String lastName=  sheet.getRow(i+1).getCell(1).getStringCellValue();;
		double phone=	  sheet.getRow(i+1).getCell(2).getNumericCellValue();
		String phone1=Double.toString(phone);
		String email=	  sheet.getRow(i+1).getCell(3).getStringCellValue();
		String Address=	  sheet.getRow(i+1).getCell(4).getStringCellValue();
		String city=	  sheet.getRow(i+1).getCell(5).getStringCellValue();
		String state=	  sheet.getRow(i+1).getCell(6).getStringCellValue();
		double postalCode=sheet.getRow(i+1).getCell(7).getNumericCellValue();
		String postal=Double.toString(postalCode);
		String country=   sheet.getRow(i+1).getCell(8).getStringCellValue();
		String userName=  sheet.getRow(i+1).getCell(9).getStringCellValue();
		String password=  sheet.getRow(i+1).getCell(10).getStringCellValue();
		String confirmPas=sheet.getRow(i+1).getCell(11).getStringCellValue();
		//click on register link
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone1);
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(Address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(postal);
		driver.findElement(By.xpath("//select[@name='country']")).sendKeys(country);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(confirmPas);
		driver.findElement(By.xpath("//input[@name='register']")).click();
		wait=new WebDriverWait(driver, 2);
		
		String actual=driver.findElement(By.xpath("//p[3]//a[1]")).getText();
		//print actual data to excel
		sheet.getRow(i+1).getCell(12).setCellValue(actual);
		String expected=sheet.getRow(i+1).getCell(9).getStringCellValue();
		//conditional checking
		System.out.println("expected ----"+expected);
		System.out.println("actual ----"+actual);
		
		if(actual.contains(expected)) {//cuz actual contains expected
			sheet.getRow(i+1).getCell(13).setCellValue("pass");
		}
		else {
			sheet.getRow(i+1).getCell(13).setCellValue("fail");
		}
		wait=new WebDriverWait(driver, 1);
		driver.findElement(By.linkText("REGISTER")).click();
	}//end of for loop
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