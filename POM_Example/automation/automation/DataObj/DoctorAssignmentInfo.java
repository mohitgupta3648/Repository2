package eupchaar.ui.automation.DataObj;

import eupchaar.ui.automation.Enums.IDProof;
import eupchaar.ui.automation.Enums.ReferralType;
import eupchaar.ui.automation.Enums.VisitReason;

public class DoctorAssignmentInfo {
	
	private String visitReason;
	private String speciality;
	private String doctorName;
	private String refType;
	private String refBy;
	private int IDType;
	private String refCardNumber;
	
	public DoctorAssignmentInfo(VisitReason visitReason, String speciality, ReferralType refType, String refBy)
	{
		this.visitReason = visitReason.toString();
		this.speciality = speciality;		
		this.refType = refType.toString();
		this.refBy = refBy;
	}
	
	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}
	
	public void setIDProofType(IDProof IDType)
	{
		this.IDType = IDType.toInt();
	}
	
	public void setRefCardNumber(String refCardNumber)
	{
		this.refCardNumber = refCardNumber;
	}
	
	
	public String getVisitReason()
	{
		return this.visitReason = visitReason.toString();
	}
	
	public String getSpeciality()
	{
		return this.speciality;
	}
	
	public String getDoctorName()
	{
		return this.doctorName;
	}
	
	public String getReferralType()
	{
		return this.refType;
	}
	
	public String getRefBy()
	{
		return this.refBy;
	}
	
	public int getIDProofType()
	{
		return this.IDType;
	}
	
	public String getRefCardNumber()
	{
		return this.refCardNumber;
	}
	

}
