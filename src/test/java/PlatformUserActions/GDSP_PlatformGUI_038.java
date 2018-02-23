package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_038 {
	
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
	
	@FindBy(id="submit")
	public static WebElement Create_ManageOpCos;
	
	@FindBy(name="opCo.vfOpCoCode")
	public static WebElement OpcoCode_CreatenewOpCo;
	
	@FindBy(name="opCo.vfOpTadigCode")
	public static WebElement TadigCode_CreatenewOpCo;
	
	@FindBy(name="opCo.siteId")
	public static WebElement SiteIdentifier_CreatenewOpCo;
	
	@FindBy(name="opCo.contractingOpCo")
	public static WebElement ContractingOpCo_CreatenewOpCo;
	
	@FindBy(id="submit")
	public static WebElement save_CreatenewOpCo;
	
	@FindBy(name="formSearchValue")
	public static WebElement OpCoCodeSeachBox_ManageOpCos;
	
	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement OpCoCodeSeachIcon_ManageOpCos;
	
	@FindBy(id="overviewtable3")
	public static WebElement OpCoTable_ManageOpCos;
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement errormessage_CreatenewOpCo;
	

	
	
	public static WebDriver driver;

	public GDSP_PlatformGUI_038(WebDriver driver)
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
	
	public void createOpco(String OpcoCode, String TadigCode,com.aventstack.extentreports.ExtentTest test,String tcid)
	{
		ManageOpCos_PlatformTab.click();
		Create_ManageOpCos.click();
		OpcoCode_CreatenewOpCo.sendKeys(OpcoCode);
		TadigCode_CreatenewOpCo.sendKeys(TadigCode);
		Select dropdown = new Select(ContractingOpCo_CreatenewOpCo);
		dropdown.selectByIndex(1);
		Select dropdown1 = new Select(SiteIdentifier_CreatenewOpCo);
		dropdown1.selectByIndex(1);
		save_CreatenewOpCo.click();	
		try{
			if(errormessage_CreatenewOpCo.isDisplayed())
			{
				test.log(Status.INFO, errormessage_CreatenewOpCo.getText());
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				
			}
		}
		
		catch(Exception e)
		{
			test.log(Status.INFO, "New opco has been created");
		}
		
	}

	public void searchOpco(String OpcoCode,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, ClassNotFoundException, SQLException
	   {
		ManageOpCos_PlatformTab.click();
		OpCoCodeSeachBox_ManageOpCos.sendKeys(OpcoCode);
		OpCoCodeSeachIcon_ManageOpCos.click();
			
		if((OpCoTable_ManageOpCos.getText()).contains(OpcoCode))
		{
			test.log(Status.INFO, "Search for given opco is suceesful");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			System.out.println("Search for given opco is suceesful");
			Database.tc038(OpcoCode);
			test.log(Status.INFO, "DB has been verified");
			test.log(Status.PASS, "user creation and validation is successful");
		}		
		else
		{
			test.log(Status.INFO, "Search for given opco is not found");
			System.out.println("Search RESULT for given opco is not found");
	    }
	      
	  }

}
