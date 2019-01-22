package eupchaar.ui.automation.utils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class ScreenshotListener extends TestListenerAdapter{
	
	
	@Override
    public void onTestFailure(ITestResult result) {
        if(!result.isSuccess()){
        	Logger.log("Test \"" + result.getName() + "\" Failed");
        	DO.getScreenshot();
        }
    }
	
	@Override
	public void onFinish(ITestContext cxt) {
		Driver.getInstace().close();
		
	}

}
