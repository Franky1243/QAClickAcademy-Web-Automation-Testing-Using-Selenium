package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class NavBarValidation extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		log.info("Successfully invoked the browser");
		driver.get(prop.getProperty("url"));
		log.info("Successfully landed to the homepage");
	}
	
	
	
	@Test
	public void NavBarChecking() throws IOException
	{
		
		
		LandingPage LandingPageObject = new LandingPage(driver);
		if(LandingPageObject.getPopupSize().size() > 0)
		{
			LandingPageObject.getPopup().click();
		}
		
		Assert.assertTrue(LandingPageObject.getNavBar().isDisplayed());
		log.info("Condition matched");
		
		
		
		
		
		
		
		
	}
	
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		
		driver.close();
		log.info("Successfully closed the browser");
		driver = null;
		
		
	}
	
	
	
	
	
	
}
