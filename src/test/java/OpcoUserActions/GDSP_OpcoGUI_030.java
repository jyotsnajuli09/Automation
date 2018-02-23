package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_030 {
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
	
	@FindBy(xpath="//input[@name='customerThrottling.entityMaxApiCount']")
	public static WebElement calllimit_customerthrottling;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_Managecustomers;

	@FindBy(xpath="//a[@href='manage_throttling_overview.htm?customerId=667&customerCode=001dp_test&fromPage=ManageCustomer']")
	public static WebElement configurethrottling_customers;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Editlink_apithrottling;
	@FindBy(xpath="//td[1][(text()='wscname')]/following-sibling::td[4]/a[text()='Delete']")
	public static WebElement deletelink_apithrottling;
	
	//td[1][(text()='createUser')]/following-sibling::td[4]/a[text()='Delete']
	
	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageCustomers;
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement savebutton_certificate;
	@FindBy(id="overviewtable3")
	public static WebElement table_configureapi;
	
	public static WebDriver driver;

	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement customersearch_managecustomers;

	
	public GDSP_OpcoGUI_030(WebDriver driver)
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
	public void customerthrottle(String Custname,String wscname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
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
	
			configurethrottling_customers.click();
			
			String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath1);
			Thread.sleep(3000);
			//td[1][(text()='createUser')]/following-sibling::td[4]/a[text()='Delete']
			System.out.println(wscname);
			
			driver.findElement(By.xpath("//td[1][(text()='guiGetCustomerDetails')]/following-sibling::td[4]/a[text()='Delete']")).click();
			System.out.println("hii");
			Actions act=new Actions(driver);
	 		Thread.sleep(2000);
	 		act.moveToElement(driver.findElement(By.name("ok"))).click().perform();
			
			try{
			if(table_configureapi.getText().contains(wscname))
			{
				System.out.println("delete is not done successfully");
			}
			else
			{
				
				test.log(Status.INFO, "delete is done asuccessfully");
				System.out.println("delete is done asuccessfully");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				test.log(Status.PASS, "delete is done asuccessfully");
				
				
				
			}
			}
	catch(Exception e)
	{
		test.log(Status.INFO, "delete is not done asuccessfully");
		System.out.println("delete is not done asuccessfully");
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		Thread.sleep(2000);
		test.log(Status.PASS, "delete is not done asuccessfully");
	}
	
	
	
}
}
