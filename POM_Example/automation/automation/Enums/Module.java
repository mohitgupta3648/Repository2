package eupchaar.ui.automation.Enums;

public enum Module {
	FinanceMaster("Finance Master"),
	Reports("Reports"),
	PatienceAssistance("Patient Assistance"),
	StockIssue("Stock Issue"),
	Staff("Staff"),
	Pricing("Pricing"),
	Admissions("Admissions"),
	PurchaseReturns("Purchase Returns"),
	ChainManagement("Chain Management"),
	PatientRecords("Patient Records"),
	PatientFollowups("Patient Followups"),
	NursingTasks("Nursing Tasks"),
	MedicationDispense("Medication Dispense"),
	RosterList("Roster list"),
	LeaveAndRoster("Leave & Roster"),
	OTSchedule("OT Schedule"),
	UserManagement("User Management"),
	System("System"),
	Configuration("Configuration"),
	Outpatients("Outpatients"),
	OTConsole("OT Console"),
	HospitalOrganization("Hospital Organisation"),
	DietFunction("Diet Functions"),
	MedicalRecords("Medical Records"),
	BillingMasters("Billing Masters"),
	ConfigureNotifications("Configure Notifications"),
	SurgeryPlannig("Surgery planning"),
	MaterialMasters("Material Masters"),
	WorklistConfig("Worklist Config"),
	Inventory("Inventory"),
	InventoryMasters("Inventory Masters"),
	ClinicalTemplates("Clinical Templates"),
	MachineMaster("Machine Master"),
	MySettings("My Settings"),
	ProductSetup("Product Setup"),
	CorporatesAndTPAs("Corporates & TPAs"),
	Indents("Indents"),
	LabMasters("Lab Masters"),
	OPDManagement("OPD Management"),
	CollectionReport("Collection Report"),
	OutpatientVisits("Outpatient Visits"),
	MyPatients("My Patients"),
	Patients("Patients");

	
	private String value;
	
	   private Module(String value)
	   {
	      this.value = value;
	   }

	   public String toString()
	   {
	      return this.value; 
	   }
	
}
