package eupchaar.ui.automation.Enums;

public enum RelationshipType {
	BrotherOf("BRO/o"),
	DaughterOf("D/o"),
	SonOf("S/o"),
	FatherOf("F/o"),
	HusbandOf("H/o"),
	MotherOf("M/o"),
	WifeOf("W/o"),
	SisterOf("SRO/o"),
	Other("Other");
	
   private String value;
	
   private RelationshipType(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; 
   }

}
