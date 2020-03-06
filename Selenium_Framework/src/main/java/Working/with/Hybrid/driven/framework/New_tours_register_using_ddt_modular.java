package Working.with.Hybrid.driven.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Working.with.Hybrid.driven.framework.reusable.methods.New_tours_resuable_methods;
public class New_tours_register_using_ddt_modular {
	FileInputStream fis;
	String location="C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Excel Files Framework\\Data driven.xlsx";
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileOutputStream fos;
	WebDriverWait wait;
	New_tours_resuable_methods meth;
	
	@Test
	public void operationTours() throws IOException {
		meth=new New_tours_resuable_methods();
		meth.launchBrowser();
//		meth.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\landing_page.jpg");
		
		fis=new FileInputStream(location);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet("Sheet5");
		// -1 cuz 1st row is for headings
		int rcount=sheet.getLastRowNum()-1;
		
		System.out.println(rcount);
		
		for(int i=0;i<=rcount;i++) {
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
		meth.registerPage(firstName, lastName, phone1 , email, Address, city, state, postal, country, 
							userName, password, confirmPas);

		//get status from main script
		//you can send values from here to verify method to write about actual value
		//just pass name, sheet, i values
		String status=meth.verifyStatus(sheet.getRow(i+1).getCell(9).getStringCellValue());
		sheet.getRow(i+1).getCell(13).setCellValue(status);//set value to excel file
		
		}
		
		
//		meth.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\reg_page.jpg");
//		
//		meth.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\status_page.jpg");
		meth.closeBrowser();
	}
	//optional , else you can use after loop as well
	@AfterTest
	public void saveFile() throws IOException {
		fos=new FileOutputStream(location);
		book.write(fos);
		book.close();
	}
}