package Self.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing {
	ChromeDriver driver;
	Robot ac;
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
		WebElement drop=driver.findElement(By.xpath("//input[@id='holiday_category_id']"));
		drop.sendKeys("India");
		drop.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(10000);
		drop.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
//		jse.executeScript("document.getElementById('dphh1').value='03/03/2020'");
		//		driver.findElement(By.id("dphh1")).sendKeys("03/03/2020");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='duration_d']")).sendKeys("3Nights / 4Days");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='themes']")).sendKeys("Beach");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-search2']")).click();
		Thread.sleep(3000);
	}
}
