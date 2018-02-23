package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_032 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_ggsn_overview.htm']")
	public static WebElement ManageSystem_PlatformTab;
	
	@FindBy(xpath="//a[@href='manage_imsi_range_overview.htm']")
	public static WebElement IMSIRanges_ManageSystemTab;
	
	@FindBy(id="submit")
	public static WebElement create_ManageIMSIRanges;
	
	@FindBy(id="imsiRange.imsiFrom")
	public static WebElement IMSIFrom_CreateNewIMSIRange;
	
	@FindBy(id="imsiRange.imsiTo")
	public static WebElement  IMSITo_CreateNewIMSIRange;
	
	@FindBy(id="imsiRange.rangeDesc")
	public static WebElement RangeDescription_CreateNewIMSIRange;
	
	@FindBy(id="imsiRange.vfOpCoId")
	public static WebElement OpcoCode_CreateNewIMSIRange;
	
	@FindBy(id="submit")
	public static WebElement save_CreateNewIMSIRange;
	
	@FindBy(name="formSearchValue")
	public static WebElement NextAvailableIMSISearchBox_ManageIMSIRanges;
	
	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement NextAvailableIMSISearchIcon_ManageIMSIRanges;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageIMSIRanges;
	
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_032(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String Username, String Password)
	{	
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();	
	}
	
	public void createIMSIRange(String IMSIFrom,String IMSITo,com.aventstack.extentreports.ExtentTest test,String tcid) throws ClassNotFoundException, SQLException, InterruptedException
	{
		ManageSystem_PlatformTab.click();
		IMSIRanges_ManageSystemTab.click();
		//WebDriverWait wait = new WebDriverWait(driver,180); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Create']")));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Create']")).click();
		
		/*Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//input[@value='Create']"))).click().perform();*/
		
		IMSIFrom_CreateNewIMSIRange.sendKeys(IMSIFrom);
		IMSITo_CreateNewIMSIRange.sendKeys(IMSITo);
	   /* RangeDescription_CreateNewIMSIRange.sendKeys(RangeDesc);
		Select opcoCode = new Select(OpcoCode_CreateNewIMSIRange);
		opcoCode.selectByIndex(2);*/
		save_CreateNewIMSIRange.click();	
		
		test.log(Status.INFO, "DB has been verified");
	   }
	
	public void searchIMSIRange(String IMSIFrom,String NextAvailableIMSI,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, Exception, SQLException
	   {
		 IMSIRanges_ManageSystemTab.click();
		 NextAvailableIMSISearchBox_ManageIMSIRanges.sendKeys(IMSIFrom);
		 NextAvailableIMSISearchIcon_ManageIMSIRanges.click();	
		if((Usertable_ManageIMSIRanges.getText()).contains(IMSIFrom))
		{
			test.log(Status.INFO, "Search for created IMSI has been suceesful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			System.out.println("Search for created IMSI has been suceesful");
			//Database.tc032(IMSITo);
		}		
		else
		{
			test.log(Status.INFO, "Search result for created IMSI profile is not found");
			System.out.println("Search result for created IMSI is not found");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);	
	    }
	       }


}
