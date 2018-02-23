package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_094 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='indexOpCoSims.htm']")
	public static WebElement ManageSims_Opco;
	
	@FindBy(xpath="//a[@href='manage_sim_order_overview.htm']")
	public static WebElement SimManufacturerOrder_ManageSims;
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement CustomerCodes_SimManufacturerOrder;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement Search_CustomerCodes;
	
	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageContacts;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_ManageSims;
	

	public static WebDriver driver;

	public GDSP_OpcoGUI_094(WebDriver driver)
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
	
	public void searchSimManufacturerOrder(String Customercode, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageSims_Opco.click();
		SimManufacturerOrder_ManageSims.click();
		CustomerCodes_SimManufacturerOrder.sendKeys(Customercode);
		Thread.sleep(2000);
		List<WebElement> allOptions =dropdown_ManageContacts.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) 
		{
			WebElement ele = i.next();
			if (ele.getText().equals(Customercode)) 
			{
				ele.click();
				Thread.sleep(3000);
				
			}

		}
	
		Search_CustomerCodes.click();
	

try
{
		if((Usertable_ManageSims.getText()).contains(Customercode))
		{
			
			test.log(Status.PASS, "Sims search results data found");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,2650)", "");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			System.out.println("sims search results data found");
		}
}
	catch(Exception e)
		{	
			test.log(Status.INFO, "Sims result no data for the created user");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("Sims result no data  for the created user");
			test.log(Status.FAIL, "Sims search results no data FOUND");
		}

		
		
		
		
		
	}
	
	
	

}

