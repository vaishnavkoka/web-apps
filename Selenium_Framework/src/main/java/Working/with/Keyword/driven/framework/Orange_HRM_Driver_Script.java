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
import Working.with.Keyword.driven.framework.resuable.methods.Orange_HRM_Main_scripts_Actions;

public class Orange_HRM_Driver_Script {
	
	@Test
	public void operationSet() throws IOException, InterruptedException {
	Orange_HRM_Main_scripts_Actions org=new Orange_HRM_Main_scripts_Actions();
	String file_loc="C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Excel Files Framework\\Keyword driven.xlsx";
	FileInputStream fis=new FileInputStream(file_loc);
	FileOutputStream fos;
	XSSFWorkbook book=new XSSFWorkbook(fis);
	XSSFSheet sheet=book.getSheet("Sheet4");
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
			
			if(keyword.equals("launchBrowser")) {
				org.launchBrowser();//call method from main script
				//get each row , for that create cell and set value
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
				
			}
			
			else if(keyword.equals("navigate")) {
				org.navigate();
				Thread.sleep(3000);
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("enterUsername")) {
				org.enterUsername();
				Thread.sleep(3000);
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("enterPassword")) {
				org.enterPassword();
				Thread.sleep(3000);
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("login")) {
				org.login();
				sheet.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("closeBrowser")) {
				org.closeBrowser();
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