package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Declaration
	@FindBy(id="email")
	private WebElement unTB;
	
	@FindBy(id="pass")
	private WebElement pwTB;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginBTN;
	
	//Initialization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public void setUserName(String un){
		System.out.println(un + "in utilization");
		System.out.println("unTB");
		unTB.sendKeys(un);
		System.out.println(un + "in utilization");
	}
	
	public void setPassword(String pw){
		pwTB.sendKeys(pw);
	}
	
	public void clickLogin(){
		
		loginBTN.click();
	}
}
