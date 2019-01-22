package eupchaar.ui.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Driver {
	
	private static WebDriver instance = null;
	private Properties prop = new Properties();
	private String browser = "Firefox";
	private static Boolean isPGIMS = false;
	
	private Driver()
	{
		
		
		try {
			prop.load(new FileInputStream("properties/config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if(prop.getProperty("Browser") != null)
			browser = prop.getProperty("Browser");
		
		if(prop.getProperty("Entity") != null)
			isPGIMS = prop.getProperty("Entity").equals("PGIMS");
		
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","BrowserDrivers/geckodriver.exe");
			
			instance = new FirefoxDriver();
		}
		
		if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","BrowserDrivers/IEDriverServer.exe");

			InternetExplorerOptions options = new InternetExplorerOptions();
			options.ignoreZoomSettings();
			options.requireWindowFocus();
			options.introduceFlakinessByIgnoringSecurityDomains();
			
			instance = new InternetExplorerDriver(options);
		}
		
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","BrowserDrivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			instance = new ChromeDriver();
		}
		
		
		//instance.manage().window().maximize();
		//instance.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static WebDriver getInstace()
	{
		if(instance == null)
		{
			new Driver();			
		}
		
		return instance;
	}
	
	public static Boolean isPgims()
	{
		return isPGIMS;
	}
		

}
