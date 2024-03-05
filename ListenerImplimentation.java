package commonUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener{
	
	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is started",true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript execution is started",true);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is failed"+message,true);
		
		
		WebDriverUtil util = new WebDriverUtil();
		try {
			util.screenshot(null, "Contact");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is started",true);
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is started",true);
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is started",true);
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName();
		Reporter.log("Testscript execution is started",true);
		JavaUtil jutils = new JavaUtil();
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jutils.getRandomNumber()+".html");
		//Call config() to configure extentreport & call setDocumentTitle() to give title for the report
		reporter.config().setDocumentTitle("vtigercrm");
		
		//call setTheme() to set the theme for extent report
		reporter.config().setTheme(Theme.STANDARD);
		
		reporter.config().setReportName("Parimal");
		 
		
		//use ExtentReports to generate extentreport
		 report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Chrome");
		report.setSystemInfo("chromeversion", "122");
		report.setSystemInfo("Aurthor", "Parimal");
		
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//String methodName = result.getMethod().getMethodName();
		//Reporter.log("Testscript execution is started",true);
		report.flush();
		
	}
	
	

}
