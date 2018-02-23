package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_124 {
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
	@FindBy(xpath="//input[@src='images/eye.png']")
	public static WebElement eyeiconienableinvisible_eventfilter;
    @FindBy(xpath="//input[@src='images/eyecrossedout.png']")
    public static WebElement eyeiconienablevisible_eventfilter;
	public static WebDriver driver;

	public GDSP_OpcoGUI_124(WebDriver driver)
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

		try
		{
			if((usertable_Manageevents.getText()).contains( eventname))
			{
				try{
					if(eyeiconienableinvisible_eventfilter.isDisplayed())
					{
						String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath2);
						eyeiconienableinvisible_eventfilter.click();

						try
						{
							if(eyeiconienablevisible_eventfilter.isDisplayed())
							{
								String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
								test.addScreenCaptureFromPath(screenShotPath4);
								test.log(Status.INFO, "clicked on crossed eye");
								test.log(Status.PASS, "visible of event is done successfully");
							}
						}

						catch(Exception e2)
						{
							String screenShotPath5=TakeScreenshot.captureScreen(driver,tcid);
							test.addScreenCaptureFromPath(screenShotPath5);
							test.log(Status.INFO, "not able to click on crossed eye");
							test.log(Status.FAIL, " crossed eye icon is still disabled");
						}
					}	
				}

				catch(Exception e3)
				{

					if(eyeiconienablevisible_eventfilter.isDisplayed())
					{
						eyeiconienablevisible_eventfilter.click();
						String screenShotPath6=TakeScreenshot.captureScreen(driver,tcid);
						test.addScreenCaptureFromPath(screenShotPath6);
						try
						{
							if(eyeiconienableinvisible_eventfilter.isDisplayed())
							{		
								String screenShotPath7=TakeScreenshot.captureScreen(driver,tcid);
								test.addScreenCaptureFromPath(screenShotPath7);
								test.log(Status.INFO, "clicked on visible eye");
								test.log(Status.PASS, "invisible of event done successfully");
							}


						}

						catch(Exception e2)
						{
							String screenShotPath8=TakeScreenshot.captureScreen(driver,tcid);

							test.addScreenCaptureFromPath(screenShotPath8);
							test.log(Status.INFO, "not able to click on eye");
							test.log(Status.FAIL, " eye icon  is still  disabled");
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
			System.out.println("visible/invisible of event can not done");
			test.log(Status.FAIL, "visible/invisible of event can not done");
		}
	}
}