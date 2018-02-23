package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_130 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_events_overview.htm']")
    public static WebElement ManageEvents_Opco;
	
	@FindBy(xpath="//a[@href='manage_outbound_web_services_overview.htm']")
    public static WebElement outboundwsc_ManageEvents;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageEvents;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_outboundwebservice;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_130(WebDriver driver)
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
	public void searchcustomer(String customercode, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageEvents_Opco.click();
		outboundwsc_ManageEvents.click();
	Select dropdown=new Select(driver.findElement(By.name("formSearchValue1")));
	dropdown.selectByIndex(1);
	searchicon_outboundwebservice.click();
	
	try
	{
		if(Usertable_ManageEvents.getText().contains(customercode))
		{
			test.log(Status.INFO, "filteration is done successfully");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
		System.out.println("filteration is done successfully");
		test.log(Status.INFO, "filteration is done successfully");
		
	}
	
}
	catch(Exception e)
	
	{
		test.log(Status.INFO, "filteration is not done successfully");
		String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath5);
	System.out.println("filteration is not done successfully");
	test.log(Status.INFO, "filteration is not done successfully");
	}
	
	}
}
	
	
	
	
	
	
