package eupchaar.ui.automation.DataObj;

import eupchaar.ui.automation.Enums.AgeUnit;
import eupchaar.ui.automation.Enums.BroughtBy;
import eupchaar.ui.automation.Enums.Category;
import eupchaar.ui.automation.Enums.Gender;
import eupchaar.ui.automation.Enums.MaritalStatus;
import eupchaar.ui.automation.Enums.RelationshipType;
import eupchaar.ui.automation.Enums.Scheme;
import eupchaar.ui.automation.utils.Helpers;

public class PatientDemoGraphicsInfo {
	
	private String phoneNum;
	private String UID;
	private String UHID;
	private String fName;
	private String lName;
	private String gender;
	private int age;
	private String ageUnit;
	private String dob;	
	private String relationship;
	private String relativesName;
	private String state;
	private String district;
	private String village;
	private String address;
	private String category;
	private String scheme;
	private String broughtby;
	private String maritalStatus;
	private Helpers helper = new Helpers();
	
	public PatientDemoGraphicsInfo(Gender gender, int age, AgeUnit ageUnit, Category category, String state, String district, String village)
	{
		this.fName = helper.getRandomAlphabetString(8);
		this.lName = helper.getRandomAlphabetString(6);
		
		this.age = age;
		this.ageUnit = ageUnit.toString();
		
		this.gender = gender.toString();
		this.category = category.toString();
		
		this.state = state;
		this.district = district;
		this.village= village;
	}
	
	
	public void setUID()
	{
		this.UID = helper.getRandomNumericString(12);;
	}
	
	public void setUHID(String UHID)
	{
		this.UHID = UHID;
	}
	
	public void setUIDInvalidLength(int n)
	{
		this.UID = helper.getRandomNumericString(n);;
	}
	
	public void setPhoneNum()
	{
		this.phoneNum = helper.getRandomNumericString(10);
	}
		
	public void setPhoneNumInvalidLength(int n)
	{
		this.phoneNum = helper.getRandomNumericString(n);
	}
		
	public void setDOB(String dob)
	{
		this.dob = dob;
	}	
	
	public void setRelationInfo(RelationshipType relationship)
	{
		this.relationship = relationship.toString();
		this.relativesName = helper.getRandomAlphabetString(6) + " " + helper.getRandomAlphabetString(3);
	}
		
	
	public void setScheme(Scheme scheme)
	{
		this.scheme = scheme.toString();
	}
	
	public void setBroughtby(BroughtBy broughtby)
	{
		this.broughtby = broughtby.toString();
	}
	
	public String getUID()
	{
		return this.UID;
	}
	
	public String getUHID()
	{
		return this.UHID;
	}
	
	public String getPhoneNum()
	{
		return this.phoneNum;
	}
	
	public String getfName()
	{
		return this.fName;
	}
	
	public String getlName()
	{
		return this.lName;
	}
	
	public String getFullName()
	{
		return this.fName + " " + this.lName;
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public String getAgeUnit()
	{
		return this.ageUnit;
	}
	
	public String getDob()
	{
		return this.dob;
	}
	
	
	public String getRelationshipType()
	{
		return this.relationship;
	}
	
	public String getRelativesName()
	{
		return this.relativesName;
	}
	
	public String getState()
	{
		return this.state;
	}
	
	public String getDistrict()
	{
		return this.district;
	}
	
	public String getVillage()
	{
		return this.village;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public String getScheme()
	{
		return this.scheme;
	}
	
	public String getBroughtby()
	{
		return this.broughtby;
	}


	public String getMaritalStatus() {
		return this.maritalStatus;
	}


	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus.toString();
	}
	
	
}
