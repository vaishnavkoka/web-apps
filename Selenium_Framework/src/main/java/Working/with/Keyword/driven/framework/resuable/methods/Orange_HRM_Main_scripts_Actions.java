package Working.with.Keyword.driven.framework.resuable.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orange_HRM_Main_scripts_Actions {
	ChromeDriver driver;
	//create separate method for each action you want to perform
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void navigate() {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	public void enterUsername() {
		driver.findElement(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}
	
	public void enterPassword() {
		driver.findElement(By.id("txtPassword")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	public void closeBrowser() {
		driver.close();
	}
}