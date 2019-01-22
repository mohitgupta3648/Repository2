package eupchaar.ui.automation.ReusableFunctions;

import eupchaar.ui.automation.Enums.Facility;
import eupchaar.ui.automation.Enums.LocatorType;
import eupchaar.ui.automation.Enums.Module;
import eupchaar.ui.automation.Enums.Role;
import eupchaar.ui.automation.PageModels.HomePage;
import eupchaar.ui.automation.PageModels.LoginPage;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Locator;
import eupchaar.ui.automation.utils.Logger;

public class AuthCode {
	
	//WebDriver driver = Driver.getInstace();
	private HomePage home = new HomePage();
	private LoginPage log = new LoginPage();
	
	public String getAuthCode() throws Exception
	{
		log.login(Facility.GH6Panchkula,Role.Registration);
		home.createNewWorkspace();
		home.selectModule(Module.MySettings);
		
		Locator loc = new Locator("featureTD1553",LocatorType.ID,"Change Auth Code");
		DO.click(loc);
		
		loc = new Locator("oldPasswd",LocatorType.ID,"Current Password");
		DO.enterText("admin", loc);
		
		loc = new Locator("save_btn",LocatorType.NAME,"Save Button");
		DO.click(loc);
		
		loc = new Locator("/html/body/div[9]/div/div/p",LocatorType.XPATH,"New Auth Code");
		String text = DO.getText(loc);
		String[] parts= text.split(" ");
		String authCode = parts[parts.length-1];
		
		Logger.log("New Auth Code is " + authCode);
		loc = new Locator("toastCloseButton",LocatorType.ID,"Close Alert Box");
		DO.click(loc);

		home.logout();
		
		return authCode;
	}

}
