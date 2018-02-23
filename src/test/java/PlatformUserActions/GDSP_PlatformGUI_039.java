package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_039 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_opco_overview.htm']")
	public static WebElement ManageOpCos_PlatformTab;

	@FindBy(name="formSearchValue")
	public static WebElement OpCoCodeSeachBox_ManageOpCos;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement OpCoCodeSeachIcon_ManageOpCos;

	@FindBy(id="overviewtable3")
	public static WebElement OpCoTable_ManageOpCos;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_ManageOpCos;

	@FindBy(name="opCo.vfOpTadigCode")
	public static WebElement TadigCode_EditOpCoDetails;

	@FindBy(xpath="//*[@id='submit']")
	public static WebElement Save_EditOpCoDetails;

	@FindBy(xpath="//*[@id='cancel']")
	public static WebElement Cancel_EditOpCoDetails;

	@FindBy(xpath="//*[@id='leftcolsmall']")
	public static WebElement ManageOpcosText_ManageOpCos;


	public static WebDriver driver;

	public GDSP_PlatformGUI_039(WebDriver driver)
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

	public void searchOpco(com.aventstack.extentreports.ExtentTest test,String tcid, String opcocode) throws IOException
	{
		ManageOpCos_PlatformTab.click();
		/*
		String opcoAvailable = driver.findElement(By.xpath("//*[@id='overviewtable3']/tbody/tr[2]/td[1]/a")).getText();
		OpCoCodeSeachBox_ManageOpCos.sendKeys(opcoAvailable);
		*/
		OpCoCodeSeachBox_ManageOpCos.sendKeys(opcocode);
		OpCoCodeSeachIcon_ManageOpCos.click();

		if((OpCoTable_ManageOpCos.getText()).contains(opcocode))
		{
			test.log(Status.INFO, "Search for given opco is suceesful");
			
			System.out.println("Search for given opco is suceesful");
		}		
		else
		{
			test.log(Status.INFO, "Search for given opco is not found");
			System.out.println("Search RESULT for given opco is not found");
		}      
	}

	public void editOpco(com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException
	{
		Edit_ManageOpCos.click();
		Cancel_EditOpCoDetails.click();
		if((ManageOpcosText_ManageOpCos.getText()).equalsIgnoreCase("Manage OpCos"))
		{
			System.out.println("Manage Opco page has been displayed successfully");
			test.log(Status.INFO, "Manage Opco page has been displayed successfully");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			test.log(Status.PASS, "Manage Opco page has been displayed successfully");
		}
		else
		{
			test.log(Status.INFO, "Manage Opco page has not been loaded");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);	
			test.log(Status.FAIL, "Manage Opco page has not been loaded");
		}
	}

}
