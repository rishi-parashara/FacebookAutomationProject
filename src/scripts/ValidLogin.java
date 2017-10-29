package scripts;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.Test;

import generic.ApplicationSpecificLib;
import generic.BaseTest;
import generic.Lib;
import page.HomePage;
import page.LoginPage;

public class ValidLogin extends BaseTest{
	
	@Test(priority=1,groups={"login"})
	public void testValidLogin() throws Exception{
		
		String un = Lib.getCellValue(XL_PATH, "ValidLogin", 2, 0);
		String pw = Lib.getCellValue(XL_PATH, "ValidLogin", 2, 1);

//		ApplicationSpecificLib apl = new ApplicationSpecificLib();
//		apl.loginApplication(un, pw);
		
		LoginPage l = new LoginPage(driver);		
		l.setUserName(un);
		l.setPassword(pw);
//		Runtime.getRuntime().exec("D:/AutoIt/facebook1.exe");
		l.clickLogin();
		
		Thread.sleep(6000);
		
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		alert.accept();
		
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_ALT);
//		r.keyPress(KeyEvent.VK_N);
//		r.keyRelease(KeyEvent.VK_N);
//		r.keyRelease(KeyEvent.VK_ALT);
//		
//		Thread.sleep(2000);
		
		HomePage h = new HomePage(driver);
		h.clickAccountSettings();
		h.clickLogout();
		
	}
}
