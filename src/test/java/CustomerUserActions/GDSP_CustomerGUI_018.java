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

public class GDSP_CustomerGUI_018 {
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

	@FindBy(id="overviewtable3")
	public static WebElement usertable_userdetails;

	@FindBy(xpath="//*[@id='personal']/li[1]/b[3]")
	public static WebElement loggedonusername_login;

	public static WebDriver driver;


	public GDSP_CustomerGUI_018(WebDriver driver)
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
	public void userlogin(String Customercode,String username,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
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
				test.log(Status.PASS,"login as customer through opco is done successfully");
				System.out.println("login as customer through opco is done successfully");

				Myaccount_Customer_throughOpco.click();
				Userdetails_Myaccount_ThroughOpco.click();
				filter_usernames.sendKeys(username);
				searchicon_userfilter.click();



				if(usertable_userdetails.getText().contains(username))
				{
					test.log(Status.INFO, "User filteration is  done successfully through opco");
					String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath);

					System.out.println("User filteration is done successfully through opco");
				}

			}
		}

		catch(Exception e)

		{
			test.log(Status.INFO, "User login is not  done successfully and we are not able to filter");
			String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath);
			test.log(Status.FAIL,"User login is not  done successfully and we are not able to filter");
			System.out.println("User login is not  done successfully and we are not able to filter");

		}
	}
}
