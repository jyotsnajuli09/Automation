package PlatformUserActions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_036 {
	
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
	
	@FindBy(xpath="//a[@href='manage_throttling_overview.htm?fromPage=ManageSystem']")
	public static WebElement Throttling_ManageSystemTab;
	
	//a[contains(text(),'Edit')]
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_ConfigureAPIThrottling;
	
	@FindBy(name="systemThrottling.systemMaxApiCount")
	public static WebElement CallLimit_EditAPIThrottling;
	
	@FindBy(name="systemThrottling.systemPeriodLength")
	public static WebElement Period_EditAPIThrottling;
	
	@FindBy(id="submit")
	public static WebElement Save_EditAPIThrottling;
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_EditAPIThrottling;
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	public static WebElement Delete_ConfigureAPIThrottling;
	
	@FindBy(xpath="//input[@value='Ok']")
	public static WebElement popup_ok;

	
	public static WebDriver driver;

	public GDSP_PlatformGUI_036(WebDriver driver)
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
	
	
	public void editAPIThrottling(String CallLimit,String Period,com.aventstack.extentreports.ExtentTest test,String tcid) throws InterruptedException, IOException
	{
		ManageSystem_PlatformTab.click();
		Throttling_ManageSystemTab.click();
		Edit_ConfigureAPIThrottling.click();
		CallLimit_EditAPIThrottling.clear();
		CallLimit_EditAPIThrottling.sendKeys(CallLimit);
		Select period= new Select(Period_EditAPIThrottling);
		period.selectByIndex(1);
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);	
		Save_EditAPIThrottling.click();
		System.out.println("sdfghj");
		try{
			if(validationMesaage_EditAPIThrottling.isDisplayed()){
				if(validationMesaage_EditAPIThrottling.getText().contains("error"))
				{
					test.log(Status.INFO, validationMesaage_EditAPIThrottling.getText());
					test.log(Status.FAIL, "API Throttling not edited successfully");
					String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath4);
					System.out.println("sdfghjk");
				}
			}	

		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "API has been edited successfully");
			test.log(Status.PASS,"Edit API is successful");
			System.out.println("sdfghjkl");
		}
		
	}
	
	public void deleteAPIThrottling(com.aventstack.extentreports.ExtentTest test,String tcid)
	{
		try{
		if(Delete_ConfigureAPIThrottling.isDisplayed())
		{
		Delete_ConfigureAPIThrottling.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.name("ok"))).click().perform();
		String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath5);
		test.log(Status.INFO, "API has been deleted successfully");
		test.log(Status.PASS, "edit and delete has been done successfully");
		System.out.println("sdfghjkghk");
		System.out.println("delete has been done successfully");
		}
		}
		catch(Exception e)
		{
			test.log(Status.INFO, "Delete option is not available");
			test.log(Status.FAIL, "delete action has not completed");
			System.out.println("sd");
		}
	}
	
	
	
	
	
	
}
