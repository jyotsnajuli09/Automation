package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_011 {
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

	@FindBy(xpath="//a[@href='account_user_edit.htm?userId=100203240&fromPage=AccountUserDetails']")
	public static WebElement edituserdetails_Myaccount;

	@FindBy(name="user.phone1")
	public static WebElement phonenumber_user;

	@FindBy(name="user.contactEmailAddress")
	public static WebElement email_user;

	@FindBy(id="submit")
	public static WebElement save_edituser;

	@FindBy(xpath="//form[@action='account_user_create.htm']")
	public static WebElement table_userdetails;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_UserDetails;

	public static WebDriver driver;

	public GDSP_CustomerGUI_011(WebDriver driver)
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
	public void edituserdetails(String phonenumber,String emailid,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");

		edituserdetails_Myaccount.click();

		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		phonenumber_user.clear();

		email_user.clear();

		
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("window.scrollBy(0,450)", "");
		save_edituser.click();
		try{
			if(validationMesaage_UserDetails.isDisplayed()){
				if(validationMesaage_UserDetails.getText().contains("error"))
				{
					test.log(Status.INFO, validationMesaage_UserDetails.getText());
					test.log(Status.PASS, "User Details has not been edited successfully");
					System.out.println("User Details has not been edited successfully");
					String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath3);
					phonenumber_user.sendKeys(phonenumber);
					email_user.sendKeys(emailid);
					JavascriptExecutor jse5 = (JavascriptExecutor) driver;
					jse5.executeScript("window.scrollBy(0,450)", "");
					save_edituser.click();
					
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0,850)", "");
					
					Thread.sleep(2000);
					if(table_userdetails.getText().contains(emailid))
					{
						test.log(Status.INFO, "user details edited successfully");
						System.out.println("user details edited successfully");
						test.log(Status.PASS,"user details edited successfully");

						String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath4);
					}
				}
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO, "user details has not been edited successfully due to some error");
			System.out.println("user details has not been edited successfully due to some error");
			test.log(Status.FAIL,"user details has not been edited successfully due to some error");

			String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath5);
		}
	}
	
		
		// TODO Auto-generated method stub
		
	}



