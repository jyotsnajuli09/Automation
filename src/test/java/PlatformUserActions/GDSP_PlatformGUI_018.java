package PlatformUserActions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import genericLibrary.TakeScreenshot;

public class GDSP_PlatformGUI_018 {

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_platform_ops_details.htm']")
	public static WebElement ManageAccount_PlatformTab;

	@FindBy(xpath="//a[@href='manage_bsg_overview.htm']")
	public static WebElement BusinessServiceGroups_ManageBSG;

	@FindBy(id="submit")
	public static WebElement Create_ManageBSG;

	@FindBy(name="businessServiceGroup.businessServiceGroupName")
	public static WebElement Name_CreatenewBSG;

	@FindBy(name="businessServiceGroup.businessServiceGroupDesc")
	public static WebElement Description_CreatenewBSG;

	@FindBy(name="businessServiceGroup.accessClass")
	public static WebElement Class_CreatenewBSG;

	@FindBy(name="businessServiceGroup.businessServiceList4")
	public static WebElement BusinessServices_CreatenewBSG;

	@FindBy(id="submit")
	public static WebElement save_CreatenewBSG;

	@FindBy(id="cancel")
	public static WebElement cancel_CreatenewBSG;

	@FindBy(name="formSearchValue")
	public static WebElement GroupNameSearchtextBox_ManageBSG;

	@FindBy(xpath="//*[@src='images/search.png']")
	public static WebElement searchIcon_ManageBSG;

	@FindBy(id="overviewhead")
	public static WebElement errorMessage_ManageBSG;

	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_ManageBSG;

	@FindBy(id="overviewtable3")
	public static WebElement BSGTable_ManageBSG;

	public static WebDriver driver;
	public GDSP_PlatformGUI_018(WebDriver driver)
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

	public void createNewBSG(String name,  String description, String className,com.aventstack.extentreports.ExtentTest test,String tcid, String BSG) throws IOException
	{
		test.log(Status.INFO, "login is successful");
		ManageAccount_PlatformTab.click();
		BusinessServiceGroups_ManageBSG.click();		
		Create_ManageBSG.click();	
		Name_CreatenewBSG.sendKeys(name);
		Description_CreatenewBSG.sendKeys(description);	
		Select dropdown1 = new Select(Class_CreatenewBSG);
		dropdown1.selectByVisibleText(className);		
		Select dropdown2 = new Select(BusinessServices_CreatenewBSG);
		dropdown2.selectByVisibleText(BSG);
		save_CreatenewBSG.click();
		try{

			if(validationMesaage_ManageBSG.isDisplayed()){
				if(validationMesaage_ManageBSG.getText().contains("error"))
				{
					String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath2);
					test.log(Status.INFO, validationMesaage_ManageBSG.getText());
					String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath3);
					test.log(Status.FAIL, "creation is not successful because of error");
				}}


		}
		catch(Exception e1)
		{
			System.out.println("BSG has been created without any error message");
			test.log(Status.INFO, "creation of new BSG is successful");
			test.log(Status.PASS, "BSG creation is  successful ");		
		}
	}


	public void searchBSG(String name, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException
	{
		BusinessServiceGroups_ManageBSG.click();
		GroupNameSearchtextBox_ManageBSG.sendKeys(name);
		searchIcon_ManageBSG.click();
		try{
			if(BSGTable_ManageBSG.getText().contains(name))
			{
				test.log(Status.INFO, "BSG search is successful");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
			}
		}
		catch(Exception e)
		{
			test.log(Status.INFO, "BSG search is not found");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);

		}


	}


}
