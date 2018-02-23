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

public class GDSP_CustomerGUI_021 {
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
	
	@FindBy(xpath="//a[@href='manage_contact_overview.htm']")
	public static WebElement contactnames_Myaccount;
	
	@FindBy(xpath="//input[@value='Create']")
	public static WebElement createcontact_contact;
	
	@FindBy(name="contact.fullName")
	public static WebElement fullnamecontact_createcontact;
	
	@FindBy(name="contact.emailAddress")
	public static WebElement emailaddress_createcontact;
	
	@FindBy(name="contact.phoneNumber1")
	public static WebElement phonenumber_createcontact;
	
	@FindBy(id="submit")
	public static WebElement saveButton_createcontact;
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement contactnameSearchBox_contacts;
	
	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_contactnames;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_userfilter;
	
	
	@FindBy(xpath="//div[@class='tablewrapper pc70']")
	public static WebElement contactdetailstable_contacts;
	
	public static WebDriver driver;

	public GDSP_CustomerGUI_021(WebDriver driver)
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
	public void contactnamefilter(String contactname,String emailid,String phnnumber,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Myaccount_Customer.click();
		contactnames_Myaccount.click();
		
		
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,450)", "");
		createcontact_contact.click();
		fullnamecontact_createcontact.sendKeys(contactname);
		emailaddress_createcontact.sendKeys(emailid);
		phonenumber_createcontact.sendKeys(phnnumber);
		saveButton_createcontact.click();
		Thread.sleep(2000);
		
		contactnameSearchBox_contacts.sendKeys(contactname);
		List<WebElement> allOptions = dropdown_contactnames.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(contactname)) 
			{
				ele.click();
				Thread.sleep(3000);
			}

		}
		
		searchicon_userfilter.click();
		
		try
		{
			if(contactdetailstable_contacts.isDisplayed())
			{
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				test.log(Status.INFO,"conatact created and results displayed successfully");
				System.out.println("conatact created and results displayed successfully  ");
				test.log(Status.PASS,"conatact created and results displayed successfully  ");
			}
		}
		
		catch(Exception e)
		{
			
			test.log(Status.INFO,"conatact is not created and results displayed successfully ");
			String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath);
			System.out.println("results is not displayed successfully by contact name ");
			test.log(Status.FAIL,"results is not displayed successfully by contact name ");
		}
		
		
		
		
		
		
		
		
		
	}	
		
		
		
}

