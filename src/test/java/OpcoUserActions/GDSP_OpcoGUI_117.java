package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.mysql.jdbc.Driver;

public class GDSP_OpcoGUI_117 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_events_overview.htm']")
	public static WebElement Manageevents_Opco;
	
	@FindBy(xpath="//input[@id='submitforMozila']")
	public static WebElement createbutton_notificationevents;
	
	@FindBy(xpath="//input[@value='Next']")
	public static WebElement nextbutton_Eventdetails;
	
	@FindBy(xpath="//input[@name='notificationEvent.thresholdValue']")
	public static WebElement Thresoldvalue_Eventdetails;
	
	@FindBy(xpath="//input[@name='notificationEvent.notificationActionList[0]']")
	public static WebElement checkbox1_notificationaction;
	
	@FindBy(xpath="//input[@name='notificationEvent.notificationActionList[1]']")
	public static WebElement checkbox2_notificationaction;
	
	@FindBy(xpath="//input[@name='notificationEvent.thresholdEnabled']")
	public static WebElement checkbox3_thresoldenabled;
	
	@FindBy(xpath="//input[@name='notificationEvent.notificationEventName']")
	public static WebElement textfield_eventname;
	
	@FindBy(xpath="//input[@name='notificationEvent.notificationEventDesc']")
	public static WebElement textfield_eventdesc;
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement savebutton_details;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_Manageevents;
	
	
	public static WebDriver driver;
	
	public GDSP_OpcoGUI_117(WebDriver driver)
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
	public void createnotificationevent(String customercode,String eventmetric,String entitytype,String serviceprofname,String monitoringperiod,String thresoldvalue,String customercontrolledvalue,String eventname,String eventdesc, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		
		Manageevents_Opco.click();
		    Select dropDown = new Select(driver.findElement(By.name("customerId")));
			dropDown.selectByVisibleText(customercode);
			createbutton_notificationevents.click();
	Select dropdown1=new Select(driver.findElement(By.name("notificationEvent.thresholdMetric")));
	dropdown1.selectByVisibleText(eventmetric);
	nextbutton_Eventdetails.click();
	Select dropdown2=new Select(driver.findElement(By.name("notificationEvent.thresholdEntity")));
	dropdown2.selectByVisibleText(entitytype);
	Thread.sleep(2000);
	Select dropdown3=new Select(driver.findElement(By.name("notificationEvent.customerProfileId")));
	dropdown3.selectByVisibleText(serviceprofname);
	Thread.sleep(2000);
	Select dropdown4=new Select(driver.findElement(By.name("notificationEvent.thresholdMonitoringPeriod")));
	dropdown4.selectByVisibleText(monitoringperiod);
	Thread.sleep(2000);
	Thresoldvalue_Eventdetails.sendKeys(thresoldvalue);
	
	checkbox1_notificationaction.click();
	checkbox2_notificationaction.click();
	checkbox3_thresoldenabled.click();
	Select dropdown5=new Select(driver.findElement(By.name("notificationEvent.customerControlled")));
	dropdown5.selectByValue("Y");
	
	textfield_eventname.sendKeys(eventname);
	textfield_eventdesc.sendKeys(eventdesc);
	savebutton_details.click();
	Thread.sleep(2000);
	try
	{
		if(usertable_Manageevents.getText().contains(eventname))
		{
			test.log(Status.INFO,"event created successfully");
			Thread.sleep(3000);
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			System.out.println("event created successfully");
			test.log(Status.PASS,"event created successfully");
		}
			
	}
	catch(Exception e)
	{
		test.log(Status.INFO,"event is not created successfully");
		Thread.sleep(3000);
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		System.out.println("event is  not created successfully");
		test.log(Status.FAIL,"event is not created successfully");
	
}
}
}