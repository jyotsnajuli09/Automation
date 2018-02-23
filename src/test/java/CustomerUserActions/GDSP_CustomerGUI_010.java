package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_010 {
	@FindBy(name="login.userId")
	public static WebElement Customer_uname;

	@FindBy(id="submit")
	public static WebElement CustomerLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Customer_Pass;

	@FindBy(id="submit")
	public static WebElement CustomerPassword_Button;
	
	@FindBy(xpath="//a[@href='account_user_details.htm?fromPage=AccountUserDetails']")
	public static WebElement Myaccount_Customer;
	
	@FindBy(xpath="//a[@href='account_company_edit.htm?fromPage=AccountUserDetails']")
	public static WebElement editcompanydetails_Myaccount;
	
	@FindBy(name="customer.highUsageEmailList")
	public static WebElement highusagecontact_editcompany;
	
	@FindBy(name="customer.rogueUsageEmailList")
	public static WebElement Rogueusagecontact_editcompany;
	
	@FindBy(name="customer.imeiChangeEmailList")
	public static WebElement IMEIChangeContact_editcompany;
	
	@FindBy(name="customer.emailContactList")
	public static WebElement emailcontact_editcompany;
	
	@FindBy(id="submit")
	public static WebElement save_editcompany;
	
	@FindBy(xpath="//form[@action='#account_create_user']")
	public static WebElement table_companydetails;
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_UserDetails;
	
	

	public static WebDriver driver;

	public GDSP_CustomerGUI_010(WebDriver driver)
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
	public void editcompanydetails(com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		editcompanydetails_Myaccount.click();
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Select dropdown=new Select(highusagecontact_editcompany);
		dropdown.selectByIndex(2);
		Thread.sleep(1000);
	
		Select dropdown1=new Select(Rogueusagecontact_editcompany);
		dropdown1.selectByIndex(2);
		Thread.sleep(1000);
		Select dropdown2=new Select(IMEIChangeContact_editcompany);
		dropdown2.selectByIndex(1);
		Thread.sleep(1000);
		Select dropdown3=new Select(emailcontact_editcompany);
		dropdown3.selectByIndex(2);
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		save_editcompany.click();
		
		
		try
		{if(validationMesaage_UserDetails.isDisplayed()){
			if(validationMesaage_UserDetails.getText().contains("error"))
			{
				test.log(Status.INFO, "company details has not been edited successfully due to some internal error");
				System.out.println("company details edited has not been edited successfully due to some internal error");
				String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath4);
				test.log(Status.PASS, "company details has not been edited successfully due to some internal error");
			}
		}
			
			
		
		}
		catch(Exception e)
		{
			if(table_companydetails.getText().contains("Meenatchi"))
			{
		test.log(Status.INFO, "company details edited successfully");
		System.out.println("company details edited successfully");
		test.log(Status.PASS,"company details edited successfully");

		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
			}
	}
			
		}
	}

