package PlatformUserActions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DB.Database;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_022 {


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

	@FindBy(xpath="//a[@href='manage_ggsn_overview.htm'][contains(text(),'AAA Clients')]")
	public static WebElement AAAClient_ManageAAAClients;

	@FindBy(name="formSearchValue")
	public static WebElement AAAClientNameSearchtextBox_ManageAAAClients;

	//input[@src='images/search.png']
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_ManageAAAClients;

	@FindBy(xpath="//a[contains(text(),'Edit')]")
	public static WebElement Edit_ManageAAAClients;

	@FindBy(name="ggsn.AAAClientName")
	public static WebElement Name_EditAAAClientDetails;

	@FindBy(name="ggsn.countryId")
	public static WebElement Country_EditAAAClientDetails;

	@FindBy(name="ggsn.AAAClientDiameterIPAddress")
	public static WebElement DiameterIPAdress_EditAAAClientDetails;

	@FindBy(name="ggsn.AAAClientRadiusIPAddress")
	public static WebElement RadiusIPAdress_EditAAAClientDetails;

	@FindBy(name="ggsn.AAAClientRadiusSecret")
	public static WebElement RadiusSecret_EditAAAClientDetails;

	@FindBy(id="ggsn.AAAClientType")
	public static WebElement AAAClientType_EditAAAClientDetails;

	@FindBy(id="overviewtable3")
	public static WebElement AAAClientTable_ManageAAAClients;

	@FindBy(id="submit")
	public static WebElement Save_EditAAAClientDetails;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_ManageAAAClients;

	public static WebDriver driver;

	public GDSP_PlatformGUI_022(WebDriver driver)
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

	public void searchAAA(String Name,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		ManageSystem_PlatformTab.click();
		AAAClient_ManageAAAClients.click();
		AAAClientNameSearchtextBox_ManageAAAClients.sendKeys(Name);
		searchIcon_ManageAAAClients.click();
		try{
			if(AAAClientTable_ManageAAAClients.getText().contains(Name))
			{
				test.log(Status.INFO, "search has been found");
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO, "search has not found");
		}


	}

	public void editAAA(String Name,  String Country, String AAA_Client_Type, String DIAMETER_IP_Address, String RADIUS_IP_Address, String RADIUS_Secret,com.aventstack.extentreports.ExtentTest test,String tcid) throws SQLException, ClassNotFoundException, InterruptedException, IOException
	{
		try{

			if(Edit_ManageAAAClients.isDisplayed()){
				Edit_ManageAAAClients.click();
				Name_EditAAAClientDetails.clear();
				Name_EditAAAClientDetails.sendKeys(Name);
				Select country=new Select(Country_EditAAAClientDetails);
				country.selectByVisibleText(Country);
				//Description_CreatenewAAAClient.sendKeys(arg0);
				Select client_type=new Select(AAAClientType_EditAAAClientDetails);
				client_type.selectByVisibleText(AAA_Client_Type);
				DiameterIPAdress_EditAAAClientDetails.clear();
				DiameterIPAdress_EditAAAClientDetails.sendKeys(DIAMETER_IP_Address);
				RadiusIPAdress_EditAAAClientDetails.clear();
				RadiusIPAdress_EditAAAClientDetails.sendKeys(RADIUS_IP_Address);
				RadiusSecret_EditAAAClientDetails.sendKeys(RADIUS_Secret);
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);	
				Save_EditAAAClientDetails.click();	
				try{
					if(validationMesaage_ManageAAAClients.isDisplayed()){
						if(validationMesaage_ManageAAAClients.getText().contains("error"))
						{
							test.log(Status.INFO, validationMesaage_ManageAAAClients.getText());
							test.log(Status.FAIL, "AAA Clients does not edited successfully");
							String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath3);
						}
					}	

				}
				catch(Exception e1)
				{
					test.log(Status.INFO, "edit has been done for given AAA");
					Database.tc022(Name);
					test.log(Status.PASS,"Edit BSG is successful");
				}

			}

		}

		catch(Exception e)
		{
			test.log(Status.INFO, "edit option is not there for given AAA");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			test.log(Status.FAIL, "EDIT is not successful since given AAA is not available");
		}
	}
}
