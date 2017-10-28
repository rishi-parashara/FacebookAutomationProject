package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage {
	//Declaration
	@FindBy(xpath="//span[text()='Bishnu']") //Rishimuni Bishnu
	private WebElement profileText;

	@FindBy(xpath="//div[text()='Account Settings']")
	private WebElement acSetng;	
	
	@FindBy(xpath="//form[contains(@action,'logout.php')]/..")
	private WebElement logoutbTN;	
	
	//Initialization
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void verifyProfileText(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(profileText));
		Assert.assertTrue(profileText.isDisplayed(), "Profile Text displayed. PASS");
		Reporter.log("Profile Text displayed. PASS",true);
	}
	
	public void clickAccountSettings(){
		acSetng.click();
	}
	
	public void clickLogout(){
		logoutbTN.click();
	}
	
}
