package Self.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Testing {
	ChromeDriver driver;
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	//create separate method for each action you want to perform
	@BeforeTest
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.mercurytravels.co.in/");
	}
	@Test
	public void holidaysSearch() throws InterruptedException {
		driver.findElement(By.linkText("No, thanks")).click();	
		driver.findElement(By.xpath("//input[@id='holiday_category_id']")).sendKeys("India");
//		jse.executeScript("document.getElementById('dphh1').value='17/1/2019'");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='duration_d']")).sendKeys("3Nights / 4Days");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='themes']")).sendKeys("Beach");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-search2']")).click();
		Thread.sleep(3000);
	}
}
