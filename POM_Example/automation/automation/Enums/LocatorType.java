package eupchaar.ui.automation.Enums;

public enum LocatorType {
	
	ID("id"),
	XPATH("xpath"),
	CLASSNAME("className"),
	CSSSELECTOR("cssSelector"),
	LINKTEXT("linkText"),
	PARTIALLINKTEXT("partialLinkText"),
	NAME("name"),
	TAGNAME("tagName");
	
	
 private String value;
	
   private LocatorType(String value)
   {
      this.value = value;
   }

   public String toString()
   {
      return this.value; 
   }


}
