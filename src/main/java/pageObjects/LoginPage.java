package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By userEmail = By.id("user_email");
	By userPassword = By.id("user_password");
	By loginButton = By.name("commit");
	
	public WebElement userEmail()
	{
		return driver.findElement(userEmail);
	}
	
	
	public WebElement userPassword()
	{
		return driver.findElement(userPassword);
	}
	
	public WebElement login()
	{
		return driver.findElement(loginButton);
	}
}
