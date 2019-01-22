package eupchaar.ui.automation.Enums;

public enum Scheme {
	MMIY("MMIY"),
	Paid("Paid"),
	Free("Free"),
	NPS("National Programme Scheme");
	
	private String value;
	
	   private Scheme(String value)
	   {
	      this.value = value;
	   }

	   public String toString()
	   {
	      return this.value; 
	   }

}
