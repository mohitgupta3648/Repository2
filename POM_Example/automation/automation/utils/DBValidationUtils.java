package eupchaar.ui.automation.utils;

import java.util.List;

import eupchaar.ui.automation.DataObj.DoctorAssignmentInfo;
import eupchaar.ui.automation.DataObj.PatientDemoGraphicsInfo;
import junit.framework.Assert;

public class DBValidationUtils {
	
	private DBUtil dbutil = new DBUtil();
	
	public void validateNewRegistration(PatientDemoGraphicsInfo patInfo, DoctorAssignmentInfo docInfo)
	{
	
		String mrn = patInfo.getUHID();
		String gender = patInfo.getGender();
		String age = Integer.toString(patInfo.getAge());
		String ageUnit = patInfo.getAgeUnit();
		
		String docName = docInfo.getDoctorName();
		String speciality = docInfo.getSpeciality();
		String visitReason = docInfo.getVisitReason();
		
		if(mrn == null)
		{
			Logger.log("No MRN Found. Abort DB Validation");
			return;
		}
		
		String sql = "SELECT * from u_patient WHERE pat_mrn = " + mrn;
		dbutil.executeQuery(sql);
		
		List<String> output = dbutil.getResultByColumnName("pat_rid");
		
		String rid = output.get(0);
		
		output = dbutil.getResultByColumnName("pat_gender_name");		
		
		Logger.log("Gender from Input: " + gender);
		Logger.log("Gender from DB: " + output.get(0));
		Assert.assertEquals(gender, output.get(0));
		
		sql = "SELECT * FROM uh_visit WHERE visit_patient_rid = " + rid;
		dbutil.executeQuery(sql);
		
		output = dbutil.getResultByColumnName("visit_type_index");	
		
		Logger.log("Visit Type Index from Input: 19602");
		Logger.log("Visit Type Index from DB: " + output.get(0));
		Assert.assertEquals("19602", output.get(0));
		
		output = dbutil.getResultByColumnName("visit_patient_age");
		
		Logger.log("Age from Input: " +  age);
		Logger.log("Age from DB: " + output.get(0));
		Assert.assertEquals(age, output.get(0));
		
		output = dbutil.getResultByColumnName("visit_patient_age_unit");
		
		
		Logger.log("Age Unit from Input: " + ageUnit);
		Logger.log("Age Unit from DB: " + output.get(0));
		Assert.assertEquals(ageUnit.replaceAll("\\(", "").replaceAll("\\)", ""), output.get(0).replaceAll("\\(", "").replaceAll("\\)", ""));
		
		output = dbutil.getResultByColumnName("visit_reason");
		Logger.log("Visit Reason from Input: " +  visitReason);
		Logger.log("Visit Reason from DB: " + output.get(0));
		Assert.assertEquals(visitReason, output.get(0));
		
		String visit_unit_rid = dbutil.getResultByColumnName("visit_unit_rid").get(0);
		String doctor_rid = dbutil.getResultByColumnName("visit_consulting_doctor").get(0);
				
		sql = "SELECT * FROM u_unit WHERE unit_rid = " + visit_unit_rid;
		dbutil.executeQuery(sql);
		
		output = dbutil.getResultByColumnName("unit_name");
		
		Logger.log("Speciality from Input: " +  speciality);
		Logger.log("Speciality from DB: " + output.get(0));
		Assert.assertTrue(output.get(0).contains(speciality));
		
		sql = "SELECT * FROM u_staff WHERE staff_rid = " + doctor_rid;
		dbutil.executeQuery(sql);
		
		output = dbutil.getResultByColumnName("staff_name");
		Logger.log("Doctor Name from Input: " +  docName);
		Logger.log("Doctor Name from DB: " + output.get(0));
		Assert.assertEquals(docName, output.get(0));
		

	}

}
