package eupchaar.ui.automation.Enums;

public enum AgeUnit {
	Years("Year(s)"),
	Months("Month(s)"),
	Days("Day(s)");
	
	
 private String value;
	
   private AgeUnit(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; 
   }

}
