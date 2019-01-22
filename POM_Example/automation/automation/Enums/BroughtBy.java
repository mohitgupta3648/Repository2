package eupchaar.ui.automation.Enums;

public enum BroughtBy {
	Others("Others"),
	Police("Police"),
	Self("Self");
	
	//NPS("National Programme Scheme");
	
	private String value;
	
	   private BroughtBy(String value)
	   {
	      this.value = value;
	   }

	   public String toString()
	   {
	      return this.value; 
	   }

}
