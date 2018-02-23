package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_016 {

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

	@FindBy(xpath="//a[@href='manage_contact_overview.htm']")
	public static WebElement Contacts_ManageContacts;

	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement ContactNameSearchBox_ManageContacts;

	@FindBy(xpath="//button[@title='Show All Items']")
	public static WebElement ContactNamedropdown_ManageContacts;

	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageContacts;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_ManageContacts;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageContacts;

	//*[contains(text(),'Edit')]
	@FindBy(xpath="//*[contains(text(),'Edit')]")
	public static WebElement Edit_ManageContacts;

	@FindBy(name="contact.fullName")
	public static WebElement FullName_EditContactDetail;

	@FindBy(name="contact.emailAddress")
	public static WebElement EmailAddress_EditContactDetail;

	@FindBy(name="contact.phoneNumber1")
	public static WebElement Telephone1_EditContactDetail;

	@FindBy(id="submit")
	public static WebElement save_EditContactDetail;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_ManageContacts;

	public static WebDriver driver;

	public GDSP_PlatformGUI_016(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password)
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();

	}

	public void editContacts(String fullname,  String Email, String Telephone,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		test.log(Status.INFO,"login is successful");
		ManageAccount_PlatformTab.click();
		Contacts_ManageContacts.click();
		ContactNameSearchBox_ManageContacts.sendKeys(fullname);
		Thread.sleep(10000);
		List<WebElement> allOptions = dropdown_ManageContacts.findElements(By.className("ui-menu-item"));
		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(fullname)) 
			{
				ele.click();
				Thread.sleep(5000);
			}

		}
		searchIcon_ManageContacts.click();
		Thread.sleep(2000);

		try{
			if((Usertable_ManageContacts.getText()).contains(fullname))
			{
				test.log(Status.INFO, "Contacts search is successful");
				Edit_ManageContacts.click();

				FullName_EditContactDetail.clear();
				FullName_EditContactDetail.sendKeys(fullname);

				EmailAddress_EditContactDetail.clear();
				EmailAddress_EditContactDetail.sendKeys(Email);

				Telephone1_EditContactDetail.clear();
				Telephone1_EditContactDetail.sendKeys(Telephone);

				save_EditContactDetail.click();

				try{
					if(validationMesaage_ManageContacts.isDisplayed()){
						if(validationMesaage_ManageContacts.getText().contains("error"))
						{
							test.log(Status.INFO, validationMesaage_ManageContacts.getText());
							test.log(Status.FAIL, "Contacts does not edited successfully");
							String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath2);
						}
					}	

				}
				catch(Exception e1)
				{
					test.log(Status.PASS,"Edit Contact is successful");
				}
			}
		}

		catch(Exception e)
		{		
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			test.log(Status.FAIL, "Contacts does not found for the given user");

		}

	}
}