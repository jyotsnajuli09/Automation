package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_040 {




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
	
    @FindBy(xpath="//a[@href='manage_sp_paged_overview.htm']")
    public static WebElement customerserviceprofiles_Managecustomers;

	@FindBy(xpath="//input[@name='formSearchValue']")
	public static WebElement Profilenamessearchbox_Manageserviceprofiles;

	/*@FindBy(xpath="//button[@title='Show All Items']")
	public static WebElement TariffNamedropdown_Managetariffs;


	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageCustomers;*/


	//input[@src='images/search.png']
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_Manageserviceprofiles;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_Managetariffs;

	/*@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_ManageContacts;*/


	public static WebDriver driver;

	public GDSP_OpcoGUI_040(WebDriver driver)
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

	public void searchprofiles(String fullname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();
		 Thread.sleep(3000);
	
		 customerserviceprofiles_Managecustomers.click();
		 Thread.sleep(2000);
		 Profilenamessearchbox_Manageserviceprofiles.sendKeys(fullname);
		Thread.sleep(2000);
		
		searchIcon_Manageserviceprofiles.click();
		try{
			
		if(( Usertable_Managetariffs.getText()).contains(fullname))
		{
			test.log(Status.INFO, "profile Names search is successful");
			System.out.println("profile  Names search is successful");
		
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			
			Thread.sleep(2000);
			test.log(Status.PASS, "profile Names search is successful");
		}
		}
		catch(Exception e)
		
		{              
			test.log(Status.INFO, "Tariffs has not been found for the created tariffs");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("Tariffs  has  not been found for the created tariffs");
			test.log(Status.FAIL, "profile Names search is successful");

		}






	}

}


	
	
	

