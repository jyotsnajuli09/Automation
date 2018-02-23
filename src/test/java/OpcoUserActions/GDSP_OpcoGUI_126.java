package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_126 {
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

	@FindBy(xpath="//a[@href='manage_outbound_web_services_overview.htm']")
	public static WebElement outboundwsc_ManageEvents;

	@FindBy(xpath="//input[@id='submit']")
	public static WebElement createbutton_notificationevents;

	@FindBy(name="webService.webServiceName")
	public static WebElement textfield_endpointname;

	@FindBy(name="webService.webServiceDescription")
	public static WebElement textfield_endpointdesc;

	@FindBy(name="webService.serviceSoapLocation")
	public static WebElement textfield_soaplocation;

	@FindBy(name="webService.serviceUserName")
	public static WebElement textfield_wscusename;

	@FindBy(name="userCredentials.password")
	public static WebElement textfield_wscpassword;

	@FindBy(name="userCredentials.passwordConfirm")
	public static WebElement textfield_wscrepassword;

	@FindBy(name="webService.maximumConcurrentRequestPerWSC")
	public static WebElement textfield_mcrequestwsc;


	@FindBy(name="webService.retriesMax")
	public static WebElement textfield_numoftries;

	@FindBy(name="webService.deliveryValidity")
	public static WebElement textfield_deliveryvalidity;


	@FindBy(xpath="//input[@value='Save']")
	public static WebElement button_save;

	@FindBy(id="overviewtable3")
	public static WebElement usertable_Manageevents;

	public static WebDriver driver;

	public GDSP_OpcoGUI_126(WebDriver driver)
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
	public void createoutboundwsc(String customercode,String endpointname ,String endpointdesc,String wscenabled,String soaplocation,String wscusername,String wscpassword,String mcrequestwsc,String wscsupported,String deliveryregime,String numofretries,String actuponfailure,String deliveryvalidity, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, InterruptedException
	{

		Manageevents_Opco.click();
		outboundwsc_ManageEvents.click();
		Select dropDown = new Select(driver.findElement(By.name("customerOrganisationId")));
		dropDown.selectByVisibleText(customercode);
		createbutton_notificationevents.click();
		textfield_endpointname.sendKeys(endpointname);
		textfield_endpointdesc.sendKeys(endpointdesc);

		Select dropdown1=new Select(driver.findElement(By.name("webService.serviceEnabled")));
		dropdown1.selectByVisibleText(wscenabled);
		textfield_soaplocation.sendKeys(soaplocation);
		textfield_wscusename.sendKeys(wscusername);
		textfield_wscpassword.sendKeys(wscpassword);
		textfield_wscrepassword.sendKeys(wscpassword);
		textfield_mcrequestwsc.sendKeys(mcrequestwsc);



		Select dropdown2=new Select(driver.findElement(By.name("webService.webServiceSupported")));
		dropdown2.selectByVisibleText(wscsupported);
		Thread.sleep(2000);
		Select dropdown3=new Select(driver.findElement(By.name("webService.deliveryRegime")));
		dropdown3.selectByVisibleText(deliveryregime);
		Thread.sleep(2000);

		textfield_numoftries.sendKeys(numofretries);
		Select dropdown4=new Select(driver.findElement(By.name("webService.deliveryFailureAction")));
		dropdown4.selectByVisibleText(actuponfailure);
		textfield_deliveryvalidity.sendKeys(deliveryvalidity);
		button_save.click();
		Thread.sleep(2000);
		try
		{
			if(usertable_Manageevents.getText().contains(endpointname))
			{
				test.log(Status.INFO,"outboundwsc created successfully");
				Thread.sleep(3000);
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				System.out.println("outboundwsc created successfully");
				test.log(Status.PASS,"outboundwsc created successfully");
			}

		}
		catch(Exception e)
		{
			test.log(Status.INFO,"outboundwsc is not created successfully");
			Thread.sleep(3000);
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("outboundwsc is  not created successfully");
			test.log(Status.FAIL,"outboundwsc is not created successfully");

		}
	}
}
