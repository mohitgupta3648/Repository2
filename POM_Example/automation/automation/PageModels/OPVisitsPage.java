package eupchaar.ui.automation.PageModels;

import org.openqa.selenium.Keys;

import eupchaar.ui.automation.DataObj.DoctorAssignmentInfo;
import eupchaar.ui.automation.DataObj.PatientDemoGraphicsInfo;
import eupchaar.ui.automation.DataObj.PaymentCollectionInfo;
import eupchaar.ui.automation.Enums.LocatorType;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Driver;
import eupchaar.ui.automation.utils.Locator;
import eupchaar.ui.automation.utils.Logger;

public class OPVisitsPage {
	
	private Locator newOPVisitLoc = new Locator("featureTDVISIT", LocatorType.ID, "New OP Visit");
	private Locator saveButton = new Locator("//input[@onclick='emergencyRegistration.saveEmergencyRegistration();']", LocatorType.XPATH, "saveButton");
	
	//Patient Demographics
	private Locator aadhaarNumLoc = new Locator("aadharCardNumber", LocatorType.ID, "UID Number");
	private Locator phoneNumLoc = new Locator("user_phone", LocatorType.ID, "Phone Number");
	private Locator fNameLoc = new Locator("firstName", LocatorType.ID, "First Name");
	private Locator lNameLoc = new Locator("lastName", LocatorType.ID, "Last Name");
	private Locator genderLoc = new Locator("user_gender", LocatorType.ID, "Gender");		
	private Locator ageLoc = new Locator("user_age", LocatorType.ID, "Age");
	private Locator ageUnitLoc = new Locator("ageUnit", LocatorType.ID, "Age Unit");
	private Locator alertOKButtonLoc = new Locator("toastCloseButton", LocatorType.ID, "OK Button on Clear Speciality Alert");
	private Locator relTypeLoc = new Locator("relationTypeIndex", LocatorType.ID, "Relation Type");
	private Locator relNameLoc = new Locator("relativeName", LocatorType.ID, "Relative Name");
	private Locator stateLoc = new Locator("state", LocatorType.ID, "State");
    private Locator districtLoc = new Locator("district", LocatorType.ID, "District");
	private Locator tehsilLoc = new Locator("tehsil", LocatorType.ID, "City/Town/Village");		
	private Locator citySearch = new Locator("citySearch", LocatorType.ID, "City/Town/Village");	
	private Locator patCategoryLoc = new Locator("patientCategory", LocatorType.ID, "Patient Category");
	private Locator patSchemeLoc = new Locator("patientScheme", LocatorType.ID, "Patient Scheme");
	private Locator broughtBy = new Locator("broughtBy", LocatorType.ID, "broughtBy");
	private Locator maritalStatus = new Locator("maritalStatus", LocatorType.ID, "maritalStatus");
	
	
	// Doctor Assignment
	private Locator visitReasonLoc = new Locator("reasonForVisitIndex", LocatorType.ID, "Visit Reason");
	private Locator specialityLoc = new Locator("speciality", LocatorType.ID, "Speciality");
	private Locator docNameLoc = new Locator("doctorName", LocatorType.NAME, "Doctor Name");
	private Locator pgmisUnitLoc = new Locator("teamCombo", LocatorType.ID, "Unit in PGMIS");
	private Locator roomLoc = new Locator("availableRoom", LocatorType.ID, "Room");
	private Locator roomListLoc = new Locator("//*[@id=\"RoomListTbl\"]/tbody/tr[2]/td[1]/font", LocatorType.XPATH, "Room List");
	private Locator refTypeLoc = new Locator("referralTypeIndex", LocatorType.ID, "Referral Type");
	private Locator refByLoc = new Locator("referredBy", LocatorType.ID, "Referred By");
	private Locator refByDistrictLoc = new Locator("districts", LocatorType.ID, "Referral District");
	private Locator refEntityLoc = new Locator("referralEntityRID213", LocatorType.ID, "Referral Entity");
	
	//Registration Fee and Payment
	private Locator regFeeLoc = new Locator("regFeePriceTD", LocatorType.ID, "Registration Fee");
	private Locator waiveOffLoc = new Locator("waivedOff", LocatorType.ID, "Waive-Off Check-Box");
	private Locator waiveOffReasonLoc = new Locator("reasonForwaiveOff", LocatorType.ID, "Waive-Off Reason");
	private Locator otherChargesLoc = new Locator("chargeForOtherService", LocatorType.ID, "New Card Fee Check-box");
	private Locator newCardFeeLoc = new Locator("//*[@id=\"newCardChargesTR\"]/td[3]", LocatorType.XPATH, "New Card Fee Value");
	private Locator totalAmountLoc = new Locator("totalRegAmtSpan", LocatorType.ID, "Total Fee");
	private Locator printCardLoc = new Locator("printCard", LocatorType.ID, "Print Card Check-Box");
	private Locator saveLoc = new Locator("cursorPoint", LocatorType.CLASSNAME, "Save");
	private Locator authCodeLoc = new Locator("u-auth-user-code-entry", LocatorType.ID, "Auth Code");
	private Locator advSearchLoc = new Locator("blueButton", LocatorType.CLASSNAME, "Advanced Search");
	private Locator modifyVisitButtonLoc = new Locator("modifyVisitBtn", LocatorType.ID, "Modify Visit");
	private Locator patDetailsLoc = new Locator("//*[@id=\"patientDetailsDiv\"]/div/div[1]/div/table/tbody/tr/td[1]", LocatorType.XPATH, "Patient Details");
	

