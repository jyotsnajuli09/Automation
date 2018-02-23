package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_095 {
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
	
	@FindBy(xpath="//a[@href='manage_sim_order_overview.htm']")
	public static WebElement SIMmanufactureorder_ManageSIMs;
	
	@FindBy(xpath="//*[@id='overviewtable3']/tbody/tr[3]/td[9]/a")
	public static WebElement clickoninvertedtriangle_SIMmanufactureorder;
	
	//@FindBy(css="body")
	//public static WebElement body_simorderfile;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_095(WebDriver driver)
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
	public void vieworder(String custcode,com.aventstack.extentreports.ExtentTest test, String tcid)throws IOException, AWTException, InterruptedException
	{
		ManageSIMs_Opco.click();
		SIMmanufactureorder_ManageSIMs.click();
		Thread.sleep(2000);
		clickoninvertedtriangle_SIMmanufactureorder.click();
		Thread.sleep(3000);
		
		
		String Parent = driver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		try
		{
	
	if(driver.getPageSource().contains(custcode))
	{
		test.log(Status.INFO, "  sim orders are successfully viewed ");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Thread.sleep(2000);
		System.out.println("sim orders are successfully viewed");
	}
		}
		
catch(Exception e)
	{              
		test.log(Status.INFO, "sim orders are  not found for the created customercode");
		String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath4);
		System.out.println("sim orders  not found for the created customercode");
	}
	driver.switchTo().window(Parent);
}
}