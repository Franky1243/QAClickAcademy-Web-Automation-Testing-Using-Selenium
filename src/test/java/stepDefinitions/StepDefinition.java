package stepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

	@Given("^initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver = browserInitialization();
		
    }
	
	@And("^navigate to \"([^\"]*)\" website$")
    public void navigate_to_something_website(String strArg1) throws Throwable {
		driver.get(strArg1);
    }

    @And("^click on the sign in to get into sign in page$")
    public void click_on_the_sign_in_to_get_into_sign_in_page() throws Throwable {
    	LandingPage LandingPageObject = new LandingPage(driver);
    	if(LandingPageObject.getPopupSize().size() > 0)
    	{
    		LandingPageObject.getPopup().click();
    	}
		LandingPageObject.signin().click();
    }

    
    @When("^user logs in by providing random username (.+) and password (.+)$")
    public void user_logs_in_by_providing_random_username_and_password(String username, String password) throws Throwable {
    	LoginPage LoginPageObject = new LoginPage(driver);
    	LoginPageObject.userEmail().sendKeys(username);

		LoginPageObject.userPassword().sendKeys(password);

		LoginPageObject.login().click();
    }

    @Then("^verify that user successfully logs in or not then click on forgot password$")
    public void verify_that_user_successfully_logs_in_or_not_then_click_on_forgot_password() throws Throwable {
    	ForgotPasswordPage ForgotPasswordPageObject = new ForgotPasswordPage(driver);
    	ForgotPasswordPageObject.forgotPassword().click();
    }

    

}