	private AdvancedSearchPage advSearch = new AdvancedSearchPage();
	Boolean printCard = false;
	Boolean advSearchClicked = false;
	Boolean isWaiveOff = false;
	String authCode = "";
	Boolean isPgmis = Driver.isPgims();
	
	public void clickNewOPVisit()
	{
		
		DO.click(newOPVisitLoc);
	}
	
	public void clickOnSave() throws InterruptedException
	{			
 Thread.sleep(2000);
		DO.click(saveButton);
	}
	
	
	public void setPatientDemographicDetails(PatientDemoGraphicsInfo patInfo) throws InterruptedException
	{
				
		if(patInfo.getUID() != null)
		{
			DO.enterText(patInfo.getUID(), aadhaarNumLoc);
		}
		
		Thread.sleep(2000);
		if(patInfo.getPhoneNum() != null)
		{
			DO.enterText(patInfo.getPhoneNum(), phoneNumLoc);
		
		}
		
 		DO.enterText(patInfo.getfName(), fNameLoc);
		
		
		if(patInfo.getlName() != null)
		{
 			DO.enterText(patInfo.getlName(), lNameLoc);
		}
		
		
 		DO.selectFromDropdownByVisibleText(patInfo.getGender(), genderLoc);

 		DO.enterText(Integer.toString(patInfo.getAge()), ageLoc);

 		DO.selectFromDropdownByVisibleText(patInfo.getAgeUnit(), ageUnitLoc);
		
		
		if(!patInfo.getAgeUnit().equals("Year(s)"))
		{
 			
			try{
				DO.click(alertOKButtonLoc);			
			}catch(Exception e)
			{
				// if no pop-up, just proceed.
			}
		}	
		
		
		if(patInfo.getRelationshipType() != null)
		{
			
 			DO.selectFromDropdownByVisibleText(patInfo.getRelationshipType(), relTypeLoc);
			
 			// Doing an extra click below to avoid skipping.
			// Not sure the reason for skipping here, but it observed consistently.
			DO.click(relNameLoc);
			DO.enterText(patInfo.getRelativesName(), relNameLoc);
			
		}
				
// 		DO.selectFromDropdownByVisibleText(patInfo.getState(), stateLoc);
//		
//		if(patInfo.getState().equalsIgnoreCase("Haryana"))
//		{
//			
// 			DO.selectFromDropdownByVisibleText(patInfo.getDistrict(), districtLoc);			
//			
// 			//DO.selectFromDropdownByVisibleText(patInfo.getVillage(), citySearch);
//		}
				
 		//DO.selectFromDropdownByVisibleText(patInfo.getCategory(), patCategoryLoc);			
		
		if(patInfo.getScheme() != null)
		{
			
 			DO.selectFromDropdownByVisibleText(patInfo.getScheme(), patSchemeLoc);		
		}
		
		
		if(patInfo.getBroughtby() != null)
		{
			
 			DO.selectFromDropdownByVisibleText(patInfo.getBroughtby(), broughtBy);		
		}
		
		if(patInfo.getMaritalStatus() != null)
		{
			
 			DO.selectFromDropdownByVisibleText(patInfo.getMaritalStatus(), maritalStatus);		
		}
		
		
		
	}
	
	
	public void setDoctorAssignmentDetails(DoctorAssignmentInfo docInfo)
	{
		
		if(!isPgmis)
		{
 			DO.selectFromDropdownByVisibleText(docInfo.getVisitReason(), visitReasonLoc);
		}
		
		
 		DO.selectFromDropdownByVisibleText(docInfo.getSpeciality(), specialityLoc);
		
		if(!isPgmis)
		{
		
 		//List<WebElement> list = DO.getWebElements(docNameLoc);
 		
 		String[] docList = DO.getAttributeValuesList(docNameLoc, "value");		
		String dName = docList[0];
		
		docInfo.setDoctorName(dName);
		Logger.log("Default Doctor Assigned : " + dName);
		}
		else
		{
 			DO.selectFromDropdownByIndex(1, pgmisUnitLoc);
			
 			DO.click(roomLoc);
			
 			DO.click(roomListLoc);
			
		}
		
		
 		DO.selectFromDropdownByVisibleText(docInfo.getReferralType(), refTypeLoc);
		
		if(docInfo.getReferralType().equals("SELF"))
		{

 			DO.click(refByLoc);
		}
		
		if(docInfo.getReferralType().equals("EXTERNAL"))
		{			
 			DO.enterText(docInfo.getRefBy(), refByLoc);
			DO.click(refByLoc);
		}
		
		if(docInfo.getReferralType().equals("INTERNAL") && !isPgmis)
		{
			
 			DO.selectFromDropdownByVisibleText("Panchkula", refByDistrictLoc);			
			
 			DO.selectFromDropdownByIndex(1, refEntityLoc);
			
			// Need to click two times to point the cursor here to execute the next step using tab
			DO.click(refEntityLoc);
			DO.click(refEntityLoc);
		}
		
		if(docInfo.getRefCardNumber() != null && !isPgmis)
		{
		
			DO.pressKey(Keys.TAB, 1);
			DO.pressKey(Keys.ARROW_DOWN, docInfo.getIDProofType());
			
			DO.pressKey(Keys.TAB, 1);
			DO.pressKey(docInfo.getRefCardNumber(), 1);
		}
		
	}
	
	
	public boolean setPaymentDetails(PaymentCollectionInfo payInfo)
	{
		double regFee = 0.00;
		double newCardFee = 0.00;
		double totalFee = 0.00;
		
 		String regFeeString = DO.getText(regFeeLoc);
		Logger.log("Reg Fee String: " + regFeeString);
		
		if(regFeeString.equals(""))
			regFeeString = "0.00";
		
		
		String newCardFeeString;
		
		isWaiveOff = payInfo.getIsWaiveOffRequired();
		authCode = payInfo.getAuthCode();
		
		if(isWaiveOff)
		{
 			DO.click(waiveOffLoc);
			
 			DO.enterText(payInfo.getWaiveOffReason(), waiveOffReasonLoc);
			
		}
		else
		{
			regFee = Double.parseDouble(regFeeString);
		}
		
		if(payInfo.getIsNewCardRequired())
		{
			
 			DO.click(otherChargesLoc);
			
 			newCardFeeString = DO.getText(newCardFeeLoc);
			
			newCardFee = Double.parseDouble(newCardFeeString);
		}
		
		totalFee = regFee + newCardFee;
		
 		String totalFeeString = DO.getText(totalAmountLoc);
		double totalFeeAct = Double.parseDouble(totalFeeString);
		
		Logger.log("Expected Fee: " + totalFee);
		Logger.log("Actual Fee: " + totalFeeAct);
		
		
		return(totalFee == totalFeeAct);
		
	}
	
