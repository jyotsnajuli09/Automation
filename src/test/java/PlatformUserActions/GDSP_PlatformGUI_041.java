package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_041 {

	public String opcoAvailable;

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
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_EditOpCoDetails;

	@FindBy(xpath="//*[@id='cancel']")
	public static WebElement Cancel_EditOpCoDetails;

	@FindBy(xpath="//*[@id='leftcolsmall']")
	public static WebElement ManageOpcosText_ManageOpCos;


	public static WebDriver driver;

	public GDSP_PlatformGUI_041(WebDriver driver)
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

	public void searchOpco(com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException
	{
		ManageOpCos_PlatformTab.click();
		String opcoAvailable = driver.findElement(By.xpath("//*[@id='overviewtable3']/tbody/tr[2]/td[1]/a")).getText();
		OpCoCodeSeachBox_ManageOpCos.sendKeys(opcoAvailable);
		OpCoCodeSeachIcon_ManageOpCos.click();
		try{
			if((OpCoTable_ManageOpCos.getText()).contains(opcoAvailable))
			{
				test.log(Status.INFO, "Search for given opco is suceesful");
				System.out.println("Search for given opco is suceesful");
			}}		
		catch(Exception e)
		{
			test.log(Status.INFO, "Search for given opco is not found");	
			System.out.println("Search RESULT for given opco is not found");
		}      
	}

	public void editOpco(String TadigCode,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, ClassNotFoundException, SQLException
	{

		try{
			if( Edit_ManageOpCos.isDisplayed())
			{
				Edit_ManageOpCos.click();
				TadigCode_EditOpCoDetails.clear();
				TadigCode_EditOpCoDetails.sendKeys(TadigCode);
				Save_EditOpCoDetails.click();
				
				try{
					if(validationMesaage_EditOpCoDetails.isDisplayed()){
						if(validationMesaage_EditOpCoDetails.getText().contains("error"))
						{
							test.log(Status.INFO, validationMesaage_EditOpCoDetails.getText());
							test.log(Status.FAIL, "Opco does not edited successfully");
							String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath2);
						}
					}	

				}
				catch(Exception e1)
				{
					String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath2);
					Database.tc041(opcoAvailable);
					test.log(Status.INFO, "DB has been verified");
					test.log(Status.PASS,"Edit is successful");
				}
				
			}
		}

		catch(Exception e)
		{
			test.log(Status.INFO, "Edit option for given opco is not found");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			test.log(Status.FAIL, "EDIT is not successful since given opco is not available");
		}

	}

}
