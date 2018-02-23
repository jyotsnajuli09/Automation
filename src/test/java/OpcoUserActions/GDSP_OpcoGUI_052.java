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

public class GDSP_OpcoGUI_052 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement Managecustomers_Opco;
	
	@FindBy(xpath="//a[@href='manage_login_as_customer.htm']")
	public static WebElement loginascustomer_Managecustomers;
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement searchcustomername_Loginascustomer;
	
	@FindBy(xpath="//button[@title='Show All Items']")
	public static WebElement customerNamedropdown_Loginascustomer;


	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_customerName;

	@FindBy(xpath="//input[@type='submit']")
	public static WebElement Login_customerName;
	
	@FindBy(id="overviewtable")
	public static WebElement Usertable_Managecustomers;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_052(WebDriver driver)
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

	public void searchCustomerandlogin(String fullname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();
		loginascustomer_Managecustomers.click();
		searchcustomername_Loginascustomer.sendKeys(fullname);
		
		Thread.sleep(2000);
		//ContactNamedropdown_ManageContacts.click();
		// Thread.sleep(10000);

		List<WebElement> allOptions =dropdown_customerName.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(fullname)) 
			{
				Thread.sleep(1000);
				ele.click();
				
				Thread.sleep(2000);
			}

		}
		
		Login_customerName.click();
		
		Thread.sleep(2000);
		try{
			if(( Usertable_Managecustomers.isDisplayed()))
			{
				test.log(Status.INFO, "filteration of customer is successful");
				System.out.println("filteration of customer is successful");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				test.log(Status.PASS, "filteration of customer is successful");
			}
			}
			catch(Exception e)
			{              
				test.log(Status.INFO, "filteration of customer is not successful");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				System.out.println("filteration of customer is not successful");
				test.log(Status.FAIL, "filteration of customer is not successful");
			}

		
	}
}
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