	public void uncheckPrintCard(Boolean unCheckPrintCard)
	{
		if(unCheckPrintCard)
		{
			Logger.log("Un-Checking the Print Card check-box to avoid print slip screen");
 			DO.click(printCardLoc);
		}
	}
	
	public void clickSave()
	{
				
 
		DO.clickAnItemFromCollectionByAttribute("value", "Save", saveLoc);
		
		if(isWaiveOff)
		{

 			DO.enterText(authCode, authCodeLoc);
			
			DO.pressKey(Keys.ENTER, 1);

		}
	}
	

	
	public AdvancedSearchPage clickAdvancedSearch()
	{
		if(advSearchClicked)
			return this.advSearch;
		
 		advSearchClicked = DO.clickAnItemFromCollectionByAttribute("value", "Advanced Search", advSearchLoc);
		
		return this.advSearch;
	}
	
	public void clickModifyOpenVisit()
	{
 		DO.click(modifyVisitButtonLoc);
	}
	
	public Boolean verifyExistingPatientDetails(PatientDemoGraphicsInfo patInfo)
	{
		Boolean result = true;
		
	
 		String patDetail = DO.getText(patDetailsLoc);
				
		String[] details = patDetail.split(", ");
		
		if(!details[0].equals(patInfo.getFullName()))
		{
			result = false;
			Logger.log("Patient Name didn't match. Expected : " + patInfo.getFullName() + ". Actual : " + details[0]);
			
		}
		
		if(!details[2].equals(patInfo.getGender()))
		{
			result = false;
			Logger.log("Patient Gender didn't match. Expected : " + patInfo.getGender() + ". Actual : " + details[2]);
			
		}
		
		if(!details[3].equals(patInfo.getUHID()))
		{
			result = false;
			Logger.log("Patient UHID didn't match. Expected : " + patInfo.getUHID() + ". Actual : " + details[3]);
			
		}
				
		String ageUnit = "Years";
		String age = "";
		if(patInfo.getAgeUnit().equals("Month(s)"))
				ageUnit = "month";
		if(patInfo.getAgeUnit().equals("Day(s)"))
			age = "Less than one month";
		else
		{		
			age = patInfo.getAge() + " " + ageUnit;
		}
		
		if(!details[1].equals(age))
		{
			result = false;
			Logger.log("Patient Age didn't match. Expected : " + age + ". Actual : " + details[1]);
			
		}
		
		if(result)
			Logger.log("Patient details matched");
		
		return result;
	}
	

	
}
