package eupchaar.ui.automation.Framework;

public class LoggerFactory {
	
	public static iLogger getLogger(String type)
	{
		if(type.equalsIgnoreCase("TestNG")) return new TestNGLogger();
		if(type.equalsIgnoreCase("log4j")) return new Log4jLogger();
		return null;
	}
}
