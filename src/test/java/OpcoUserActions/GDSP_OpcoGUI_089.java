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

public class GDSP_OpcoGUI_089 {
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

	@FindBy(xpath="//a[contains(@href,'popup_sim_packet_data.htm?')]")
	public static WebElement popup_simpacketdata;
	//popup_sim_connection_data_cs_usage.htm?simId=100200236125&simIdentifier=210000000502002
	
	@FindBy(xpath="//a[contains(@href,'popup_sim_packet_data_radius_events.htm?')]")
	public static WebElement popup_simpacketdata_radiusevents;
	//popupinfo
	@FindBy(xpath="//div[@id='popup']/div/table[2]/tbody/tr/td")
	public static WebElement radiusevents_table;
	
	
	

	//popup_sim_details.htm?simId=100200236125





	public static WebDriver driver;

	public GDSP_OpcoGUI_089(WebDriver driver)
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
		popup_simpacketdata.click();
		Thread.sleep(3000);
		popup_simpacketdata_radiusevents.click();
		Thread.sleep(3000);
		try
		{
			if(radiusevents_table.getText().contains("No Recent RADIUS-Events data"))
			{
		System.out.println("no details are present");
			
					test.log(Status.INFO, "recent radius-events details has been displayed successfully and contains no data");

					String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath1);
					System.out.println("recent radius-events details has been displayed successfully and contains no data");
					test.log(Status.PASS,"recent radius-events details has been displayed successfully and contains no data");

				}
			else {
				
				System.out.println("details are present");
				
				test.log(Status.INFO, "recent radius-events details has been displayed successfully");

				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				System.out.println("recent radius-events has been displayed successfully");
				test.log(Status.PASS,"recent radius-events details has been displayed successfully");

			}
			}
		
		catch(Exception e)
		{	
			test.log(Status.INFO, "recent radius-events details has not been updated successfully");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			System.out.println("recent radius-events details has not been updated successfully");
			test.log(Status.FAIL,"recent radius-events details has not been updated successfully");
		}


	}
}


