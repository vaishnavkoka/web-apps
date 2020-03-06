package Working.with.Modular.driven.framework;

import java.io.IOException;

import org.testng.annotations.Test;

//import main script to use reusable methods
import Working.with.Modular.driven.framework.resuable.New_tours_resuable_methods;
public class New_tours_register_verify_ss_close {

	New_tours_resuable_methods meth;
	
	@Test
	public void operationTours() throws IOException {
		meth=new New_tours_resuable_methods();
		meth.launchBrowser();
		meth.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\landing_page.jpg");
		
		meth.registerPage("vaish", "k", "9876512", "adsasdasd", "asdasd", "hyderabad",
				"telangana", "654321", "INDIA", "vaishnav", "vaishnav", "vaishnav");
		meth.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\reg_page.jpg");
		meth.verifyStatus("Note: Your user name is vaishnav");
		meth.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\status_page.jpg");
		meth.closeBrowser();
	}
}