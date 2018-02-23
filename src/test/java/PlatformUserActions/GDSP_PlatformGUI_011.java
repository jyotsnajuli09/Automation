package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_011 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_platform_ops_details.htm']")
	public static WebElement ManageAccount_PlatformTab;

	@FindBy(xpath="//a[@href='account_user_only_details.htm']")
	public static WebElement UserAccounts_PlatformTab;

	@FindBy(id="submit")
	public static WebElement Create_UserDetails;

	@FindBy(name="user.contactName")
	public static WebElement FullName_UserEdit;

	@FindBy(xpath="//select[@onchange='changeBSG(this)']")
	public static WebElement Usertype_UserEdit;

	@FindBy(id="user.vfOpCoId")
	public static WebElement Opcocode_UserEdit;

	@FindBy(id="user.phone1")
	public static WebElement PhoneNumber1_UserEdit;

	@FindBy(id="user.contactEmailAddress")
	public static WebElement Email_UserEdit;

	@FindBy(name="user.userRolePriv")
	public static WebElement AccessRights_UserEdit;

	@FindBy(id="user.userName")
	public static WebElement Username_UserEdit;

	@FindBy(id="userCredentials.password")
	public static WebElement Password_UserEdit;

	@FindBy(id="userCredentials.passwordConfirm")
	public static WebElement ReenterPassword_UserEdit;

	@FindBy(id="submit")
	public static WebElement SaveButton_UserEdit;

	@FindBy(xpath="//input[@value='Ok']")
	public static WebElement popup_ok;

	@FindBy(xpath="//input[@name='formSearchValue1']")
	public static WebElement Usernamesearchbox_UserDetails;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement EditLink_UserDetails;

	@FindBy(xpath="//input[@alt='submit']")
	public static WebElement searchIcon_UserDetails;

	@FindBy(id="overviewtable3")
	public static WebElement UserTable_UserDetails;

	@FindBy(xpath="//a[contains(@href,'logout.htm?')]")
	public static WebElement logout_button;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_UserDetails;

	public static WebDriver driver;

	public GDSP_PlatformGUI_011(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		test.log(Status.INFO, "login is successful");
	}
	public void editUser(String fullname, String opcoCode,String phoneNumber, String Email, String Username, String Password,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		ManageAccount_PlatformTab.click();
		UserAccounts_PlatformTab.click();
		Usernamesearchbox_UserDetails.sendKeys(Username);
		searchIcon_UserDetails.click();
		try{
			if(EditLink_UserDetails.isDisplayed())
			{		
				test.log(Status.INFO, "Edit option is available for given user");
				EditLink_UserDetails.click();	
				Thread.sleep(1000);
				//FullName_UserEdit.clear();
				//FullName_UserEdit.sendKeys(fullname);
				//Select dropdown1 = new Select(Usertype_UserEdit);
				//dropdown1.selectByIndex(3);
				//Select dropdown2 = new Select(Opcocode_UserEdit);
				//dropdown2.selectByVisibleText(opcoCode);	
				//If you want to Edit phone number1
				PhoneNumber1_UserEdit.clear();
				PhoneNumber1_UserEdit.sendKeys(phoneNumber);
				Thread.sleep(2000);
				Email_UserEdit.clear();
				Email_UserEdit.sendKeys(Email);
				//Select dropdown3 = new Select(AccessRights_UserEdit);
				//dropdown3.selectByVisibleText("Read only");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				SaveButton_UserEdit.click();

				try{
					if(validationMesaage_UserDetails.isDisplayed()){
						if(validationMesaage_UserDetails.getText().contains("error"))
						{
							test.log(Status.INFO, validationMesaage_UserDetails.getText());
							test.log(Status.FAIL, "User Details does not edited successfully");
							String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath3);
						}
					}	

				}
				catch(Exception e1)
				{
					test.log(Status.INFO, "edit has been done for given AAA");
					//Database.tc022(Name);
					test.log(Status.PASS,"Edit BSG is successful");
					verifyUser(Username, test, tcid);
				}
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO, "Edit option is not available for given user");
		}
	}

	public static void verifyUser(String Username,com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		UserAccounts_PlatformTab.click();
		Usernamesearchbox_UserDetails.sendKeys(Username);
		searchIcon_UserDetails.click();
		try{
			if(UserTable_UserDetails.getText().contains(Username))
			{
				test.log(Status.INFO, "Edited user has been verified");	
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
			}
		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "Edited user has not been verified");	
		}

	}

}

