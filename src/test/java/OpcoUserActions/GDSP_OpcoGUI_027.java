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
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_027 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageCustomers;
	
	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement Managecustomers_Opco;
	
	@FindBy(xpath="//a[@href='manage_login_as_customer.htm']")
	public static WebElement logincustomers_Managecustomers;
	
    @FindBy(id="submit")
    public static WebElement loginbuttton_customers;
    @FindBy(id="overviewtable")
    public static WebElement datatable_customer;
	public static WebDriver driver;
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	 public static WebElement customersearch_logincustomers;
	

	public GDSP_OpcoGUI_027(WebDriver driver)
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
	public void customerlogin(String Custname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();
		
		logincustomers_Managecustomers.click();
		Thread.sleep(2000);
		 customersearch_logincustomers.sendKeys(Custname);
		 
		List<WebElement> allOptions =dropdown_ManageCustomers.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(Custname)) 
			{
				ele.click();
				Thread.sleep(3000);
			}

		
		 
		 

		//ContactNamedropdown_ManageContacts.click();
		// Thread.sleep(10000);

		loginbuttton_customers.click();
			
	      Thread.sleep(3000);
		 try{
				if(datatable_customer.isDisplayed())
				{
					test.log(Status.INFO, "login of customer is successful and data found");
					System.out.println("login of customer is successful and data found");
					String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath2);
					Thread.sleep(2000);
					test.log(Status.PASS, "login of customer is successful and data found");
				}
				}
				catch(Exception e)
				{              
					test.log(Status.INFO, "login customer is not successful and no data found");
					String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath3);
					System.out.println("login of customer is not successful");
					test.log(Status.FAIL, "login of customer is not successful and no data found");
				}

			
		}
	

		 
			

	}
}


