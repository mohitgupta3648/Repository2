package eupchaar.ui.automation.PageModels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;

import eupchaar.ui.automation.Enums.Facility;
import eupchaar.ui.automation.Enums.LocatorType;
import eupchaar.ui.automation.Enums.Role;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Locator;

public class LoginPage {
	
	private Properties prop = new Properties();
	private String url;
	
	// Locators
	private Locator entity = new Locator("locationRID", LocatorType.ID, "Select Location");
	private Locator username = new Locator("userName", LocatorType.ID, "User Name");
	private Locator passWord = new Locator("password", LocatorType.ID, "Password");
	private Locator submitButton = new Locator("login", LocatorType.ID, "Sign In");
	
	public LoginPage()
	{
		 
		 try {
			prop.load(new FileInputStream("properties/config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
		 url = prop.getProperty("url");
	}
	
	public void login(Facility facility, Role role)
	{
		
		DO.getURL(url);
		
		String Role = role.toString();
		String userName = prop.getProperty(Role+"_user");
		String password = prop.getProperty(Role+"_password");	
	 	
	 
		int index = Integer.parseInt(prop.getProperty(facility.toString()));
				
		DO.pressKey(Keys.ARROW_DOWN, index, entity);
			
		DO.enterText(userName, username);
			
		DO.enterText(password, passWord);
			
		DO.click(submitButton);
		
	}
	
	
}
