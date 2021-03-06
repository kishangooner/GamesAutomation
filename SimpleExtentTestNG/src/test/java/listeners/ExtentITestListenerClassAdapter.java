package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import config.WebDriverConfig;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.service.ExtentService;
import com.aventstack.extentreports.service.ExtentTestManager;

public class ExtentITestListenerClassAdapter implements ITestListener {
	
	ExtentTest test;
	
	@Override
    public synchronized void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);        
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        ExtentService.getInstance().flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTestManager.createMethod(result, true);
        test = ExtentTestManager.getTest(result);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        ExtentTestManager.log(result, true);
        
        WebDriver driver = WebDriverConfig.driver;
        
     // Take base64Screenshot screenshot for extent reports
     		String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

     		// Extentreports log and screenshot operations for failed tests.
     		test.addScreenCaptureFromBase64String(base64Screenshot, result.getMethod().getMethodName());
        
        
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

}
