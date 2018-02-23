package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_141 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_apn_overview.htm']")

	public static WebElement Network_Opco;
	
	
	@FindBy(name="formSearchValue")
	public static WebElement apnfilter_searchbox;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_apnfilter;
	

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement edit_apn;
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement savebutton_editnetworktrace;
	
	@FindBy(xpath="//a[@href='logout.htm?logoutType=O']")
	public static WebElement logout_opco;
	
	@FindBy(xpath="//a[@href='manage_ggsn_overview.htm']")
	public static WebElement managesystem_platform;
	
	@FindBy(xpath="//a[@href='manage_apn_overview.htm']")
	public static WebElement apnprofiles_manageapn;
	
	@FindBy(name="formSearchValue")
	public static WebElement apnprofilename_searchbox;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_apnprofile;
	
	@FindBy(xpath="//div[@class='tablewrapper pc70']")
	public static WebElement table_apnname;
	
	//div[@class='tablewrapper pc70']
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_141(WebDriver driver)
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
	public void editnetworktrace( String apnname,String tracing,String extendtraceby, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Network_Opco.click();
		Thread.sleep(2000);
		apnfilter_searchbox.sendKeys(apnname);
		searchicon_apnfilter.click();
		edit_apn.click();
		Select dropdown =new Select(driver.findElement(By.name("apnProfile.traceTypeR")));
		dropdown.selectByVisibleText(tracing);
		
		Select dropdown1 =new Select(driver.findElement(By.name("extendTraceBy")));
		dropdown1.selectByVisibleText(extendtraceby);
		savebutton_editnetworktrace.click();
		
		logout_opco.click();
		platform_uname.sendKeys("GLOBAL4");
		platformLogin_Button.click();
		platform_Pass.sendKeys("Secret123");
		platformPassword_Button.click();
		managesystem_platform.click();
		apnprofiles_manageapn.click();
		apnprofilename_searchbox.sendKeys(apnname);
		searchicon_apnprofile.click();
		
		try{
			
		if(table_apnname.getText().contains(tracing))
		{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3050)", "");
		test.log(Status.INFO,"successfully edited apn");
		String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath1);	
		System.out.println("successfully edited apn");
		test.log(Status.PASS,"successfully edited apn");
		}
		}
		catch(Exception e)
		{
			test.log(Status.INFO,"edit of apn is not done successfully ");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			System.out.println("edit of apn is not done successfully");
			test.log(Status.FAIL,"edit of apn is not done successfully");
		}
		
		
		
		
		
		
		
	}
		
		
}
