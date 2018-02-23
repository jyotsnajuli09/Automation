

	package OpcoUserActions;

	import genericLibrary.TakeScreenshot;

	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.aventstack.extentreports.Status;

	public class GDSP_OpcoGUI_047 {
		
			
			@FindBy(name="login.userId")
			public static WebElement platform_uname;

			@FindBy(id="submit")
			public static WebElement platformLogin_Button;

			@FindBy(name="login.password")
			public static WebElement platform_Pass;

			@FindBy(id="submit")
			public static WebElement platformPassword_Button;
			
			@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
			public static WebElement ManageCustomers_Opco;
			
			@FindBy(xpath="//a[@href='manage_provisioning_overview.htm']")
			public static WebElement ProvisioningProfiles_ManageCustomers;
			
			@FindBy(xpath="//input[@name='formSearchValue']")
			public static WebElement ProvisioningProfileName_ProvisioningProfiles;
			
			@FindBy(xpath="//input[@src='images/search.png']")
			public static WebElement Search_ProvisioningProfileName;
			
			@FindBy(id="overviewtable3")
			public static WebElement Usertable_ManageCustomers;
				
			
			public static WebDriver driver;

			public GDSP_OpcoGUI_047(WebDriver driver)
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
			
			public void searchProvisioningProfileName(String Profilename, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
			{
				ManageCustomers_Opco.click();
				ProvisioningProfiles_ManageCustomers.click();
				ProvisioningProfileName_ProvisioningProfiles.sendKeys(Profilename);
				Thread.sleep(2000);
				Search_ProvisioningProfileName.click();
				
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
try
{
				if((Usertable_ManageCustomers.getText()).contains(Profilename))
				{
					test.log(Status.INFO, "Provisioning profile name search is successful");
					
					System.out.println("Provisioning profile name  search is successful");
				}
}
				catch(Exception e)
				{	
					test.log(Status.INFO, "Provisioning profile name does not found for the created user");
					String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath3);
					System.out.println("Provisioning profile name does not found for the created user");
				}
				
				
				
				
			}


	}

