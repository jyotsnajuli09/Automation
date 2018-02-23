package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_150 {
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

	@FindBy(xpath="//a[@href='manage_processing_information.htm']")
	public static WebElement processinginfo_Network;

	@FindBy(name="formSearchValue")
	public static WebElement searchbox_KPIfilter;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_filter;
	@FindBy(id="overviewtable3")
	public static WebElement searchtable_processinginformation;
	public static WebDriver driver;

	public GDSP_OpcoGUI_150(WebDriver driver)
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

	public void custcodefilter( String  kpiname,String custcode,String custcodevalue,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Network_Opco.click();
		Thread.sleep(2000);
		processinginfo_Network.click();
		searchbox_KPIfilter.sendKeys(kpiname);
		searchicon_filter.click();
		driver.findElement(By.linkText(kpiname)).click();
		Select dropdown=new Select(driver.findElement(By.name("formSearchValue")));
		dropdown.selectByValue("324");
		searchicon_filter.click();
		Thread.sleep(2000);
	

		try{
			if(searchtable_processinginformation.getText().contains(custcode))
			{
				test.log(Status.INFO, "successfully get the data of customer successfully using filters." );
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				System.out.println("successfully get the data of customer successfully using filters");
				test.addScreenCaptureFromPath(screenShotPath2);
				test.log(Status.PASS,"successfully get the data of customer successfully using filters");
				Thread.sleep(2000);
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO," data of customer is not shown successfully using filters");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			System.out.println("data of customer is not shown successfully using filters");
			test.addScreenCaptureFromPath(screenShotPath3);
			test.log(Status.FAIL,"data of customer is not shown successfully using filters");	
		}

	}

}


