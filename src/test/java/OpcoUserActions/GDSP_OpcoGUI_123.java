package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_123 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_events_overview.htm']")
	public static WebElement Manageevents_Opco;



	@FindBy(name="formSearchValue2")
	public static WebElement eventSearchbox_Manageevent;

	@FindBy(id="overviewtable3")
	public static WebElement usertable_Manageevents;
	@FindBy(xpath="//td[input[@src='images/search.png']]/following-sibling::td[3]/input[@src='images/search.png']")
	public static WebElement Searchicon_eventfilter;

	@FindBy(xpath="//input[@src='images/tick.png']")
	public static WebElement enabledicon_eventfilter;

	@FindBy(xpath="//input[@src='images/cross.png']")
	public static WebElement disabledicon_eventfilter;

	public static WebDriver driver;

	public GDSP_OpcoGUI_123(WebDriver driver)
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
	public void eventfilter(String eventname, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		Manageevents_Opco.click();

		eventSearchbox_Manageevent.sendKeys( eventname);
		Thread.sleep(2000);
		Searchicon_eventfilter.click();
		Thread.sleep(3000);
		
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Thread.sleep(3000);
		try
		{
			if((usertable_Manageevents.getText()).contains( eventname))
			{
				try{
					if(enabledicon_eventfilter.isDisplayed())
					{
						String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath4);
						
					Thread.sleep(3000);
					enabledicon_eventfilter.click();
						try
						{
							if(disabledicon_eventfilter.isDisplayed())
							{
								Thread.sleep(3000);
								String screenShotPath1=TakeScreenshot.captureScreen(driver,tcid);
								test.addScreenCaptureFromPath(screenShotPath1);
								Thread.sleep(2000);
								System.out.println("hiii3");
								test.log(Status.INFO, "clicked on enabled status");
								test.log(Status.PASS, "disabled successfully");
							}
						}

						catch(Exception e2)
						{ Thread.sleep(2000);
							String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath5);
							Thread.sleep(3200);
							test.log(Status.INFO, "not able to click on enabled status");
							test.log(Status.FAIL, " status is still  enabled");
						}
					}	
				}

				catch(Exception e3)
				{

					if(disabledicon_eventfilter.isDisplayed())
					{
						disabledicon_eventfilter.click();
						Thread.sleep(3000);
						String screenShotPath6=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath6);
						Thread.sleep(2000);
						try
						{
							if(enabledicon_eventfilter.isDisplayed())
							{	Thread.sleep(2000);	
								String screenShotPath7=TakeScreenshot.captureScreen(driver,tcid);
								test.addScreenCaptureFromPath(screenShotPath7);
								Thread.sleep(2000);
								test.log(Status.INFO, "clicked on disabled status");
								test.log(Status.PASS, "enabled successfully");
							}


						}

						catch(Exception e2)
						{
							String screenShotPath8=TakeScreenshot.captureScreen(driver,tcid);

							test.addScreenCaptureFromPath(screenShotPath8);
							test.log(Status.INFO, "not able to click on disabled status");
							test.log(Status.FAIL, " status is still  disabled");
							System.out.println("hiii");
						}	

					}


				}

			}	

		}


		catch(Exception e1)
		{	
			test.log(Status.INFO, "search is not successfull");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("enabled/disabled is not done");
			test.log(Status.FAIL, "enabled/disabled can not be done");
		}

		}
}








