package Working.with.Modular.driven.framework;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Working.with.Modular.driven.framework.resuable.*;
//sub module or sub script
public class Orange_login_delete_logout_close {

	Orange_Hrm_resuable_methods org;
	@Test
	public void login() {
		org=new Orange_Hrm_resuable_methods();
		org.launchBrowser();
		org.login("Admin", "admin123");
		org.deleteUser();//you can even pass xpath if you have set them in main method
	//org.deleteUser("xpath1","xpath2","xpath3","xpath4");
		org.appLogout();
		org.closeBrowser();
	}
}
