package PlatformUserActions;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.TakeScreenshot;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_015 {
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

	@FindBy(id="submit")
	public static WebElement Create_ManageContacts;

	@FindBy(id="contact.fullName")
	public static WebElement FullName_CreatenewContact;

	@FindBy(id="contact.emailAddress")
	public static WebElement EmailAddress_CreatenewContact;

	@FindBy(id="contact.phoneNumber1")
	public static WebElement phoneNumber1_CreatenewContact;

	@FindBy(id="submit")
	public static WebElement save_CreatenewContact;

	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement ContactNameSearchBox_ManageContacts;

	@FindBy(xpath="//button[@title='Show All Items']")
	public static WebElement ContactNamedropdown_ManageContacts;


	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageContacts;


	//input[@src='images/search.png']
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_ManageContacts;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageContacts;
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_ManageContacts;

	public static WebDriver driver;

	public GDSP_PlatformGUI_015(WebDriver driver)
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

	public void createContacts(String fullname,  String Email, String Telephone,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		ManageAccount_PlatformTab.click();
		Contacts_ManageContacts.click();
		Create_ManageContacts.click();

		FullName_CreatenewContact.sendKeys(fullname);
		EmailAddress_CreatenewContact.sendKeys(Email);
		phoneNumber1_CreatenewContact.sendKeys(Telephone);
		save_CreatenewContact.click();
		
		try{
			if(validationMesaage_ManageContacts.isDisplayed()){
				if(validationMesaage_ManageContacts.getText().contains("error"))
				{
					test.log(Status.INFO, validationMesaage_ManageContacts.getText());
					test.log(Status.FAIL, "Contacts does not created successfully");
					}
				}			
	      }
		catch(Exception e)
		{
			test.log(Status.INFO, "Contacts has been created successfully");
		}
		}

	public void searchContacts(String fullname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		ManageAccount_PlatformTab.click();
		Contacts_ManageContacts.click();
		ContactNameSearchBox_ManageContacts.sendKeys(fullname);
		Thread.sleep(10000);
		//ContactNamedropdown_ManageContacts.click();
		// Thread.sleep(10000);

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
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Thread.sleep(2000);
       try{
		if((Usertable_ManageContacts.getText()).contains(fullname))
		{
			test.log(Status.INFO, "Contacts search is successful");
			
			System.out.println("Contacts search is successful");
		}}

		catch(Exception e)
		{	
			test.log(Status.INFO, "Contacts does not found for the created user");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("Contacts does not found for the created user");
		}

	}
}



