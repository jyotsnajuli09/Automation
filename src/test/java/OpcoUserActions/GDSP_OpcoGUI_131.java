package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_131 {
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
	@FindBy(name="formSearchValue2")
	public static WebElement searchbox2_endpointname;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageEvents;
	
	@FindBy(xpath="//*[@id='wrapper']/div/table[1]/tbody/tr/td[7]/input")
	public static WebElement searchicon2_outboundwebservice;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_131(WebDriver driver)
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
	public void searchendpointname(String endpointname, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageEvents_Opco.click();
		outboundwsc_ManageEvents.click();
		searchbox2_endpointname.sendKeys(endpointname);
	searchicon2_outboundwebservice.click();
	
	try
	{
		if(Usertable_ManageEvents.getText().contains(endpointname))
		{
			test.log(Status.INFO, "filteration through endpointnameis done successfully");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
		System.out.println("filteration is through endpointname done successfully");
		test.log(Status.INFO, "filteration is through endpointname done successfully");
		
	}
	
}
	catch(Exception e)
	
	{
		test.log(Status.INFO, "filteration through endpointname is not done successfully");
		String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath5);
	System.out.println("filteration through endpointname is not done successfully");
	test.log(Status.INFO, "filteration through endpointname is not done successfully");
	}
	
	}

	
	
	
	
	
	

}

