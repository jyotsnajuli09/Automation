package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import DB.Database;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_046 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_plmn_list_overview.htm']")
	public static WebElement ManagePLMNList_PlatformTab;

	@FindBy(name="formSearchValue")
	public static WebElement PLMNListNameSearchBox_ManagePLMNList;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement PLMNListNameSearchIcon_ManagePLMNList;

	@FindBy(id="overviewtable3")
	public static WebElement PLMNTable_ManagePLMNList;

	@FindBy(xpath="//a[contains(text(),'Delete')]")
	public static WebElement Delete_ManagePLMNList;

	@FindBy(xpath="//input[@value='Ok']")
	public static WebElement popup_ok;

	public static WebDriver driver;

	public GDSP_PlatformGUI_046(WebDriver driver)
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

	public void searchPLMNList(String Name, com.aventstack.extentreports.ExtentTest test , String tcid) throws IOException
	{	
		ManagePLMNList_PlatformTab.click();
		PLMNListNameSearchBox_ManagePLMNList.sendKeys(Name);
		PLMNListNameSearchIcon_ManagePLMNList.click();

		try{
			if(PLMNTable_ManagePLMNList.getText().contains(Name))
			{
				test.log(Status.INFO, " Search is successful for PLMN List");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
			}}
		catch(Exception e2)
		{
			test.log(Status.INFO, " Search is not found for created PLMN List");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
		}

	}

	public void deletePLMNList(String Name,String Reference,com.aventstack.extentreports.ExtentTest test , String tcid) throws InterruptedException
	{
		try{
			if(Delete_ManagePLMNList.isDisplayed())
			{
				Delete_ManagePLMNList.click();
				Thread.sleep(8000);
				Actions act = new Actions(driver);
				act.moveToElement(popup_ok).click().build().perform();
				test.log(Status.INFO, " PLMN List has been deleted successfully");
				Database.tc046(Name,Reference);
				System.out.println("deletion done from the database");
			}
		}
		catch(Exception e1)
		{
			test.log(Status.INFO, "Delete option is not available");	
		}
	}

}
