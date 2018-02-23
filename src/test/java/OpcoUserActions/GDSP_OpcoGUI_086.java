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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_086 {
	//popup_sim_registration_data.htm?simId=9255258&simIdentifier=330000000000154
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

	@FindBy(xpath="//a[contains(@href,'popup_sim_registration_data.htm?')]")
	public static WebElement popup_simregddata;
	//popup_sim_connection_data_cs_usage.htm?simId=100200236125&simIdentifier=210000000502002
	
	@FindBy(xpath="//a[contains(@href,'popup_sim_registration_data.htm?')]")
	public static WebElement popup_updatesimregdinfos;
	//popupinfo
	@FindBy(xpath="//*[@id='popup1']/div/div[2]")
	public static WebElement popupinfo_upadatedetails;
	
	
	

	//popup_sim_details.htm?simId=100200236125





	public static WebDriver driver;

	public GDSP_OpcoGUI_086(WebDriver driver)
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
		jse.executeScript("window.scrollBy(0,3550)", "");

		WebDriverWait wait = new WebDriverWait(driver,180); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(simid)));
		JavascriptExecutor jse1= (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,2650)", "");
		driver.findElement(By.linkText(simid)).click();
		Thread.sleep(4000);
		driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		//driver.switchTo().frame("cbox1500043633744");
		String screenShotPath0=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath0);
		popup_simregddata.click();
		Thread.sleep(3000);
		popup_updatesimregdinfos.click();
		WebDriverWait wait1 = new WebDriverWait(driver,180); 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='popup1']/div/div[2]")));
		try
	    {
	    	if(driver.findElement(By.xpath("//div[@class='validationmessage']")).isDisplayed())
			{
				String errorMessage = driver.findElement(By.xpath("//div[@class='validationmessage']")).getText();
				test.log(Status.INFO, errorMessage);	

				if(errorMessage.contains("error"))
				{
					Thread.sleep(2000);
					String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath2);
					test.log(Status.FAIL, "update registration is not  done successfully due to some internal error");
					System.out.println("update registration is not  done successfully due to some internal error");
				}
			}
	    	
	    	
	    		
	    }
	catch(Exception e)
	    
	    {
		if( popupinfo_upadatedetails.isDisplayed())
		{
		test.log(Status.INFO,"update registration is done successfully");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Thread.sleep(2000);
		System.out.println("update registration is done successfully");
		test.log(Status.PASS, "update registration is done successfully");
		
	}
}

}
}