package eupchaar.ui.automation.testsuites.Registration;

import org.testng.annotations.Test;

import eupchaar.ui.automation.DataObj.DoctorAssignmentInfo;
import eupchaar.ui.automation.DataObj.PatientDemoGraphicsInfo;
import eupchaar.ui.automation.DataObj.PaymentCollectionInfo;
import eupchaar.ui.automation.Enums.AgeUnit;
import eupchaar.ui.automation.Enums.Category;
import eupchaar.ui.automation.Enums.Facility;
import eupchaar.ui.automation.Enums.Gender;
import eupchaar.ui.automation.Enums.IDProof;
import eupchaar.ui.automation.Enums.MaritalStatus;
import eupchaar.ui.automation.Enums.Module;
import eupchaar.ui.automation.Enums.ReferralType;
import eupchaar.ui.automation.Enums.RelationshipType;
import eupchaar.ui.automation.Enums.Role;
import eupchaar.ui.automation.Enums.Scheme;
import eupchaar.ui.automation.Enums.BroughtBy;
import eupchaar.ui.automation.Enums.SearchBy;
import eupchaar.ui.automation.Enums.VisitReason;
import eupchaar.ui.automation.PageModels.HomePage;
import eupchaar.ui.automation.PageModels.LoginPage;
import eupchaar.ui.automation.PageModels.OPDConsultationPage;
import eupchaar.ui.automation.PageModels.OPVisitsPage;
import eupchaar.ui.automation.ReusableFunctions.AssignRooms;
import eupchaar.ui.automation.ReusableFunctions.AuthCode;
import eupchaar.ui.automation.utils.DBValidationUtils;
import eupchaar.ui.automation.utils.DO;
import eupchaar.ui.automation.utils.Logger;
import junit.framework.Assert;

public class OPRegistrationSuite {
	

	private HomePage home = new HomePage();
	private LoginPage log = new LoginPage();
	//----------------------------------------------------------------------------
	
	@Test
	public void ERRegistrationHappyPath() throws Exception
	{
		// Assign doctor to a room
		//AssignRooms assign = new AssignRooms();
		//assign.assignRoomToDoctor(Facility.GH6Panchkula,"GENERAL MEDICINE","Dr. Angela Dhingra");
		
		// get the Auth Code
		//String authCode = new AuthCode().getAuthCode();
		
		// Patient Info Data Setup
		PatientDemoGraphicsInfo patInfo = new PatientDemoGraphicsInfo(
				Gender.Male, 23, AgeUnit.Years, Category.General, "Haryana", "Panchkula", "Abdullapur");
		patInfo.setUID();
		patInfo.setPhoneNum();		
		patInfo.setRelationInfo(RelationshipType.SonOf);
		patInfo.setScheme(Scheme.MMIY);
		patInfo.setBroughtby(BroughtBy.Self);
		patInfo.setMaritalStatus(MaritalStatus.Married);
		
		// DoctorAssignment Info Data Setup
//		DoctorAssignmentInfo docInfo = new DoctorAssignmentInfo(
//				VisitReason.Consultation, "General Medicine", ReferralType.INTERNAL, "Dr Nitin");
//		docInfo.setIDProofType(IDProof.Aadhaar);
//		docInfo.setRefCardNumber(patInfo.getUID());
		
		// Payment Info Data Setup
//		PaymentCollectionInfo payInfo = new PaymentCollectionInfo(false,"Poor","",false);
		
		// Test Begins Here
		log.login(Facility.GH6Panchkula,Role.EmergencyAndMLC);
		home.createNewWorkspace();
		home.selectModule(Module.Admissions);
		
		OPVisitsPage opvisits = new OPVisitsPage();
		//opvisits.clickNewOPVisit();
		opvisits.setPatientDemographicDetails(patInfo);
		//opvisits.setDoctorAssignmentDetails(docInfo);
		//opvisits.setPaymentDetails(payInfo);		
		//opvisits.uncheckPrintCard(true);
		opvisits.clickOnSave();
		
		opvisits.clickAdvancedSearch().SearchPatient(SearchBy.VisitedDays, "0");
		//opvisits.clickAdvancedSearch().SearchPatient(SearchBy.UID, aadhaarNum);
		String UHID = opvisits.clickAdvancedSearch().verifyResultsTable(patInfo);
		
		if(UHID.equals(""))
			Assert.fail("Couldn't able to find the patient from the table");
		else
			patInfo.setUHID(UHID);
		
		DO.getScreenshot();
		Thread.sleep(1000);
		opvisits.clickAdvancedSearch().selectHighlightedRowFormSearchTable();
		opvisits.clickModifyOpenVisit();
		Boolean isPatientDetailsCorrect = opvisits.verifyExistingPatientDetails(patInfo);
		Assert.assertTrue("Didn't match the Input Patients Details with the retirved patient details from open OPD visit", isPatientDetailsCorrect);
		home.logout();	
		
		//DBValidationUtils dbValidate = new DBValidationUtils();
		//dbValidate.validateNewRegistration(patInfo, docInfo);
		
	}

	
	
	

