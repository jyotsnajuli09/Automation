package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import DBOpco.DatabaseOpco;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_103 {
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
	
	@FindBy(xpath="//a[contains(text(),'Copy')]")
	public static WebElement copyicon_vpngrpname;
	
	//@FindBy(xpath="//input[@id='submitforMozila']")
	//public static WebElement  createbutton_ManageVPNs;
	
	@FindBy(xpath="//input[@name='vpnGroup.vpnGroupName']")
	public static WebElement  VPNgroupnametextbox_createnewvpngrp;
	
	@FindBy(xpath="//input[@name='vpnGroup.vpnGroupDesc']")
	public static WebElement  VPNgroupdesctextbox_createnewvpngrp;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement savebutton;
	
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;
	
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_103(WebDriver driver)
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
	public void vpncopy(String customercode,String vpngrpname,String newvpngrpname,String vpnnewdesc,com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageVPNs_Opco.click();
		Select dropDown = new Select (driver.findElement(By.name("customerId")));
		dropDown.selectByVisibleText(customercode);
		
		searchbox_vpngrpname.sendKeys(vpngrpname);
	
		searchicon_vpngrpname.click();
		Thread.sleep(3000);
		copyicon_vpngrpname.click();
		VPNgroupnametextbox_createnewvpngrp.clear();
		VPNgroupnametextbox_createnewvpngrp.sendKeys(newvpngrpname);
		VPNgroupdesctextbox_createnewvpngrp.clear();
		VPNgroupdesctextbox_createnewvpngrp.sendKeys(vpnnewdesc);
		Thread.sleep(3000);
		String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath4);
		
		savebutton.click();
		Thread.sleep(2000);
		ManageVPNs_Opco.click();
		Thread.sleep(4000);
		
		searchbox_vpngrpname.sendKeys(newvpngrpname);
		searchicon_vpngrpname.click();
		try
		{
			if((usertable_ManageVPNs.getText()).contains(newvpngrpname))
			{
				test.log(Status.INFO, "  copy of vpn is successfully done ");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				System.out.println("copy of vpn is successfully done");
				test.log(Status.PASS, "  copy of vpn is successfully done ");
				DatabaseOpco.tc103(newvpngrpname);
				System.out.println("Deletion of copied  vpn is done successfully");
			}
			}
		catch(Exception e)
		{
			test.log(Status.INFO, "  copy of vpn is not successfully done ");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			Thread.sleep(2000);
			System.out.println("copy of vpn is not successfully done");
			test.log(Status.FAIL, "  copy of vpn is not successfully done ");
		
		}
		
	}
}



