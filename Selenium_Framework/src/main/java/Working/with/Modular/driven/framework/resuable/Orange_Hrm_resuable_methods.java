package Working.with.Modular.driven.framework.resuable;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Orange_Hrm_resuable_methods {

	ChromeDriver driver;
	String baseUrl="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	WebDriverWait wait;
	@BeforeTest
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("browser opened");
	}
	
	@Test//no need of mentioning this as these are reusable methods
  public void login(String username,String password){
		wait=new WebDriverWait(driver, 1);
		driver.findElement(By.id("txtUsername")).clear();
		wait=new WebDriverWait(driver, 1);
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		wait=new WebDriverWait(driver, 1);
		driver.findElement(By.id("txtPassword")).clear();
		wait=new WebDriverWait(driver, 1);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		wait=new WebDriverWait(driver, 1);
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("logged in successfully");
	}
	@Test
	public void addUser(String firstName,String middleName,String lastName,String empId) {
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
		wait=new WebDriverWait(driver, 1);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='middleName']")).sendKeys(middleName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(empId);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		System.out.println("user added");
	}
	
	@Test
	public void deleteUser() {
		//public void deleteUser(String xpath1,String xpath2,String xpath3,String xpath4) {
		//driver.findElement(By.xpath(xpath)).click();
		driver.findElement(By.xpath("//b[contains(text(),'PIM')]")).click();
		driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();
		driver.findElement(By.xpath("//tr[2]//td[1]")).click();
		driver.findElement(By.xpath("//input[@id='btnDelete']")).click();
		driver.findElement(By.xpath("//input[@id='dialogDeleteBtn']")).click();
		System.out.println("user deleted");
	}
	
	@Test
	public void appLogout() {
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("logged out successfully");
	}
	@Test
	public void verifyStatus(String expected) {
		String exp=expected;
		String actual=driver.findElement(By.xpath("//a[@id='welcome']")).getText();	
		if(exp.equalsIgnoreCase(actual)){
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		System.out.println("status verified");
	}
	
	@Test
	public void takeScreenshot(String loc) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(loc));
		System.out.println("screenshot taken successfully");
	}
	
	@AfterTest
	public void closeBrowser(){
		wait=new WebDriverWait(driver, 1);
		driver.close();
		System.out.println("browser closed");
	}
}