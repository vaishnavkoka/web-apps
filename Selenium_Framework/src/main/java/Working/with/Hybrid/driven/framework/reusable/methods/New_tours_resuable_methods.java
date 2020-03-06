package Working.with.Hybrid.driven.framework.reusable.methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
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
public class New_tours_resuable_methods {

	ChromeDriver driver;
//	String baseUrl="http://www.newtours.demoaut.com/";
	WebDriverWait wait;
	Properties pro;
	FileInputStream fis;

	@BeforeTest
	public void launchBrowser() throws IOException {
		pro=new Properties();
		fis=new FileInputStream("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\New_tours_locators2.properties");
		pro.load(fis);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("browser opened");
	}
	
	@Test//no need of mentioning this as these are reusable methods
  public void registerPage(String firstName, String lastName, String phone, String email,
		    String address1,  String city,  String state,
		 String postalCode, String country, String userName, String password, String confirmPassword){
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.xpath(pro.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.xpath(pro.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.xpath(pro.getProperty("phonenumber"))).sendKeys(phone);
		driver.findElement(By.xpath(pro.getProperty("email"))).sendKeys(email);
		driver.findElement(By.xpath(pro.getProperty("address1"))).sendKeys(address1);
		driver.findElement(By.xpath(pro.getProperty("city"))).sendKeys(city);
		driver.findElement(By.xpath(pro.getProperty("state"))).sendKeys(state);
		driver.findElement(By.xpath(pro.getProperty("pincode"))).sendKeys(postalCode);
		driver.findElement(By.xpath(pro.getProperty("country"))).sendKeys(country);
		driver.findElement(By.xpath(pro.getProperty("usernamed"))).sendKeys(userName);
		driver.findElement(By.xpath(pro.getProperty("pass"))).sendKeys(password);
		driver.findElement(By.xpath(pro.getProperty("confirmpass"))).sendKeys(confirmPassword);
		
		driver.findElement(By.xpath(pro.getProperty("submitbtn"))).click();

	}
	@Test
	public String verifyStatus(String expected) {
		String actual=driver.findElement(By.xpath("//body//table//table//table//table//p[3]")).getText();
		String exp=expected;		
		
		if(actual.contains(exp)){//reverse for comparison, reason is actual length is more than exp
			return "pass";
		}
		else {
			return "fail";
		}
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