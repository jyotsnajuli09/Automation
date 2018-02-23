package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_026 {
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


@FindBy(xpath="//a[text()='Edit']")
public static WebElement Editsp_Managesp;

@FindBy(name="serviceProfile.customerProfileDesc")
public static WebElement Cspdesc_managesp;

@FindBy(xpath="//div[@class='tablewrapper pc70']")
public static WebElement cspdetailstable_Managesp;

@FindBy(id="submit")
public static WebElement saveButton_editcsp;


public static WebDriver driver;

public GDSP_CustomerGUI_026(WebDriver driver)
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
public void editexistingcspdetails(String cspdesc,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
{
	Managesp_Customer.click();
	randomsp_Managesp.click();
	Editsp_Managesp.click();
	Cspdesc_managesp.sendKeys(cspdesc);
	JavascriptExecutor jse1 = (JavascriptExecutor) driver;
	jse1.executeScript("window.scrollBy(0,1050)", "");
	saveButton_editcsp.click();
	try
	{
		if(cspdetailstable_Managesp.getText().contains(cspdesc))
		{
			String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath);
			test.log(Status.INFO,"csp details edited and  displayed successfully");
			System.out.println("csp details  edited and displayed successfully");
			test.log(Status.PASS,"csp details  edited and displayed successfully");
		}
	}
	
	catch(Exception e)
	{
		
		test.log(Status.INFO,"csp details are not  edited successfully");
		String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath);
		System.out.println("csp details are not edited successfully ");
		test.log(Status.FAIL,"csp details are not edited successfully ");
	}
	
}
}
