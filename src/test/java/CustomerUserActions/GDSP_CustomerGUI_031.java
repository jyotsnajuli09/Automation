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

import com.aventstack.extentreports.Status;



public class GDSP_CustomerGUI_031 
	
	
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

	@FindBy(xpath="//a[text()='Search SIMs']")
	public static WebElement searchsims_managesims;
	
	//a[text()='SIM History']
	
	@FindBy(xpath="//a[text()='SIM History']")
	public static WebElement simhistory_simdetailspopup;
	
	@FindBy(id="submit")
	public static WebElement applyfilter_Button;

	@FindBy(id="newtable")
	public static WebElement tablesimdetails_sims;
	
	
	@FindBy(name="searchForm.simIDSelections")
	public static WebElement searchform_imsi;
	
	@FindBy(name="searchSubmit")
	public static WebElement searchbutton_searchsims;
	
	@FindBy(id="popup")
	public static WebElement simdetails_table;
	

	public static WebDriver driver;

	public GDSP_CustomerGUI_031(WebDriver driver)
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
	public void searchthroughimsi(String imsi,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{
		Managsims_Customer.click();
		
		searchsims_managesims.click();
		
		 searchform_imsi.sendKeys(imsi);
		 
		 searchbutton_searchsims.click();
		
		
		
		
		
		 JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			jse1.executeScript("window.scrollBy(0,1650)", "");

			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(imsi)));
			Thread.sleep(3000);
		try
		{
		
			
				if(tablesimdetails_sims.getText().contains(imsi))
				{
					
					
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				driver.findElement(By.linkText(imsi)).click();
				Thread.sleep(2000);
			    driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
				//driver.switchTo().frame("cbox1500043633744");
			    //String test1 = "Screen1";
			   
				int size = driver.findElements(By.tagName("iframe")).size();
				System.out.println(size);
				
				
				if(simdetails_table.isDisplayed())
				{
					String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath1);
				test.log(Status.INFO,"sims details are searched by imsi and navigated to nexpage successfully");
				System.out.println("sims details are searched by imsi and navigated to nexpage successfully");
				test.log(Status.PASS,"sims details are searched by imsi and navigated to nexpage successfully");
				Thread.sleep(3000);
				
				simhistory_simdetailspopup.click();
				
			}
				}
		}
		
		catch(Exception e)
		{
			
			test.log(Status.INFO,"navigation is not successful");
			String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath);
			System.out.println("navigation is not successful");
			test.log(Status.FAIL,"navigation is not successful");
		}
		
	}
}
