package eupchaar.ui.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import eupchaar.ui.automation.Framework.LoggerFactory;
import eupchaar.ui.automation.Framework.iLogger;

public class Logger {
	
	private static Properties prop = new Properties();
	private static String loggerType;
	private static boolean isLoggerTypeKnown = false;
	
	private static void getLoggerType()
	{
		try {
			prop.load(new FileInputStream("properties/config.properties"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if(prop.getProperty("Logger") != null)
		{
			loggerType = prop.getProperty("Logger");
			isLoggerTypeKnown = true;
		}
	}
	
	public static void log(String logMsg)
	{
		if(!isLoggerTypeKnown) getLoggerType();
		iLogger lgr = LoggerFactory.getLogger(loggerType);
		lgr.log(logMsg);
	}

}
