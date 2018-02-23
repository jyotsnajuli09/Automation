package OpcoUserActions;

	import genericLibrary.TakeScreenshot;

	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.ui.Select;

	import com.aventstack.extentreports.Status;

	public class GDSP_OpcoGUI_125 {
		
		@FindBy(name="login.userId")
		public static WebElement platform_uname;

		@FindBy(id="submit")
		public static WebElement platformLogin_Button;

		@FindBy(name="login.password")
		public static WebElement platform_Pass;

		@FindBy(id="submit")
		public static WebElement platformPassword_Button;
		
		@FindBy(xpath="//a[@href='manage_events_overview.htm']")
	    public static WebElement ManageEvents_Opco;

	@FindBy(xpath="//input[@value='Clear Filter']")
	public static WebElement ClearFilter_ManageEvents;
		
		@FindBy(id="overviewtable3")
		public static WebElement Usertable_ManageEvents;
		
		@FindBy(xpath="//*[@id='wrapper']/div/table[1]/tbody/tr/td[4]/input")
		public static WebElement Search_Customercode;
		
		public static WebDriver driver;

		public GDSP_OpcoGUI_125(WebDriver driver)
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
		
		public void searchManageEvents(String customercode, com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
		{
			ManageEvents_Opco.click();
			Select dropDown = new Select (driver.findElement(By.name("formSearchValue1")));
			dropDown.selectByVisibleText(customercode);
			Thread.sleep(2000);
			Search_Customercode.click();
			Thread.sleep(2000);
			ClearFilter_ManageEvents.click();
			Thread.sleep(2000);
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
try{
			if((Usertable_ManageEvents.getText()).contains(customercode))
			{
				test.log(Status.INFO, "filteration is cleared successfully");
				
				System.out.println("filteration is cleared successfully");
			}
}
			catch(Exception e)
			{	
				test.log(Status.INFO, " filteration is not  cleared successfully");
				String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath3);
				System.out.println("filteration is not cleared successfully");
			}
			
			
		}
		
		

	}
