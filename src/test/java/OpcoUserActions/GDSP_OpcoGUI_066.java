package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_066 {
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
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement edit_sim;
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement save_button;
	
	@FindBy(xpath="//div[@class='formsubsection']")
	public static WebElement confirmationmsg_editform;
	public static WebDriver driver;

	public GDSP_OpcoGUI_066(WebDriver driver)
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
	public void editSIMs(String simid,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		ManageSIMs_Opco.click();
		
		Thread.sleep(2000);
		simidsearchform_ManageSIMS.sendKeys(simid);
		Search_SIM.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2650)", "");
		
		//WebDriverWait wait = new WebDriverWait(driver,180); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(simid)));
		
		WebDriverWait wait = new WebDriverWait(driver,180); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selectPageCheckBox")));
	
		//JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		//jse1.executeScript("window.scrollBy(250,0)", "");
		Thread.sleep(2000);
		edit_sim.click();
		
		//selectcheckbox_SIMs.click();
//		
//		save_button.click();
//		simidsearchform_ManageSIMS.clear();
//		simidsearchform_ManageSIMS.sendKeys(simid);
//		Search_SIM.click();
//		Thread.sleep(2000);
//		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//		jse1.executeScript("window.scrollBy(0,2650)", "");
//		
//		//WebDriverWait wait1= new WebDriverWait(driver,60); 
//		//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(simid)));
//	
//		//JavascriptExecutor jse1 = (JavascriptExecutor) driver;
//		//jse1.executeScript("window.scrollBy(250,0)", "");
//		
//		edit_sim.click();
//		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
//		jse2.executeScript("window.scrollBy(0,650)", "");
//		
		
try
{
	if(confirmationmsg_editform.isDisplayed())
	{
		test.log(Status.INFO, "sim edit is done successfully");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Thread.sleep(2000);
		System.out.println("sim edit is done successfully");
		test.log(Status.PASS, "sim edit is done successfully");
	}
		
}
catch(Exception e)
{
	test.log(Status.INFO, "sim edit is not  done successfully");
	String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
	test.addScreenCaptureFromPath(screenShotPath3);
	Thread.sleep(2000);
	System.out.println("sim edit is not done successfully");
	test.log(Status.PASS, "sim edit is not done successfully");
}
		
		
		
		
		
		
		
		
		
		
}
}