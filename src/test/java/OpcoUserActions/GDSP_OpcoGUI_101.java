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

public class GDSP_OpcoGUI_101 {
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
	public static WebElement searchbox_vpngrp;
	@FindBy(xpath="//input[@id='submitforMozila']")
	public static WebElement  createbutton_ManageVPNs;
	
	@FindBy(xpath="//input[@name='vpnGroup.vpnGroupName']")
	public static WebElement  VPNgroupnametextbox_createnewvpngrp;
	
	@FindBy(xpath="//input[@name='vpnGroup.vpnGroupDesc']")
	public static WebElement  VPNgroupdesctextbox_createnewvpngrp;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement savebutton;
	
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;
	
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_101(WebDriver driver)
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
	public void vpnbcreate(String customercode,String vpngrpname,String vpndesc,String custid,com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageVPNs_Opco.click();
		Select dropDown = new Select (driver.findElement(By.name("customerId")));
		dropDown.selectByVisibleText(customercode);
		createbutton_ManageVPNs.click();
		VPNgroupnametextbox_createnewvpngrp.sendKeys(vpngrpname);
		VPNgroupdesctextbox_createnewvpngrp.sendKeys(vpndesc);
		
		savebutton.click();
		Thread.sleep(3000);
		System.out.println("hii");
		searchbox_vpngrp.clear();
		searchbox_vpngrp.sendKeys(vpngrpname);
		driver.findElement(By.xpath("//input[@src='images/search.png']")).click();
		
		try
		{
			if(usertable_ManageVPNs.getText().contains(vpngrpname))
			{
				test.log(Status.INFO, "creation of newvpn is successfully done ");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				System.out.println("creation of newvpn is successfully done");
				test.log(Status.PASS, "  creation of newvpn is successfully done ");
				DatabaseOpco.tc101(vpngrpname);
				System.out.println("Deletion of vpn is done successfully");
				ManageVPNs_Opco.click();
				searchbox_vpngrp.clear();
				searchbox_vpngrp.sendKeys(vpngrpname);
				driver.findElement(By.xpath("//input[@src='images/search.png']")).click();
				
			}
			}
		catch(Exception e)
		{
			test.log(Status.INFO, "  creation of newvpn is not successfully done ");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			Thread.sleep(2000);
			System.out.println("creation of newvpn is not successfully done");
			test.log(Status.FAIL, "  creation of newvpn is not successfully done ");
		
		}
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	