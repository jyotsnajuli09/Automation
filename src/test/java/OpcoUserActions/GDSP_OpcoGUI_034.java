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

public class GDSP_OpcoGUI_034 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement Managecustomer_Opco;


	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")

	public static WebElement searchboxcustomercode_Managecustomers;
	/*@FindBy(xpath="//button[@title='Show All Items']")
	public static WebElement TariffNamedropdown_Managetariffs;*/



	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdowcustcode_ManageCustomers;


	//input[@src='images/search.png']
	@FindBy(xpath="//a[text()='Manage Certificates']")
	public static WebElement managecertificate_Managecustomers;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_Managecustomers;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_Managecustomers;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_Managecertificates;

	/*@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_ManageContacts;*/

	@FindBy(name="formSearchValue")
	public static WebElement Certificatename_Managecertificates;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement search_certificate;

	public static WebDriver driver;

	public GDSP_OpcoGUI_034(WebDriver driver)
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

	public void searchcustomerandcertificates(String custname,String certificatename, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomer_Opco.click();
		Thread.sleep(3000);


		searchboxcustomercode_Managecustomers.sendKeys(custname);
		Thread.sleep(2000);
		//ContactNamedropdown_ManageContacts.click();
		// Thread.sleep(10000);

		List<WebElement> allOptions =dropdowcustcode_ManageCustomers.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(custname)) 
			{
				ele.click();
				Thread.sleep(5000);
			}

		}
		searchIcon_Managecustomers.click();
		
		try
		{

		if(( Usertable_Managecustomers.getText()).contains(custname))
		{
			test.log(Status.INFO, "customer Names search is successful");
			System.out.println("customer Names search is successful");
			Thread.sleep(2000);
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,2650)", "");
			
			managecertificate_Managecustomers.click();
			 Certificatename_Managecertificates.sendKeys(certificatename);
			 search_certificate.click();
			
			
			if(Usertable_Managecertificates.getText().contains(certificatename))
			{
				test.log(Status.INFO, "certifiacte Names search is successful");
				System.out.println("certificate Names search is successful");
				Thread.sleep(2000);
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				Thread.sleep(2000);
				test.log(Status.PASS, "certifiacte Names search is successful");
			}
		}
		}
		catch(Exception e)
		{              
			test.log(Status.INFO, "customer names search is not successful");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			System.out.println("customer names search is not successful");
			test.log(Status.FAIL, "certifiacte Names search is successful");
		}






	}

}




