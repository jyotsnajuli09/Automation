package OpcoUserActions;


import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_111 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_vpn_groups_overview.htm']")
	public static WebElement ManageVPNs_Opco;

	@FindBy(xpath="//a[@href='manage_vpn_number_lists_overview.htm']")
	public static WebElement NUMBERLISTS_ManageVPNs;


	@FindBy(name="formSearchValue")
	public static WebElement searchboxnumberlist_NUMBERLISTS;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_numberlists;

	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;

	@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_Managevpns;
	public static WebDriver driver;

	public GDSP_OpcoGUI_111(WebDriver driver)
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
	public void searchnamelist(String numberlistname , com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageVPNs_Opco.click();
		NUMBERLISTS_ManageVPNs.click();

		searchboxnumberlist_NUMBERLISTS.sendKeys(numberlistname);
		

		searchicon_numberlists.click();
		
		try
		{
			if((usertable_ManageVPNs.getText()).contains(numberlistname))
			{
				test.log(Status.INFO,"search is successful");
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("window.scrollBy(0,450)", "");

				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				BackToTop_Managevpns.click();

				String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath4);
				Thread.sleep(2000);
				test.log(Status.INFO, "back to top button is clicked successfully");
				test.log(Status.PASS,"successfully go to the top of the page");

			}			
		}
		catch(Exception e1)
		{	
			test.log(Status.INFO, "search is not successful");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("back to top button can not be clicked successfully");
			test.log(Status.FAIL, "go to the top of the page can not be done");
		}


	}
}
