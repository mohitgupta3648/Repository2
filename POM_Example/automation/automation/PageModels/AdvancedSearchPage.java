package eupchaar.ui.automation.PageModels;

import java.util.Hashtable;
import java.util.List;

import eupchaar.ui.automation.DataObj.PatientDemoGraphicsInfo;
import eupchaar.ui.automation.Enums.LocatorType;
import eupchaar.ui.automation.Enums.SearchBy;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Locator;
import eupchaar.ui.automation.utils.Logger;

public class AdvancedSearchPage {
	

	private Locator aadhaarLoc = new Locator("aadharCardSearchString", LocatorType.ID, "Aadhaar/UHID Search");
	private Locator mrnLoc = new Locator("mrnSearchString", LocatorType.ID, "MRN Search");
	private Locator phoneLoc = new Locator("phoneSearchString", LocatorType.ID, "Phone Search");
	private Locator fNameLoc = new Locator("firstNameSearchString", LocatorType.ID, "First Name Search");
	private Locator lNameLoc = new Locator("lastNameSearchString", LocatorType.ID, "Last Name Search");
	private Locator ageLoc = new Locator("userAge", LocatorType.ID, "Age Search");
	private Locator ageUnitLoc = new Locator("patientAgeUnit", LocatorType.ID, "Age Unit");
	private Locator lastVisitedInLoc = new Locator("lastVisitedNum", LocatorType.ID, "Visit Duration Search");
	private Locator lastVisitedUnitLoc = new Locator("lastVisitedNumUnit", LocatorType.ID, "Visit Duration Unit");
	private Locator searchButtonLoc = new Locator("search", LocatorType.NAME, "Search Button");
	private Locator resultsTableLoc = new Locator("listTable", LocatorType.ID, "Results Table");
	private Locator rowToBehighlighted; // This is a dynamic locator and will be instantiated during the execution.
	private Locator okButtonLoc = new Locator("ok", LocatorType.NAME, "OK Button");
	
	public void SearchPatient(SearchBy searchBy, String searchString)
	{
		
		switch(searchBy)
		{
			case UID:				
 				DO.enterText(searchString, aadhaarLoc);
				break;
			case UHID:				
 				DO.enterText(searchString, mrnLoc);
				break;
			case PhoneNum:				
 				DO.enterText(searchString, phoneLoc);
				break;
			case FirstName:				
 				DO.enterText(searchString, fNameLoc);
				break;
			case LastName:				
 				DO.enterText(searchString, lNameLoc);
				break;
			case AgeInYears:				
 				DO.enterText(searchString, ageLoc);
				break;
			case AgeInMonths:				
 				DO.enterText(searchString, ageLoc);
 				DO.selectFromDropdownByVisibleText("Month(s)", ageUnitLoc);
				break;
			case AgeInDays:				
 				DO.enterText(searchString, ageLoc);
 				DO.selectFromDropdownByVisibleText("Day(s)", ageUnitLoc);
				break;
			case VisitedDays:
 				DO.enterText(searchString, lastVisitedInLoc);
				break;
			case VisitedMonths:				
 				DO.enterText(searchString, lastVisitedInLoc);
 				DO.selectFromDropdownByVisibleText("Month(s)", lastVisitedUnitLoc);
				break;
			case VisitedYears:				
 				DO.enterText(searchString, lastVisitedInLoc);
 				DO.selectFromDropdownByVisibleText("Year(s)", lastVisitedUnitLoc);
				break;
			default:
				break;
		}
		
 		DO.click(searchButtonLoc);		
		
	}
	
	
	public String verifyResultsTable(PatientDemoGraphicsInfo patInfo)
	{
		String name = patInfo.getfName() + " " + patInfo.getlName();
		String age = patInfo.getAge() + " " + patInfo.getAgeUnit();
		String gender = patInfo.getGender();
		String age_ = age.replace("(s)", "s");
		int index = 1;
		String uhid = null;
		boolean patFound = false;
		
		
		List<Hashtable<String, String>> tableContents = DO.getTableContentsForTableWithColumnNames(resultsTableLoc);
		
		for(Hashtable<String, String> row : tableContents)
		{
 			 
			if(row.get("Name").equals(name) && (row.get("Age").equals(age) || row.get("Age").equals(age_)) && row.get("Gender").equals(gender))
			{
				Logger.log("Found the registered Patient");
				
				rowToBehighlighted = new Locator("//*[@id=\"listTable\"]/tbody/tr[" + Integer.toString(index+1) +"]/td[1]", LocatorType.XPATH, "Highlighted Row");
 				uhid =  DO.getText(rowToBehighlighted);				
				DO.click(rowToBehighlighted);
				patFound = true;
				break;				
			}
			
			index++;
			if(patFound) break;
			
		}
		return uhid;
	}
	
	public void selectHighlightedRowFormSearchTable()
	{
		 
		DO.click(okButtonLoc);
		
	}
	

}
