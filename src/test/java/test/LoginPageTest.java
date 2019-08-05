package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import base.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();

	}
	@Test
	public void loginPageTitleTest()
	{
		String title=loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "CRM");
	}
	@Test
	public void LoginPageTest_WhenEmailAndPasswordBlank()
	{
		String errorMessage=loginPage.verifyLoginPageWhenEmailAndPasswordBlank();
		Assert.assertEquals(errorMessage, "Something went wrong...","Email and Password not entered");
		
	}
	@Test
	public void LoginPageTest_WhenWrongEmailEntered()
	{
		String errorMessage=loginPage.verifyLoginPageWhenWrongEmail();
		Assert.assertEquals(errorMessage, "Something went wrong...","Incorrect email entered");
		
	}
	@Test
	public void LoginPageTest_WhenWrongPasswordEntered()
	{
		String errorMessage=loginPage.verifyLoginPageWhenWrongPassword();
		Assert.assertEquals(errorMessage, "Something went wrong...","Incorrect Password");
		
	}
	@Test
	public void LoginPageTest_WhenCorrectEmailAndPasswordEntered() throws InterruptedException
	{
		
		boolean settingIcon=loginPage.verifyLoginPageWhenCorrectEmailAndPassword();
		Assert.assertEquals(settingIcon, true);
		
	}
	@Test
	public void LoginPageTest_SignInButtonClickable()
	{
		boolean signButton=loginPage.verifyLoginPageSignInButtonClickable();
		Assert.assertEquals(signButton, true);
		
	}
	@AfterMethod
	public void exitBrowser()
	{
		driver.quit();
	}
}
