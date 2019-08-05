package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	public static WebDriver driver;
	public Properties prop=new Properties();
	public File file;
	public FileInputStream FIS;
	
	public void initialization() throws IOException
	{
		loadPropertiesFile();
		selectBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	public void loadPropertiesFile() throws IOException
	{
		prop=new Properties();
	    FIS=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\config\\config.properties");
	    prop.load(FIS);
	}

	public WebDriver selectBrowser(String browser) {
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			//System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}

}
