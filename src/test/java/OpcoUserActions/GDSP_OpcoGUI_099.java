package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_099 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	
	@FindBy(xpath="//a[@href='indexOpCoSims.htm']")
	public static WebElement ManageSIMs_Opco;
	
	@FindBy(xpath="//a[@href='provision_sim_batch.htm']")
	public static WebElement provisionsimbatch_ManageSIMs;
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement CuscodeSearchBox_provisionsimbatch;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchbox_provisionsimbatch;
	
	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_provisionsimbatchCustomers;
	
	@FindBy(xpath="//table[@id='overviewtable']")
	public static WebElement tabledetail_Batchfileforcustomercode;
	
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_099(WebDriver driver)
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

public void ProvisionSIMBatch_Filter(String custcode,com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
{
	ManageSIMs_Opco.click();
	provisionsimbatch_ManageSIMs.click();
	
	CuscodeSearchBox_provisionsimbatch.sendKeys(custcode);
	Thread.sleep(2000);
	//ContactNamedropdown_ManageContacts.click();
	// Thread.sleep(10000);

	List<WebElement> allOptions =dropdown_provisionsimbatchCustomers.findElements(By.className("ui-menu-item"));

	java.util.Iterator<WebElement> i = allOptions.iterator();
	while(i.hasNext()) {
		WebElement ele = i.next();
		if (ele.getText().equals(custcode)) 
		{
			ele.click();
			Thread.sleep(5000);
		}

	}
	searchbox_provisionsimbatch.click();
try
{
	if(tabledetail_Batchfileforcustomercode.getText().contains(custcode))
	{
		test.log(Status.PASS,"provision sim batchfile filteration  through custcode is done successfully");
	
		String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath1);
		
		System.out.println("provision sim batchfile filteration  through custcode is done successfully");
	}
		
}
catch(Exception e)
{
	test.log(Status.FAIL,"provision sim batchfile filteration  through custcode is not done successfully");
	
	String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
	test.addScreenCaptureFromPath(screenShotPath2);
	
	System.out.println("provision sim batchfile filteration  through custcode is not done successfully");
}

}
}










