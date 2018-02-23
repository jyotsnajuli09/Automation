package OpcoUserActions;


import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import DBOpco.DatabaseOpco;

import com.aventstack.extentreports.Status;


public class GDSP_OpcoGUI_112 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_vpn_groups_overview.htm']")
	public static WebElement ManageVPNs_Opco;
	
	@FindBy(xpath="//a[@href='manage_vpn_barring_overview.htm']")
	public static WebElement Calllistconfiguration_ManageVPNs;

	@FindBy(xpath="//input[@id='submit']")
	public static WebElement  createbutton_ManageVPNs;
	
	@FindBy(id="vpnBarring.vpnBarringName")
	public static WebElement newvpnbarringname_createnewcalllistconfigs;
	
	@FindBy(name="vpnBarring.vpnBarringDesc")
	public static WebElement newvpnbaaringdesc_createnewcalllistconfigs;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement savebutton;
	@FindBy(name="formSearchValue")
	public static WebElement searchbox_calllistname;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;
	
    @FindBy(xpath="//div[@class='tablewrapper pc70']")
    public static WebElement table_vapnbarringname;
    
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_calllistname;
	
	public static WebDriver driver;
	
	public GDSP_OpcoGUI_112(WebDriver driver)
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
	public void createcalllistconfig(String customercode,String vpnbarringname,String vpndesc,String barringtype,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		 ManageVPNs_Opco.click();
		 Calllistconfiguration_ManageVPNs.click();
		    Select dropDown = new Select(driver.findElement(By.name("customerId")));
			dropDown.selectByVisibleText(customercode);
			createbutton_ManageVPNs.click();
			newvpnbarringname_createnewcalllistconfigs.sendKeys(vpnbarringname);
			newvpnbaaringdesc_createnewcalllistconfigs.sendKeys(vpndesc);
			
			Select dropdown1=new Select(driver.findElement(By.name("vpnBarring.barringType")));
			dropdown1.selectByVisibleText(barringtype);
			
			savebutton.click();
			
	
	searchbox_calllistname.sendKeys(vpnbarringname);
	searchicon_calllistname.click();
	Thread.sleep(3000);
	
	try
	{
		if((table_vapnbarringname.getText()).contains(vpnbarringname))
		{
			
		
			
				
				test.log(Status.INFO, "  creation of calllistconfiguration is successfully done ");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				System.out.println("creation of calllistconfiguration is successfully done");
				test.log(Status.PASS, " creation of calllistconfiguration  is successfully done ");
				DatabaseOpco.tc112(vpnbarringname);
				System.out.println("deletion of created call list configuration is successfully done");
			}
			
		}
	
	catch(Exception e)
	{
		test.log(Status.INFO, "  creation of calllistconfiguration is not successfully done ");
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		Thread.sleep(2000);
		System.out.println("creation of calllistconfiguration is not successfully done");
		test.log(Status.FAIL, " creation of calllistconfiguration  is not successfully done");
	}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	
}
