package eupchaar.ui.automation.ReusableFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import eupchaar.ui.automation.Enums.Facility;
import eupchaar.ui.automation.Enums.LocatorType;
import eupchaar.ui.automation.Enums.Module;
import eupchaar.ui.automation.Enums.Role;
import eupchaar.ui.automation.PageModels.HomePage;
import eupchaar.ui.automation.PageModels.LoginPage;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Driver;
import eupchaar.ui.automation.utils.Locator;
import eupchaar.ui.automation.utils.Logger;

public class AssignRooms {
	
	private HomePage home = new HomePage();
	private LoginPage log = new LoginPage();
	String roomNumber = "";
	
	public String assignRoomToDoctor(Facility facility, String speciality, String doctorName) throws Exception
	{
		log.login(facility,Role.Registration);
		
		home.createNewWorkspace();		
		home.selectModule(Module.OPDManagement);
		
		Locator loc = new Locator("featureTD3763", LocatorType.ID, "Assign Room");
		DO.click(loc);
		
		loc = new Locator("changeButton", LocatorType.ID, "Change Button");
		DO.click(loc);
		
		loc = new Locator("//*[@id=\"assignRoomsForm\"]/div[1]/table/tbody/tr[2]/td/div/table/tbody", LocatorType.XPATH, "Assign Room Table");
		WebElement table = DO.getWebElement(loc);
		List<WebElement> totalRows = table.findElements(By.tagName("tr"));
		int index = 0;
		
		for(int i=1;i<totalRows.size();i=i+2)
		{
			index = i; 
			String xpath = "//*[@id=\"assignRoomsForm\"]/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[" + i + "]/td[1]";
			loc = new Locator(xpath, LocatorType.XPATH, "Speciality Name");
			String specName = DO.getText(loc);
			if(specName.equals(speciality))
				break;
		}
		
		String xpath = "//*[@id=\"assignRoomsForm\"]/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[" + index + "]/td[2]";
		loc = new Locator(xpath, LocatorType.XPATH, "Room Number");
		roomNumber = DO.getText(loc);
		
		Logger.log("Assigned Room Number: " + roomNumber);
		
		xpath = "//*[@id=\"assignRoomsForm\"]/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[" + index + "]/td[3]";
		loc = new Locator(xpath, LocatorType.XPATH, "Speciality");
		WebElement docsTable = DO.getWebElement(loc);
		
		loc = new Locator("changeDoctorCombo", LocatorType.ID, "To set as default assigned Doctor");
		DO.selectFromDropdownByVisibleText(doctorName, loc, docsTable);
		int counter = index+2;
		Boolean exit = false;
		
		
		
		while(!exit)
		{
			xpath = "//*[@id=\"assignRoomsForm\"]/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[" + counter + "]";
			loc = new Locator(xpath, LocatorType.XPATH, "Rooms List");
			WebElement roomTable = DO.getWebElement(loc);
			List<WebElement> rooms = roomTable.findElements(By.tagName("td"));
			System.out.println("Size: " + rooms.size());
			if(rooms.size() == 4)
			{
				
				xpath = "//*[@id=\"assignRoomsForm\"]/div[1]/table/tbody/tr[2]/td/div/table/tbody/tr[" + counter + "]/td[2]";
				
				loc = new Locator(xpath, LocatorType.XPATH, "Room");
				WebElement docsTableOther = DO.getWebElement(loc);
				
				loc = new Locator("changeDoctorCombo", LocatorType.ID, "To removeoOther Doctors from assignment");
				DO.selectFromDropdownByVisibleText("", loc, docsTableOther);
				
			}
			else
			{			
				exit = true;
			}
			
			counter = counter+2;
		}
		
		loc = new Locator("saveDoctorSelection", LocatorType.ID, "Save");
		DO.click(loc);
		
		loc = new Locator("toastCloseButton", LocatorType.ID, "Close Alert");
		DO.click(loc);
		
		Logger.log("Room Assigned to Doctor : " + doctorName);

		home.logout();
		
		return roomNumber;
		
	}

}