	//--------------------------------------------------------------------------------
	@Test
	public void OPRegistrationHappyPath() throws Exception
	{
		// Assign doctor to a room
		AssignRooms assign = new AssignRooms();
		//assign.assignRoomToDoctor(Facility.GH6Panchkula,"GENERAL MEDICINE","Dr. Angela Dhingra");
		
		// get the Auth Code
		//String authCode = new AuthCode().getAuthCode();
		
		// Patient Info Data Setup
		PatientDemoGraphicsInfo patInfo = new PatientDemoGraphicsInfo(
				Gender.Male, 23, AgeUnit.Days, Category.General, "Haryana", "Panchkula", "Abdullapur");
		patInfo.setUID();
		patInfo.setPhoneNum();		
		patInfo.setRelationInfo(RelationshipType.SonOf);
		//patInfo.setScheme(Scheme.MMIY);
		
		// DoctorAssignment Info Data Setup
		DoctorAssignmentInfo docInfo = new DoctorAssignmentInfo(
				VisitReason.Consultation, "General Medicine", ReferralType.INTERNAL, "Dr Nitin");
		docInfo.setIDProofType(IDProof.Aadhaar);
		docInfo.setRefCardNumber(patInfo.getUID());
		
		// Payment Info Data Setup
		PaymentCollectionInfo payInfo = new PaymentCollectionInfo(false,"Poor","",false);
		
		// Test Begins Here
		log.login(Facility.GH6Panchkula,Role.Registration);
		home.createNewWorkspace();
		home.selectModule(Module.OutpatientVisits);
		
		OPVisitsPage opvisits = new OPVisitsPage();
		opvisits.clickNewOPVisit();
		opvisits.setPatientDemographicDetails(patInfo);
		opvisits.setDoctorAssignmentDetails(docInfo);
		opvisits.setPaymentDetails(payInfo);		
		opvisits.uncheckPrintCard(true);
		opvisits.clickSave();
		
		opvisits.clickAdvancedSearch().SearchPatient(SearchBy.VisitedDays, "0");
		//opvisits.clickAdvancedSearch().SearchPatient(SearchBy.UID, aadhaarNum);
		String UHID = opvisits.clickAdvancedSearch().verifyResultsTable(patInfo);
		
		if(UHID.equals(""))
			Assert.fail("Couldn't able to find the patient from the table");
		else
			patInfo.setUHID(UHID);
		
		DO.getScreenshot();
		Thread.sleep(1000);
		opvisits.clickAdvancedSearch().selectHighlightedRowFormSearchTable();
		opvisits.clickModifyOpenVisit();
		Boolean isPatientDetailsCorrect = opvisits.verifyExistingPatientDetails(patInfo);
		Assert.assertTrue("Didn't match the Input Patients Details with the retirved patient details from open OPD visit", isPatientDetailsCorrect);
		home.logout();	
		
		//DBValidationUtils dbValidate = new DBValidationUtils();
		//dbValidate.validateNewRegistration(patInfo, docInfo);
		
	}
	
	@Test
	public void opdTest() throws Exception
	{
		String UHID = "350011072112";
		// OPD - Login As Doctor
		log.login(Facility.GH6Panchkula,Role.OPD);
		home.createNewWorkspace();
		home.selectModule(Module.MyPatients);
		OPDConsultationPage opd = new OPDConsultationPage();
		opd.clickOnWaiting();
		opd.selectPatientFromWaitingList(UHID);
		//opd.completeConsulation();
	}
	
	@Test
	public void authCodeTest() throws Exception
	{
		// get the Auth Code
		String authCode = new AuthCode().getAuthCode();
	}
	
	@Test
	public void assignDoctorTest() throws Exception
	{
		String doctorName = "Dr. Angela Dhingra";
		AssignRooms assign = new AssignRooms();
		String roomNumber = assign.assignRoomToDoctor(Facility.GH6Panchkula,"General Medicine", doctorName);
		
		
		
		DoctorAssignmentInfo docInfo = new DoctorAssignmentInfo(
				VisitReason.Consultation, "General Medicine", ReferralType.INTERNAL, "Dr Nitin");
		
		log.login(Facility.GH6Panchkula,Role.Registration);
		home.createNewWorkspace();
		home.selectModule(Module.OutpatientVisits);
		OPVisitsPage opvisits = new OPVisitsPage();
		opvisits.clickNewOPVisit();
		opvisits.setDoctorAssignmentDetails(docInfo);
		
		String defaultDocName = docInfo.getDoctorName();
		Assert.assertTrue(defaultDocName.equals(doctorName));
		
	}
	
	@Test
	public void dbTest()
	{
		/*DBUtil dbutil = new DBUtil();
		String sql = "SELECT * from u_patient WHERE pat_mrn IN (350011084837, 350011084805)";
		dbutil.executeQuery(sql);
		List<String> output = dbutil.getResultByColumnName("pat_rid");
		
		for(String result : output)
		{
			Logger.log(result);
		}
		
		output = dbutil.getResultByColumnName("pat_gender_name");
		
		for(String result : output)
		{
			Logger.log(result);
		}*/
		
		String ageUnit = "Years";
		Logger.log("Age Unit: " + ageUnit.replaceAll("\\(", "").replaceAll("\\)", ""));
		
	}

}
