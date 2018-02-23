package PlatformUserActions;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericLibrary.CreateTestngXML;
import genericLibrary.CurrentDateTime;

public class BaseExtent extends CreateTestngXML  {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	static String fpath = CreateTestngXML.createDirectory();
	@BeforeSuite
	public void setup(){
		String now = CurrentDateTime.get_datetimestamp();
		htmlReporter = new ExtentHtmlReporter(fpath+"\\"+now+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		}
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(result.getName()+"Test Case failed",ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(MarkupHelper.createLabel(result.getName()+"Test Case Passed",ExtentColor.GREEN));
		}
		else
		{
			test.skip(MarkupHelper.createLabel(result.getName()+"Test Case Skipped",ExtentColor.YELLOW));
		}
	}
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}

}
