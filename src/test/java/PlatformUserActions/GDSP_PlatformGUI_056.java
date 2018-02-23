package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_056 {

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

	@FindBy(xpath="//a[contains(text(),'Edit Billing')]")
	public static WebElement EditBillingConfiguration_ManageOpCos;

	@FindBy(id="submit")
	public static WebElement save_EditBillingConfiguration;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_EditBillingConfiguration;

	//  xpath="//*[@id='imsiFrom'][@value='407000']/following::td[1]"

	public static WebDriver driver;

	public GDSP_PlatformGUI_056(WebDriver driver)
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

	public void searchOpco(String OpcoCode,com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException
	{
		ManageOpCos_PlatformTab.click();
		OpCoCodeSeachBox_ManageOpCos.sendKeys(OpcoCode);
		OpCoCodeSeachIcon_ManageOpCos.click();
		try{
			if((OpCoTable_ManageOpCos.getText()).contains(OpcoCode))
			{
				test.log(Status.INFO, "Search for given opco is suceesful");
				System.out.println("Search for given opco is suceesful");
			}	
		}	
		catch(Exception e)
		{
			test.log(Status.INFO, "Search for given opco is not found");
			System.out.println("Search RESULT for given opco is not found");
		}

	}

	public void editBillingConfiguration(String IMSIRange,String OpcoCode, com.aventstack.extentreports.ExtentTest test,String tcid) throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{
		try{
			if(EditBillingConfiguration_ManageOpCos.isDisplayed())
			{
				test.log(Status.INFO, "Edit Billing Configuration option is present");
				EditBillingConfiguration_ManageOpCos.click();
				System.out.println("IMSIRange is" + IMSIRange);
				/*
			if IMSIRange= 100000, name=15
			if IMSIRange= 200000, name=11
			if IMSIRange= 262049, name=3
			if IMSIRange= 303210, name=4
				 */
				if(IMSIRange.equals(100000))
				{
					driver.findElement(By.xpath("//input[@name='15']")).click();
				}
				else if (IMSIRange.equals(200000)) 
				{
					driver.findElement(By.xpath("//input[@name='11']")).click();
				}
				else if(IMSIRange.equals(262049)) 
				{
					driver.findElement(By.xpath("//input[@name='3']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//input[@name='4']")).click();
				}
				Thread.sleep(6000);
				// driver.findElement(By.xpath("//*[@id='imsiFrom'][@value=100000]/following::td[1]")).click();
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);	
				save_EditBillingConfiguration.click();

				Database.tc056(OpcoCode);
				test.log(Status.INFO, "Db has been verified");

				try{
					if(validationMesaage_EditBillingConfiguration.isDisplayed()){
						if(validationMesaage_EditBillingConfiguration.getText().contains("error"))
						{
							test.log(Status.INFO, validationMesaage_EditBillingConfiguration.getText());
							test.log(Status.FAIL, "Billing configuration does not edited successfully");
							String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath4);
						}
					}	

				}
				catch(Exception e1)
				{
					test.log(Status.PASS,"Edit BSG is successful");
				}

			}}

		catch(Exception e)
		{
			test.log(Status.INFO, "Edit Billing Configuration option is not displayed");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);	
			test.log(Status.FAIL, "EDIT is not successful");
		}
	}




}




