package eupchaar.ui.automation.Enums;

public enum IDProof {
	Aadhaar(2),
	BPLCard(5),
	DrivingLicense(13),
	VoterIdCard(14),
	PANCard(16),
	Passport(18);
	
	
 private int value;
	
   private IDProof(int value)
   {
      this.value = value;
   }

   public int toInt()
   {
      return this.value; 
   }


}
