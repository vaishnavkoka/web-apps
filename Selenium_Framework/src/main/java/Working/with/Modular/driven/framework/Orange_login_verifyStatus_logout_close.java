package Working.with.Modular.driven.framework;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Working.with.Modular.driven.framework.resuable.*;
//sub module or sub script
public class Orange_login_verifyStatus_logout_close {

	Orange_Hrm_resuable_methods org;
	@Test
	public void Opeartion() {
		org=new Orange_Hrm_resuable_methods();
		org.launchBrowser();
		org.login("Admin", "admin123");
		org.verifyStatus("welcome Admin");
		org.appLogout();
		org.closeBrowser();
	}
}
