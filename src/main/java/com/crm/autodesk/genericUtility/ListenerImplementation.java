package com.crm.autodesk.genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
	ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/report.html");
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("BABU DOCUMENT");
	spark.config().setReportName("Sanjay report");
	
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("created By", "Sanjay");
	report.setSystemInfo("Reviewed By", "babu");
	report.setSystemInfo("Envirnoment", "Windows 10");	
	
	}
	
	
	public void onTestStart(ITestResult result) {
		 test = report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		//capture the method name in run time
		String screenShotPath=null;
		
		//takesceenShot for failed testCase
try {
	 screenShotPath = new WebDriverUtility().takeScreenShot(BaseClass.sdriver, result);
} catch (Throwable e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
test.log(Status.FAIL, result.getThrowable());
test.addScreenCaptureFromPath(screenShotPath);
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	public void onFinish(ITestContext context) {
		
		report.flush();
	}
	
	
}
