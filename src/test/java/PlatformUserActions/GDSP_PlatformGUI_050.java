package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_050 {
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
	public static WebElement FullName_UserCreation;

	@FindBy(xpath="//select[@onchange='changeBSG(this)']")
	public static WebElement Usertype_UserCreation;

	@FindBy(id="user.vfOpCoId")
	public static WebElement Opcocode_UserCreation;

	@FindBy(id="user.phone1")
	public static WebElement PhoneNumber1_UserCreation;

	@FindBy(id="user.contactEmailAddress")
	public static WebElement Email_UserCreation;

	@FindBy(name="user.userRolePriv")
	public static WebElement AccessRights_UserCreation;

	@FindBy(id="user.userName")
	public static WebElement Username_UserCreation;

	@FindBy(id="userCredentials.password")
	public static WebElement Password_UserCreation;

	@FindBy(id="userCredentials.passwordConfirm")
	public static WebElement ReenterPassword_UserCreation;

	@FindBy(id="submit")
	public static WebElement SaveButton_UserCreation;

	@FindBy(xpath="//input[@value='Ok']")
	public static WebElement popup_ok;

	@FindBy(xpath="//input[@name='formSearchValue1']")
	public static WebElement Username_searchbox;

	@FindBy(xpath="//input[@alt='submit'] ")
	public static WebElement serachDetails_Button;

	@FindBy(xpath="//a[contains(@href,'logout.htm?')]")
	public static WebElement logout_button;


	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement errormessage_createNewUser;

	public static WebDriver driver;

	public GDSP_PlatformGUI_050(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();

	}

	public void createUser(String fullname, String opcoCode, String Email, String Username, String Password,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		ManageAccount_PlatformTab.click();
		UserAccounts_PlatformTab.click();
		Create_UserDetails.click();
		Thread.sleep(1000);
		FullName_UserCreation.sendKeys(fullname);
		Select dropdown1 = new Select(Usertype_UserCreation);
		dropdown1.selectByIndex(2);	
		//PhoneNumber1_UserCreation.sendKeys(phoneNumber);
		Thread.sleep(2000);
		Email_UserCreation.sendKeys(Email);
		Select dropdown3 = new Select(AccessRights_UserCreation);
		dropdown3.selectByVisibleText("Read/Write/Delete");
		Username_UserCreation.sendKeys(Username);
		Password_UserCreation.sendKeys(Password);
		ReenterPassword_UserCreation.sendKeys(Password);
		SaveButton_UserCreation.click();
		try{
			if(errormessage_createNewUser.getText().contains("error"))
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(450,0)", ""); //scroll up  
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				js.executeScript("window.scrollBy(0,450)", ""); 
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				test.log(Status.INFO, "there are some error in creating user");
				test.log(Status.PASS, "User can't be created with missing data");
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO, "user has been created successfully");
			Database.tc050(Username);
			test.log(Status.INFO, "Db has been verified");
		}
	}
}
