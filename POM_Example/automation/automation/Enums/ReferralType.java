package eupchaar.ui.automation.Enums;

public enum ReferralType {
	SELF("SELF"),
	INTERNAL("INTERNAL"),
	EXTERNAL("EXTERNAL");
	
	
 private String value;
	
   private ReferralType(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; 
   }

}
