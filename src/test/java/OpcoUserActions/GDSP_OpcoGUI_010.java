package OpcoUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_OpcoGUI_010 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_opco_overview.htm']")
	public static WebElement ManageAccount_Opco;

	@FindBy(xpath="//a[@href='account_user_only_details.htm']")
	public static WebElement UserAccounts_ManageAccount;

	@FindBy(name="formSearchValue1")
	public static WebElement UserNamesSearchbox_UserDetails;

	@FindBy(name="formSearchValue2")
	public static WebElement FullNameSearchbox_UserDetails;

	@FindBy(name="formSearchValue3")
	public static WebElement CustomerCodeSearchbox_UserDetails;

	@FindBy(name="formSearchValue4")
	public static WebElement AccessRightsSearchbox_UserDetails;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement SearchIcon_UserDetails;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_UserDetails;

	public static WebDriver driver;

	public GDSP_OpcoGUI_010(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		test.log(Status.INFO, "Login is successful");

	}

	public void searchByUsername( com.aventstack.extentreports.ExtentTest test,String tcid , String username)
	{
		ManageAccount_Opco.click();
		UserAccounts_ManageAccount.click();
		UserNamesSearchbox_UserDetails.sendKeys(username);
		SearchIcon_UserDetails.click();

		try{
			if(Usertable_UserDetails.getText().contains(username))
			{
				test.log(Status.INFO, "Search with username is successful");
				String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath4);

			}	
		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "Search with username is not found");
		}

	}

	public void searchByFullname( com.aventstack.extentreports.ExtentTest test,String tcid , String Fullname)
	{
		UserAccounts_ManageAccount.click();
		FullNameSearchbox_UserDetails.sendKeys(Fullname);
		SearchIcon_UserDetails.click();

		try{
			if(Usertable_UserDetails.getText().contains(Fullname))
			{
				test.log(Status.INFO, "Search with fullname is successful");
				String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath4);
			}	
		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "Search with fullname is not found");
		}


	}


	public void searchByAccessright( com.aventstack.extentreports.ExtentTest test,String tcid , String Accessright)
	{
		UserAccounts_ManageAccount.click();
		Select Access = new Select(AccessRightsSearchbox_UserDetails);
		Access.selectByVisibleText(Accessright);
		SearchIcon_UserDetails.click();

		try{
			if(Usertable_UserDetails.getText().contains(Accessright))
			{
				test.log(Status.INFO, "Search with Accessright is successful");
				String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath4);

			}	
		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "Search with Accessright is not found");
		}

	}

	public void searchByCustomercode( com.aventstack.extentreports.ExtentTest test,String tcid , String Customercode)
	{
		UserAccounts_ManageAccount.click();
		CustomerCodeSearchbox_UserDetails.sendKeys(Customercode);
		SearchIcon_UserDetails.click();

		try{
			if(Usertable_UserDetails.getText().contains(Customercode))
			{
				test.log(Status.INFO, "Search with Customercodeis successful");
				String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath4);

			}	
		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "Search with Customercode is not found");
		}

	}

}