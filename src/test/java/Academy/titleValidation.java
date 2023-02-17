package Academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
//import pageObjects.LoginPage;
import resources.Base;

public class titleValidation extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		log.info("Browser is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Successfully landed to homepage");
	}
	
	
	@Test
	public void TitleValidations() throws IOException
	{
		
		
		LandingPage LandingPageObject = new LandingPage(driver);
		if(LandingPageObject.getPopupSize().size() > 0)
		{
			LandingPageObject.getPopup().click();
		}
		
		Assert.assertEquals(LandingPageObject.getTitle().getText(), "FEATURED COURSES");
		log.info("Info matched");
		
		
		
		
		
		
	}
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		
		driver.close();
		driver = null;
		log.info("Successfully closed the browser");
		
	}
	
	
	
	
	
	
	
}
