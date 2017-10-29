package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst {
	
	public WebDriver driver;
	
	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(String browser){
		
		if(browser.equals("chrome")){
			driver = new ChromeDriver();
		} else if(browser.equals("firefox")){
			driver = new FirefoxDriver();
		}
//		driver.manage().window().maximize();
		
		String sUrl = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(sUrl);
		
		String sIto = Lib.getProperty(CONFIG_PATH, "ITO");
		long lIto = Long.parseLong(sIto);
		driver.manage().timeouts().implicitlyWait(lIto, TimeUnit.SECONDS);
		
		String eTitle = Lib.getCellValue(XL_PATH, "ValidLogin", 1, 2);
		String aTitle = driver.getTitle();
		Assert.assertEquals(aTitle, eTitle, "Application Opened Successfully. PASS");
		Reporter.log("Application Opened Successfully. PASS",true);
	}
	
//	 <test name="TestFirefox">
//	  <parameter name="browser" value="firefox"/>
//	    <groups>
//	  	<run>
//	  		<include name="login"/>
//	  	</run>
//	  </groups>
//	    <packages>
//	      <package name="scripts"/>
//	    </packages>
//	  </test>
	
	@AfterMethod(alwaysRun=true)
	public void closeApplication(){
		try{
			Thread.sleep(2000);
		}catch(Exception e){
		}
		//driver.quit();
	}
}
