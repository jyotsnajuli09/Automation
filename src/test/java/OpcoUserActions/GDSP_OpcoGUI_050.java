package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_050 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement Managecustomers_Opco;
	
	@FindBy(xpath="//a[@href='manage_imsi_range_overview.htm']")
	public static WebElement Imsi_range_ManageimsiRange;
	
	@FindBy(xpath="//input[@name='formSearchValue']")
	public static WebElement Searchbox_NextAvailableimsi;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_NextAvailableIMSI;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageimsiRange;

	/*@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_ManageContacts;*/


	public static WebDriver driver;

	public GDSP_OpcoGUI_050(WebDriver driver)
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

	public void searchIMSIranges(String fullname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();
		 Thread.sleep(3000);
	
		 Imsi_range_ManageimsiRange.click();
		 Thread.sleep(2000);
		 Searchbox_NextAvailableimsi.sendKeys(fullname);
		Thread.sleep(2000);
		//ContactNamedropdown_ManageContacts.click();
		// Thread.sleep(10000);

		/*List<WebElement> allOptions =dropdown_ManageCustomers.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(fullname)) 
			{
				ele.click();
				Thread.sleep(5000);
			}

		}*/
		searchIcon_NextAvailableIMSI.click();
		try{
		if(( Usertable_ManageimsiRange.getText()).contains(fullname))
		{
			test.log(Status.INFO, "Next availableIMSI ranges search is successful");
			System.out.println("Next availableIMSI ranges is successful");
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			test.log(Status.INFO,"Scroll down has been done");

			BackToTop_ManageContacts.click();
			Thread.sleep(2000);
			test.log(Status.INFO,"Successfully clicked on Back to top button");*/
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
			test.log(Status.PASS, "Next availableIMSI ranges search is successful");
		}
		}

		catch(Exception e)
		{              
			test.log(Status.INFO, "Next availableIMSI ranges has not been found for the imsi ranges");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("Next availableIMSI ranges has not been found for the imsi ranges");
			test.log(Status.FAIL, "Next availableIMSI ranges has not been found for the imsi ranges");
		}






	}

}


	
	
	


	
	


