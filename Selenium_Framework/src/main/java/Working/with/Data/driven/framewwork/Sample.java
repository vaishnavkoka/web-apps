package Working.with.Data.driven.framewwork;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
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

public class Sample {


public static void main(String args[]) throws IOException {
	FileInputStream fis;
	String location="C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Excel Files Framework\\Data driven.xlsx";
	Workbook book;
	XSSFSheet sheet;
	XSSFRow row;
	FileOutputStream fos;
	WebDriverWait wait;
	fis=new FileInputStream(location);
	book=new XSSFWorkbook(fis);
	sheet=(XSSFSheet) book.getSheet("Sheet1");
	
	for(int i=0;i<sheet.getLastRowNum();i++) {
//		Row rowi = sheet.createRow(i);  
        CellStyle style = book.createCellStyle();  

		String expected=sheet.createRow(i).getCell(7).getStringCellValue();
		String actual=sheet.createRow(i).getCell(8).getStringCellValue();
		System.out.println(expected);
		System.out.println(actual);
		
		if(expected.equals(actual))
		{
			// Setting Background color  
	        style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());  
	        style.setFillPattern(FillPatternType.BIG_SPOTS);
	        Cell cell = sheet.createRow(i).createCell(9);  
	        cell.setCellValue("pass");  
	        cell.setCellStyle(style);
		}
		else {
			sheet.createRow(i).createCell(9).setCellValue("fail");
		}
	}
	
	  
			fos=new FileOutputStream(location);
			book.write(fos);
			book.close();


	}
}