package eupchaar.ui.automation.Enums;

public enum Category {
	Antenatal("Antenatal"),
	BPL("BPL"),
	GovtServent("Government Servant"),
	Postnatal("Postnatal"),
	PoliceCustody("Police Custody"),
	General("General");
	
	
 private String value;
	
   private Category(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; 
   }

}
