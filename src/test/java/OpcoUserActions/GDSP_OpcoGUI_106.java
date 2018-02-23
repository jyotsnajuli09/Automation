package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_106 {
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
	
	@FindBy(name="formSearchValue")
	public static WebElement searchbox_vpngrpname;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_vpngrpname;
	
	@FindBy(xpath="//a[contains(@href,'manage_restrictions')]")
	public static WebElement configmanagerestrictions_vpngrpname;
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement savebutton;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_106(WebDriver driver)
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
	public void vpnconfigcallrest(String vpngrpname,String inrest,String outrest, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageVPNs_Opco.click();
		searchbox_vpngrpname.sendKeys(vpngrpname);
		
		searchicon_vpngrpname.click();
		configmanagerestrictions_vpngrpname.click();
		Select dropDown1 = new Select (driver.findElement(By.name("vpnGroup.vpnBarringInScenarioList")));
		dropDown1.selectByValue(inrest);
	
		Select dropDown2 = new Select (driver.findElement(By.name("vpnGroup.vpnBarringOutScenarioList")));
		dropDown2.selectByValue(outrest);
		
		savebutton.click();
		Thread.sleep(2000);
		searchbox_vpngrpname.sendKeys(vpngrpname);
		searchicon_vpngrpname.click();
		Thread.sleep(5000);
		
	}
}