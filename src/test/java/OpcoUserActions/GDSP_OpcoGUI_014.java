package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_014 {
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

	@FindBy(xpath="//a[@href='manage_contact_overview.htm']")
	public static WebElement Contacts_ManageContacts;

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

	@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_ManageContacts;


	public static WebDriver driver;

	public GDSP_OpcoGUI_014(WebDriver driver)
	{
		this.driver=driver;
	}

	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();

	}

	public void searchContacts(String fullname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		ManageAccount_Opco.click();
		Contacts_ManageContacts.click();
		ContactNameSearchBox_ManageContacts.sendKeys(fullname);
		Thread.sleep(2000);
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
		Thread.sleep(2000);
		try
		{
		if((Usertable_ManageContacts.getText()).contains(fullname))
		{
			test.log(Status.INFO, "Contacts search is successful");
			System.out.println("Contacts search is successful");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			test.log(Status.INFO,"Scroll down has been done");

			BackToTop_ManageContacts.click();
			Thread.sleep(2000);
			test.log(Status.INFO,"Successfully clicked on Back to top button");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
		}
		}
		catch(Exception e)
		{              
			test.log(Status.INFO, "Contacts does not found for the created user");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("Contacts does not found for the created user");
		}






	}

}


