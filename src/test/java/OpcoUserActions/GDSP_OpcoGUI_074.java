package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.security.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_074 {
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
	
	@FindBy(id="searchForm.simIDSelections")
	public static WebElement simidsearchform_ManageSIMS;

	@FindBy(xpath="//*[@id='submitNew']")
	public static WebElement Search_SIM;

	@FindBy(xpath="//input[@name='simCheckBox1']")
	public static WebElement selectcheckbox_SIMs;

	@FindBy(xpath="//*[@id='submitActionButton']")
	public static WebElement submit_actions;
	@FindBy(xpath="//input[@name='cancel']")
	public static WebElement cancle_diagnostictrace;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_Actionsonsim;
	@FindBy(id="cboxLoadedContent")
	public static WebElement simregtable_actiontsim;
	
@FindBy(xpath="//a[contains(@href,'popup_sim_registration_data.htm')]")
public static WebElement popup_simregistrationdata;
//popup_sim_details.htm?simId=100200236125
@FindBy(xpath="//a[contains(text(),'SIM Details')]")
public static WebElement simdetails_simregistrationdata;

	public static WebDriver driver;

	public GDSP_OpcoGUI_074(WebDriver driver)
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
	public void selectactiononSIMs(String simid,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		ManageSIMs_Opco.click();
		Thread.sleep(2000);
		
		simidsearchform_ManageSIMS.sendKeys(simid);
		Search_SIM.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2650)", "");
		
		WebDriverWait wait = new WebDriverWait(driver,180); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(simid)));
		driver.findElement(By.linkText(simid)).click();
		Thread.sleep(4000);
	    driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		//driver.switchTo().frame("cbox1500043633744");
	    //String test1 = "Screen1";
	    String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath1);
		popup_simregistrationdata.click();
		Thread.sleep(3000);
		try
		{
			if(simdetails_simregistrationdata.isDisplayed())
				
				
			{

	


				test.log(Status.INFO, "simregistrationdata page has been displayed successfully");
			    //String test2 = "Screen2";
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				System.out.println("simregistrationdata page has been displayed successfully");
				test.log(Status.PASS,"simregistrationdata page has been displayed successfully");
				
				}
			
		}
		catch(Exception e)
		{	
			test.log(Status.INFO, "simregistrationdata page has not  been displayed successfully");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			System.out.println("simregistrationdata page has not been displayed successfully");
			test.log(Status.FAIL, " simregistrationdata page has not been displayed successfully");
		}


	}
}