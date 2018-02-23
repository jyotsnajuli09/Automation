package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;


	public class GDSP_OpcoGUI_116 {
		@FindBy(name="login.userId")
		public static WebElement platform_uname;

		@FindBy(id="submit")
		public static WebElement platformLogin_Button;

		@FindBy(name="login.password")
		public static WebElement platform_Pass;

		@FindBy(id="submit")
		public static WebElement platformPassword_Button;
		
		@FindBy(xpath="//a[@href='manage_vpn_groups_overview.htm']")
		public static WebElement ManageVPNs_Opco;
		
		@FindBy(xpath="//a[@href='manage_vpn_barring_overview.htm']")
		public static WebElement Calllistconfiguration_ManageVPNs;
		
		@FindBy(xpath="//a[contains(text(),'Back To Top')]")
	public static WebElement BackToTop_calllistconfiguration;

		public static WebDriver driver;

		public GDSP_OpcoGUI_116(WebDriver driver)
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
		public void backtotop( com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
		{
			ManageVPNs_Opco.click();
			Calllistconfiguration_ManageVPNs.click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,3050)", "");
			
			
			System.out.println("scrolling successful");
			
			try{
			test.log(Status.INFO,"Scroll down has been done");
			Thread.sleep(3000);
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			System.out.println("screenShotPath3 "+screenShotPath3);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	              FileUtils.copyFile(scrFile, new File("C:\\Test\\screenshot1.png"));
			BackToTop_calllistconfiguration.click();
			Thread.sleep(60000);
			test.log(Status.INFO,"Successfully clicked on Back to top button");
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			System.out.println("screenShotPath2" +screenShotPath2);
			File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile2, new File("C:\\Test\\screenshot2.png"));
			Thread.sleep(2000);
			test.log(Status.PASS,"Successfully clicked on Back to top button");
			}
			catch(Exception e)
			{
				test.log(Status.INFO,"Not clicked on Back to top button");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				test.log(Status.FAIL,"Not clicked on Back to top button");
			}
}
}