package CustomerUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_028 
	
{
	@FindBy(name="login.userId")
	public static WebElement Customer_uname;

	@FindBy(id="submit")
	public static WebElement CustomerLogin_Button;

	@FindBy(name="login.password")
	public static WebElement Customer_Pass;

	@FindBy(id="submit")
	public static WebElement CustomerPassword_Button;

	@FindBy(xpath="//a[@href='manage_sims_overview_filter.htm']")
	public static WebElement Managsims_Customer;

	@FindBy(name="filterServiceProfileList")
	public static WebElement checkboxrandomsp_Managsims;
	
	@FindBy(id="submit")
	public static WebElement applyfilter_Button;

	@FindBy(id="newtable")
	public static WebElement tablesimdetails_sims;
	
	

	

	public static WebDriver driver;

	public GDSP_CustomerGUI_028(WebDriver driver)
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
	public void Numberofsimsinacsp(String imsi,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Managsims_Customer.click();
		checkboxrandomsp_Managsims.click();
		
		applyfilter_Button.click();
		
		
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(imsi)));
		
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,450)", "");
		try
		{
		
			
				if(tablesimdetails_sims.getText().contains(imsi))
				{
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				test.log(Status.INFO,"sims details   displayed as per the filter successfully");
				System.out.println("sims details   displayed as per the filter successfully");
				test.log(Status.PASS,"sims details   displayed as per the filter successfully");
			}
				else
				{
					test.log(Status.INFO,"sims details   displayed as per the filter successfully but imsi is not there");
					System.out.println("sims details   displayed as per the filter successfully but imsi is not there");
				}
		}
		
		catch(Exception e)
		{
			
			test.log(Status.INFO,"sims details  are not  displayed as per the filter successfully");
			String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath);
			System.out.println("sims details  are not  displayed as per the filter successfully");
			test.log(Status.FAIL,"sims details  are not displayed as per the filter successfully");
		}
		
	}
	
}

