package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	//Page Factory Model
		@FindBy(xpath=("//*[@class='ui basic button floating item dropdown']"))
		 WebElement settingButton;
		public HomePage()
		{
			PageFactory.initElements(driver, this);
		}

}
