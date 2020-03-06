package Working.with.Keyword.driven.framework.resuable.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mercury_Main_scripts_Actions {
	ChromeDriver driver;
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	//create separate method for each action you want to perform
	
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	public void navigate() {
		driver.get("https://www.mercurytravels.co.in/");
	}
	
	
	public void closePopup() {
		driver.findElement(By.linkText("No, thanks")).click();
	}
	
	public void holidaysSearch(String destination,String duration,String type) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='holiday_category_id']")).sendKeys(destination);
//		jse.executeScript("document.getElementById('dphh1').value='17/1/2019'");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='duration_d']")).sendKeys(duration);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='themes']")).sendKeys(type);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-search2']")).click();
		Thread.sleep(3000);
	}
	
	public void flightSearch(String fromcity, String tocity,String adults,
			String childs,String infants,String classt) throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@id='flights']")).click();
		driver.findElement(By.xpath("//input[@name='fromCity']")).sendKeys(fromcity);
		driver.findElement(By.xpath("//input[@name='toCity']")).sendKeys(tocity);
		jse.executeScript("document.getElementById('dphh1').value='1/12/2019'");
		driver.findElement(By.xpath("//select[@id='Adults']")).sendKeys(adults);
		driver.findElement(By.xpath("//select[@id='Childs']")).sendKeys(childs);
		driver.findElement(By.xpath("//select[@id='Infants']")).sendKeys(infants);
		driver.findElement(By.xpath("//select[@name='cabinClass']")).sendKeys(classt);
		driver.findElement(By.xpath("//button[@id='searchFlightsBtn']")).click();
		Thread.sleep(3000);
		
		
	}
	
	public void hotelSearch() {
	
	}

	
	public void closeBrowser() {
		driver.close();
	}
}