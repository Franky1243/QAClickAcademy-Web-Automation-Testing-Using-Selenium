package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector("#content > div > div > h2");
	By NavBar = By.cssSelector("#homepage > header > div.navbar.navbar-default.navbar-static-top > div > nav > ul");
	By Popup = By.xpath("//button[text()='NO THANKS']");
	
	
	public WebElement signin()
	{
		return driver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public List<WebElement> getPopupSize()
	{
		return driver.findElements(Popup);
	}
	
	public WebElement getPopup()
	{
		return driver.findElement(Popup);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(NavBar);
	}
	
}
