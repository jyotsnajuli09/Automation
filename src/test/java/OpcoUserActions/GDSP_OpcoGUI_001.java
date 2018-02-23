package OpcoUserActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.TakeScreenshot;

public class GDSP_OpcoGUI_001 {
	
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	public static WebDriver driver;
	
	public GDSP_OpcoGUI_001(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void login(String Username, String Password, com.aventstack.extentreports.ExtentTest test,String tcid ) throws IOException
	{
		platform_uname.sendKeys(Username);
		platformLogin_Button.click();
		platform_Pass.sendKeys(Password);
		platformPassword_Button.click();
		driver.findElement(By.xpath("//a[@href='manage_events_overview.htm']")).click();
		
		test.log(Status.INFO, "entered valid username and password");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
	    test.addScreenCaptureFromPath(screenShotPath2);
	    test.log(Status.PASS, "Login is successful");
		
	}


}
