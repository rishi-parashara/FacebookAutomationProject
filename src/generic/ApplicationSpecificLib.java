package generic;

import page.LoginPage;

public class ApplicationSpecificLib extends BaseTest{
	
	public void loginApplication(String un, String pw){
		
		System.out.println("In to Login method");
		System.out.println(un);
		System.out.println(pw);
		LoginPage l = new LoginPage(driver);
		System.out.println(l);
		l.setUserName(un);
		l.setPassword(pw);
		l.clickLogin();
	}
	
}
