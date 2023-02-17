package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

	public WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By forgotPassword = By.linkText("Forgot Password?");
	
	public WebElement forgotPassword()
	{
		return driver.findElement(forgotPassword);
	}
	
}
