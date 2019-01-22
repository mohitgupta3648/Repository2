package eupchaar.ui.automation.Framework;

import org.testng.Reporter;

public class TestNGLogger extends iLogger{

	@Override
	public void log(String msg) {

		Reporter.log(msg);
	}

}
