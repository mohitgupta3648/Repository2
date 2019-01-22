package eupchaar.ui.automation.PageModels;

import eupchaar.ui.automation.Enums.LocatorType;
import eupchaar.ui.automation.Enums.Module;
import eupchaar.ui.automation.Enums.Unit;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Locator;

public class HomePage {
	
	private Locator signOut = new Locator("signOut", LocatorType.ID, "Sign-Out");
	private Locator newTab = new Locator("tabList0", LocatorType.ID, "New Tab");
	private Locator selectUnit = new Locator("unitSelected", LocatorType.ID, "Unit Selection");
	private Locator unitList = new Locator("unitSelectionBody",LocatorType.CLASSNAME,"Units");
	private Locator moduleList = new Locator("featureGroupName",LocatorType.CLASSNAME,"Feature Group");
	private Locator logoutFrmUnitSelection = new Locator("//*[@id=\"listTable\"]/tbody/tr[2]/td/input", LocatorType.XPATH, "Log-out from Unit Selection");
	
	
	public void logout()
	{

		DO.click(signOut);
	}
	
	public void createNewWorkspace() throws InterruptedException
	{

		DO.click(newTab);
		
	}
	
	public void selectUnit(Unit unit)
	{
		
		DO.waitForPageToLoad(10);
		DO.click(selectUnit);
		
		String matchText = unit.toString();
		DO.clickAnItemFromCollectionByText(matchText, unitList);
			
	}
	
	public void selectModule(Module module) throws Exception
	{
		
		String matchText=module.toString();
		Boolean moduleFound = false;
				
		DO.waitForPageToLoad(10);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			
		}
		
		moduleFound = DO.clickAnItemFromCollectionByText(matchText, moduleList);
		
		if(!moduleFound)
		throw new Exception("Module \"" + module.toString() + "\" was not found on the Workspace. Make sure you are logging in with the correct User");			
		
	}
	
	public void logoutFromUnitSelectPopup()
	{

		DO.click(selectUnit);
		DO.click(logoutFrmUnitSelection);
	}

}
