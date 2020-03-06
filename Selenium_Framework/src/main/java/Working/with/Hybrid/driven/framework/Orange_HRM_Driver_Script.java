package Working.with.Hybrid.driven.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Working.with.Hybrid.driven.framework.reusable.methods.Orange_HRM_Main_scripts_Actions;

public class Orange_HRM_Driver_Script {
	
	@Test
	public void operationSet() throws IOException, InterruptedException {
	Orange_HRM_Main_scripts_Actions org=new Orange_HRM_Main_scripts_Actions();
	String file_loc="C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Excel Files Framework\\Keyword driven.xlsx";
	String file_loc2="C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Excel Files Framework\\Data driven.xlsx";
	FileInputStream fis=new FileInputStream(file_loc);
	FileInputStream fis2=new FileInputStream(file_loc2);
	FileOutputStream fos;
	XSSFWorkbook book=new XSSFWorkbook(fis);
	XSSFWorkbook book2=new XSSFWorkbook(fis2);
	XSSFSheet sheet1=book.getSheet("Sheet6");
	XSSFSheet sheet2=book2.getSheet("Sheet6");
	//-1 cuz heading is there in excel
	int rcount1=sheet1.getLastRowNum()-1;
	int rcount2=sheet2.getLastRowNum()-1;
	
	for(int i=0;i<=rcount1;i++) {
		String keyword=sheet1.getRow(i+1).getCell(3).getStringCellValue();
		String mode=sheet1.getRow(i+1).getCell(4).getStringCellValue();
		System.out.println(keyword);
		System.out.println(mode);
		//check for mode with respect to excel
		if(mode.equals("Y")) {
			//check for keyword with respect to excel
			
			if(keyword.equals("launchBrowser")) {
				org.launchBrowser();//call method from main script
				//get each row , for that create cell and set value
				sheet1.getRow(i+1).createCell(5).setCellValue("pass");
				
			}
			
			else if(keyword.equals("navigate")) {
				org.navigate();
				Thread.sleep(3000);
				sheet1.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("enterUsername")) {
				for(int j=0;j<=rcount2;j++){
					org.enterUsername(sheet2.getRow(j+1).getCell(0).getStringCellValue());
					break;
				}
				Thread.sleep(3000);
				sheet1.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("enterPassword")) {
				for(int k=0;k<=rcount2;k++){
					org.enterPassword(sheet2.getRow(k+1).getCell(1).getStringCellValue());
					break;
				}
				Thread.sleep(3000);
				sheet1.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("login")) {
				org.login();
				sheet1.getRow(i+1).createCell(5).setCellValue("pass");
			}
			
			else if(keyword.equals("closeBrowser")) {
				org.closeBrowser();
				sheet1.getRow(i+1).createCell(5).setCellValue("pass");
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