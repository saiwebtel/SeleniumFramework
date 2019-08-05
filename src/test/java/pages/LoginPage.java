package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	 HomePage homePage;
	
	//Page Factory Model
	@FindBy(xpath=("//input[@type='text' and @name='email']"))
	 WebElement username;
	@FindBy(xpath=("//input[@type='password' and @name='password']"))
	 WebElement password;
	@FindBy(xpath=("//*[contains(text(),'Login') and @class='ui fluid large blue submit button']"))
	 WebElement submitButton;
	@FindBy(xpath=("//*[contains(text(),'Something went wrong...') and @class='header']"))
	 WebElement negativeMessage;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	public String verifyLoginPageWhenEmailAndPasswordBlank()
	{
		submitButton.click();
		return negativeMessage.getText();
		
	}
	public String verifyLoginPageWhenWrongEmail()
	{
		username.sendKeys("vinay1.saiwebtel@gmail.com");
		submitButton.click();
		return negativeMessage.getText();
		
	}
	public String verifyLoginPageWhenWrongPassword()
	{
		password.sendKeys("Test1@123");
		submitButton.click();
		return negativeMessage.getText();
		
	}
	public boolean verifyLoginPageWhenCorrectEmailAndPassword() throws InterruptedException
	{
		homePage=new HomePage();
		username.sendKeys("vinay.saiwebtel@gmail.com");
		password.sendKeys("Test@123");
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return homePage.settingButton.isDisplayed();
		
	}
	public boolean verifyLoginPageSignInButtonClickable()
	{
		return submitButton.isEnabled();
	}
}
