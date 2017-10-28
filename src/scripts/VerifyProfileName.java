package scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import page.HomePage;
import page.LoginPage;

public class VerifyProfileName extends BaseTest{
	@Test(priority=2)
	public void testVerifyProfileName() throws Exception{
		
		String un = Lib.getCellValue(XL_PATH, "ValidLogin", 2, 0);
		String pw = Lib.getCellValue(XL_PATH, "ValidLogin", 2, 1);
		
		LoginPage l = new LoginPage(driver);		
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLogin();
		
		Thread.sleep(6000);
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_ALT);
		
		Thread.sleep(2000);
		
		HomePage h = new HomePage(driver);
		h.verifyProfileText(driver);
		h.clickAccountSettings();
		h.clickLogout();
	}
}
