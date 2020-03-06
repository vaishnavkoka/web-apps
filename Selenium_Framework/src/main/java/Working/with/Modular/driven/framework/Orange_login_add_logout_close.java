package Working.with.Modular.driven.framework;
import java.io.IOException;


import org.testng.annotations.Test;

import Working.with.Modular.driven.framework.resuable.*;
//sub module or sub script
public class Orange_login_add_logout_close {

	Orange_Hrm_resuable_methods org;
	@Test
	public void login() throws IOException {
		org=new Orange_Hrm_resuable_methods();
		//resuable main script methods
		org.launchBrowser();
		org.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\main.jpg");
		org.login("Admin", "admin123");
		org.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\dashboard.jpg");
		org.addUser("vaishnav", "abc", "k", "abcd");//only a sample, doesn't work in reality
		org.takeScreenshot("C:\\Users\\Amul\\Desktop\\docs for job\\eclipse project\\Selenium_Framework\\Screenshots\\adduser.jpg");
		org.appLogout();
		org.closeBrowser();
	}
}
