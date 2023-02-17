package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base{
	
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		log.info("successfully invoked the browser");
		driver.get(prop.getProperty("url"));
		log.info("Successfully landed to the homepage");
		
	}
	
	@Test(dataProvider="getData")
	public void LoginWithDataProviderData(String username, String password) throws IOException
	{
		
		
		
		LandingPage LandingPageObject = new LandingPage(driver);
		if(LandingPageObject.getPopupSize().size() > 0)
		{
			LandingPageObject.getPopup().click();
		}
		LandingPageObject.signin().click();
		log.info("Successfully clicked on sign in page");
		
		LoginPage LoginPageObject = new LoginPage(driver);
		
		LoginPageObject.userEmail().sendKeys(username);
		log.info("Successfully passed the username");
		LoginPageObject.userPassword().sendKeys(password);
		log.info("Successfully passed the password");
		LoginPageObject.login().click();
		log.info("Successfully clicked on login button");
		
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[1][2];
		
		//1st row
		data[0][0] = "restricteduser@gmail.com";
		data[0][1] = "134553443";
		
		//2nd row
		/* data[1][0] = "non-restricteduser@gmail.com";
		data[1][1] = "134553443"; */
		
		return data;
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		
		driver.close();
		log.info("Successfully closed the browser");
		driver = null;
		
		
	} 

	
	
}
