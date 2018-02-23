package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_096 {
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
	
	@FindBy(xpath="//a[@href='manage_customer_order_overview.htm']")
	public static WebElement SIMcustomerorder_ManageSIMs;
	
	@FindBy(xpath="//a[contains(@href,'select')]")
	public static WebElement select_SIMcustomerorder;
	
	@FindBy(xpath="//a[contains(text(),'Select')]")
	public static WebElement select_csp;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement submit_simcustomerorder;
	@FindBy(xpath="//table[@id='overviewtable3']")
	public static WebElement tabledetail_customerorder;
	
	public static WebDriver driver;

	public GDSP_OpcoGUI_096(WebDriver driver)
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
	public void SIMCustomerOrder_Create(com.aventstack.extentreports.ExtentTest test, String tcid)throws IOException, AWTException, InterruptedException
	{
		ManageSIMs_Opco.click();
		Thread.sleep(2000);
		SIMcustomerorder_ManageSIMs.click();
		Thread.sleep(2000);
		select_SIMcustomerorder.click();
		Thread.sleep(2000);
		select_csp.click();
		Thread.sleep(2000);
		 submit_simcustomerorder.click();
		 
	try
	{
		if(driver.findElement(By.xpath("//p[@class='validationmessage']")).isDisplayed())
		{
			String errorMessage = driver.findElement(By.xpath("//p[@class='validationmessage']")).getText();
			test.log(Status.INFO, errorMessage);	

			if(errorMessage.contains("error"))
			{
				Thread.sleep(2000);
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				test.log(Status.FAIL, "sim order creation is not possible because of internal error");
				System.out.println("sim order creation is not possible because of internal error");
			}
		}
	}
		catch(Exception e)
		{
		if(tabledetail_customerorder.isDisplayed())
		{
			Thread.sleep(2000);
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			test.log(Status.PASS, "sim order creation is done successfully");
			System.out.println("sim order creation is done successfully");
		}
		}
	
	}
}
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

