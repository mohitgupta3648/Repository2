package eupchaar.ui.automation.Enums;

public enum MaritalStatus {
	Married("Married"),
	Single("Single"),
	 Widow(" Widow"),	
	 Widower(" Widower");
	
	private String value;
	
	   private MaritalStatus(String value)
	   {
	      this.value = value;
	   }

	   public String toString()
	   {
	      return this.value; 
	   }

}
