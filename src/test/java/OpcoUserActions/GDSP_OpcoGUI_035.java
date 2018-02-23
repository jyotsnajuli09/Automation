package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_035 {
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
	
	@FindBy(xpath="//a[@href='manage_sims_attributes.htm?customerId=667&customerCode=001dp_test&prevPage=customer']")
	public static WebElement customsimattributes_Managecustomers;
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement customersearch_managecustomers;
	
	
	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageCustomers;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_Managecustomers;
	
	@FindBy(xpath="//input[@name='customer.customerEditableAttribute1']")
	public static WebElement checkbox1_configsimatt;
	
	@FindBy(xpath="//input[@name='customer.customerEditableAttribute1'")
	public static WebElement checkbox2_configsimatt;
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement savebutton;

	public static WebDriver driver;
	
	public GDSP_OpcoGUI_035(WebDriver driver)
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
	public void customerconfigattribute(String Custname,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();


		Thread.sleep(2000);
		customersearch_managecustomers.sendKeys(Custname);

		List<WebElement> allOptions =dropdown_ManageCustomers.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(Custname)) 
			{
				ele.click();
				Thread.sleep(3000);
			}
		}
			searchIcon_Managecustomers.click();
			Thread.sleep(3000);
			customsimattributes_Managecustomers.click();
			Thread.sleep(2000);
		boolean status=checkbox1_configsimatt.isSelected();
		try{
		if(status==true)
		{
			checkbox1_configsimatt.click();
			System.out.println("successfully checked sim attributes");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			 savebutton.click();
			 Thread.sleep(2000);
			test.log(Status.PASS,"successfully checked sim attributes");
		}
		else
		{
			checkbox1_configsimatt.click();
			 
			System.out.println("hiii3");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			Thread.sleep(2000);
			savebutton.click();
			test.log(Status.PASS,"successfully checked sim attributes");

		}
	
		}

	catch(Exception e)
		{
		test.log(Status.FAIL,"didn't checksim attributes");
		String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath5);
		}
		}
		}
			
			
	