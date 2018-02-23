package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_018 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_tariffs_overview.htm']")
	public static WebElement Managetariffs_Opco;



	@FindBy(xpath="//input[@name='formSearchValue']")
	public static WebElement Tariffnamessearchbox_Managetariffs;

	/*@FindBy(xpath="//button[@title='Show All Items']")
	public static WebElement TariffNamedropdown_Managetariffs;


	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageCustomers;*/


	//input[@src='images/search.png']
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_Managetariffs;

	@FindBy(id="overviewtable3")
	public static WebElement Usertable_Managetariffs;

	/*@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_ManageContacts;*/


	public static WebDriver driver;

	public GDSP_OpcoGUI_018(WebDriver driver)
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

	public void searchtariffs(String fullname, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		 Managetariffs_Opco.click();
		 Thread.sleep(3000);
	
		
		 Tariffnamessearchbox_Managetariffs.sendKeys(fullname);
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
		 searchIcon_Managetariffs.click();
		try{
		if(( Usertable_Managetariffs.getText()).contains(fullname))
		{
			test.log(Status.INFO, "Tariff Names search is successful");
			System.out.println("Tariff Names search is successful");
			/*JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			test.log(Status.INFO,"Scroll down has been done");

			BackToTop_ManageContacts.click();
			Thread.sleep(2000);
			test.log(Status.INFO,"Successfully clicked on Back to top button");*/
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
			test.log(Status.PASS, "Tariff Names search is successful");
		}
		}
		catch(Exception e)
		{              
			test.log(Status.INFO, "Tariffs has not been found for the created tariffs");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("Tariffs  has  not been found for the created tariffs");
			test.log(Status.FAIL, "Tariffs has not been found for the created tariffs");
		}






	}

}


