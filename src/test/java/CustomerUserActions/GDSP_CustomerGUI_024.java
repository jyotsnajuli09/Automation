package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_024 
{
	@FindBy(name="login.userId")
public static WebElement Customer_uname;

@FindBy(id="submit")
public static WebElement CustomerLogin_Button;

@FindBy(name="login.password")
public static WebElement Customer_Pass;

@FindBy(id="submit")
public static WebElement CustomerPassword_Button;

@FindBy(xpath="//a[@href='manage_sp_overview.htm']")
public static WebElement Managesp_Customer;

@FindBy(xpath="//a[@href='manage_sp_overview_detail.htm?serviceProfileId=100272591&customerId=497']")
public static WebElement randomsp_Managesp;



@FindBy(xpath="//div[@class='tablewrapper pc70']")
public static WebElement cspdetailstable_Managesp;


public static WebDriver driver;

public GDSP_CustomerGUI_024(WebDriver driver)
{
	this.driver=driver;
}
public void login( String Username, String Password,com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
{
	Customer_uname.sendKeys(Username);
	CustomerLogin_Button.click();
	Customer_Pass.sendKeys(Password);
	CustomerPassword_Button.click();
	test.log(Status.INFO, "logged in successfully");
}
public void existingcspdetails(String cspname,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
{
	Managesp_Customer.click();
	randomsp_Managesp.click();
	
	try
	{
		if(cspdetailstable_Managesp.getText().contains(cspname))
		{
			String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath);
			test.log(Status.INFO,"csp details  displayed successfully");
			System.out.println("csp details  displayed successfully");
			test.log(Status.PASS,"csp details  displayed successfully");
		}
	}
	
	catch(Exception e)
	{
		
		test.log(Status.INFO,"csp details are not  displayed successfully");
		String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath);
		System.out.println("csp details are not displayed successfully ");
		test.log(Status.FAIL,"csp details are not displayed successfully ");
	}
	
}
}
