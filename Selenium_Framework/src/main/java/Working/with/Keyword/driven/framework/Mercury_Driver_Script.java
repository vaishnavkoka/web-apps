package Working.with.Keyword.driven.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

//import main script class
import Working.with.Keyword.driven.framework.resuable.methods.Mercury_Main_scripts_Actions;

public class Mercury_Driver_Script {
	
	@Test
	public void operationSet() throws IOException, InterruptedException {
	Mercury_Main_scripts_Actions mer=new Mercury_Main_scripts_Actions();
	String file_loc="C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Excel Files Framework\\Keyword driven.xlsx";
	FileInputStream fis=new FileInputStream(file_loc);
	FileOutputStream fos;
	XSSFWorkbook book=new XSSFWorkbook(fis);
	XSSFSheet sheet=book.getSheet("Sheet5");
	//-1 cuz heading is there in excel
	int rcount=sheet.getLastRowNum()-1;
	
	for(int i=0;i<=rcount;i++) {
		String keyword=sheet.getRow(i+1).getCell(3).getStringCellValue();
		String mode=sheet.getRow(i+1).getCell(4).getStringCellValue();
		System.out.println(keyword);
		System.out.println(mode);
		//check for mode with respect to excel
		if(mode.equals("Y")) {
			//check for keyword with respect to excel
			//only the excel keywords are this should match
			if(keyword.equals("launchBrowser")) {
				mer.launchBrowser();//call method from main script
				//get each row , for that create cell and set value
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("navigate")) {
				mer.navigate();
				Thread.sleep(3000);
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("popup")) {
				mer.closePopup();
				Thread.sleep(3000);
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("searchholidays")) {
				mer.holidaysSearch("India(India)", "3Nights / 4Days", "Beach");
				Thread.sleep(3000);
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("flights")) {
				mer.flightSearch("Hyderabad", "Goa", "3", "2", "1", "Business Class");
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("hotels")) {
				mer.hotelSearch();
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("close")) {
				mer.closeBrowser();
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
		}//end of main if
		else {
			System.out.println("run mode failed");
		}
	}//end of for loop
	fos=new FileOutputStream(file_loc);
	book.write(fos);
  }//end of test
}//end of class