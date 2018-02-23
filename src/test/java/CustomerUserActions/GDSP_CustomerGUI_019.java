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

public class GDSP_CustomerGUI_019 {
	@FindBy(name="login.userId")
	public static WebElement Opco_uname;

	@FindBy(id="submit")
	public static WebElement OpcoLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Opco_Pass;

	@FindBy(id="submit")
	public static WebElement OpcoPassword_Button;

	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement manageCustomer_Opco;


	@FindBy(xpath="//a[@href='manage_login_as_customer.htm']")
	public static WebElement LoginasCustomer_Opco;

	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_logincustomers;

	@FindBy(id="submit")
	public static WebElement logincustomerbutton_managecustomer;

	@FindBy(xpath="//a[@href='account_user_details.htm?fromPage=AccountUserDetails']")
	public static WebElement Myaccount_Customer_throughOpco;


	@FindBy(xpath="//a[@href='account_user_only_details.htm']")
	public static WebElement Userdetails_Myaccount_ThroughOpco;

	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement customercodeSearchBox_loginascustomer;

	@FindBy(name="formSearchValue1")
	public static WebElement filter_usernames;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_userfilter;
	
	@FindBy(xpath="//a[text()='Edit']")
	public static WebElement Edit_user;
	
	@FindBy(name="userCredentials.password")
	public static WebElement user_Password;
	
	@FindBy(name="userCredentials.passwordConfirm")
	public static WebElement user_passwordconfirm;

	@FindBy(id="submit")
	public static WebElement save_edituser;
	
	@FindBy(xpath="//a[text()='Logout']")
	public static WebElement logout_user;

	@FindBy(xpath="//*[@id='personal']/li[1]/b[3]")
	public static WebElement loggedonusername_login;

	public static WebDriver driver;


	public GDSP_CustomerGUI_019(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login( String Username, String Password,com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		Opco_uname.sendKeys(Username);
		OpcoLogin_Button.click();
		Opco_Pass.sendKeys(Password);
		OpcoPassword_Button.click();
		test.log(Status.INFO, "logged in successfully");
	}
	public void resetpasswordthroughopco(String Customercode,String username,String newpassword,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		manageCustomer_Opco.click();
		LoginasCustomer_Opco.click();
		customercodeSearchBox_loginascustomer.sendKeys(Customercode);
		List<WebElement> allOptions = dropdown_logincustomers.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(Customercode)) 
			{
				ele.click();
				Thread.sleep(5000);
			}

		}
		logincustomerbutton_managecustomer.click();
		try{
			if(loggedonusername_login.getText().contains(Customercode))
			{
				test.log(Status.INFO, "login as customer through opco is done successfully"); 
				String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath1);
				
				System.out.println("login as customer through opco is done successfully");

				Myaccount_Customer_throughOpco.click();
				Userdetails_Myaccount_ThroughOpco.click();
				filter_usernames.sendKeys(username);
				searchicon_userfilter.click();
				Edit_user.click();
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("window.scrollBy(0,450)", "");
				//user_Password.clear();
				user_Password.sendKeys(newpassword);
				//user_passwordconfirm.clear();
				user_passwordconfirm.sendKeys(newpassword);
				Thread.sleep(2000);
				save_edituser.click();
				
				logout_user.click();
				Thread.sleep(2000);
				logout_user.click();
				Thread.sleep(2000);
				Opco_uname.sendKeys(username);
				OpcoLogin_Button.click();
				Opco_Pass.sendKeys(newpassword);
				OpcoPassword_Button.click();
				if(driver.getPageSource().contains("Welcome"))
				{
					String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath);
					test.log(Status.INFO,"Successfully logged in and Reset password");
					System.out.println("Successfully logged in and reset password");
					test.log(Status.PASS,"Successfully logged in and Reset password");
				}
			}
		}
			catch(Exception e1)
			{
				test.log(Status.FAIL, "Not logged in successfully and reset password is not done");
				System.out.println("Not logged in successfully and reset password is not done");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);

			}
				
				
				
				
				
}
}