package eupchaar.ui.automation.Enums;

public enum VisitReason {
	Consultation("Consultation"),
	HealthCheckup("Health Checkup");	
	
	
private String value;
	
   private VisitReason(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; 
   }

}
