package eupchaar.ui.automation.Enums;

public enum Unit {
	ULTRASOUND("ULTRASOUND"),
	CLINICAL_PATHOLOGY("CLINICAL PATHOLOGY"),
	HAEMATOLOGY("HAEMATOLOGY"),
	LABORATORY("LABORATORY"),
	MAIN_MEDICAL_STORE("MAIN MEDICAL STORE"),
	PHARMACY("PHARMACY");
	
	
private String value;
	
   private Unit(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; 
   }

}
