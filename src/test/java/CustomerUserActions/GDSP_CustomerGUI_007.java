package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_007 {
	@FindBy(name="login.userId")
	public static WebElement Customer_uname;

	@FindBy(id="submit")
	public static WebElement CustomerLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Customer_Pass;

	@FindBy(id="submit")
	public static WebElement CustomerPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_sims_overview_filter.htm']")
	public static WebElement ManageSims_Customer;
	
	@FindBy(xpath="//a[@href='manage_sims_overview_search.htm']")
	public static WebElement Simsearch_Managesims;
	
	@FindBy(name="searchForm.simIDSelections")
	public static WebElement TextField_Imsi_simsearch;
	
	@FindBy(name="searchSubmit")
	public static WebElement searchbutton_simsearch;
	
	@FindBy(id="newtable")
	public static WebElement Simsearchtable_Managesims;
	
	public static WebDriver driver;

	public GDSP_CustomerGUI_007(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login( String Username, String Password,com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		Customer_uname.sendKeys(Username);
		CustomerLogin_Button.click();
		Customer_Pass.sendKeys(Password);
		CustomerPassword_Button.click();
		test.log(Status.INFO, "logged in successfully");
	}
	public void searchSIMcustomers(String imsi,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
		
	{	
		
		ManageSims_Customer.click();
		Simsearch_Managesims.click();
		TextField_Imsi_simsearch.sendKeys(imsi);
		searchbutton_simsearch.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2650)", "");

		Thread.sleep(5000);


		test.log(Status.INFO,"Scroll down has been done");
		try
		{
		if((Simsearchtable_Managesims.getText()).contains(imsi))
		{ 
			JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			jse1.executeScript("window.scrollBy(0,450)", "");
			test.log(Status.INFO, "Sim search Results  data  found");
			System.out.println("sim search results  data found");
			test.log(Status.PASS, "SIM search results  data found");

			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
		}
		}
		catch(Exception e)
		{              
			test.log(Status.INFO, "SIM search results no data found");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			System.out.println("SIM search results no data found");
			test.log(Status.FAIL, "SIM search results no data found");
		}
	}

		
		
		
		
		
		
		
		
		
	}

