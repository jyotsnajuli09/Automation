package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_073 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;


	@FindBy(xpath="//a[@href='indexOpCoSims.htm']")
	public static WebElement ManageSIMs_Opco;
	
	@FindBy(id="searchForm.simIDSelections")
	public static WebElement simidsearchform_ManageSIMS;

	@FindBy(xpath="//*[@id='submitNew']")
	public static WebElement Search_SIM;

	@FindBy(xpath="//input[@name='simCheckBox1']")
	public static WebElement selectcheckbox_SIMs;

	@FindBy(xpath="//input[@id='submitActionButton']")
	public static WebElement submit_actions;
	
	@FindBy(id="overviewtable3")
	public static WebElement Usertable_Actionsonsim;
	
	
	
	@FindBy(xpath="//input[@value='Yes']")
	public static WebElement yes_button;
	
	@FindBy(xpath="//div[@class='formbox_header']")
	public static WebElement confirmationmsg_formboxheader;
	
	@FindBy(xpath="//label[contains(text(),'Your Batch No. is:')]")
	public static WebElement conformationmsg;

	public static WebDriver driver;

	public GDSP_OpcoGUI_073(WebDriver driver)
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
	public void selectactiononSIMs(String simid,String actionname,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		ManageSIMs_Opco.click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		simidsearchform_ManageSIMS.sendKeys(simid);
		Search_SIM.click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2650)", "");
		
		WebDriverWait wait = new WebDriverWait(driver,180); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(simid)));
	
		WebElement wb=driver.findElement(By.xpath("//*[contains(@href,'popup_sim_details.htm')]/preceding::input[1]"));
		wb.click();
		
		//selectcheckbox_SIMs.click();
		driver.findElement(By.xpath("//input[@id='selectPageCheckBox']")).click();
		Select dropDown = new Select (driver.findElement(By.name("selector")));
		dropDown.selectByVisibleText(actionname);
		Thread.sleep(2000);
		submit_actions.click();

		Thread.sleep(2000);
		
		
		yes_button.click();
		try
	    {
	    	if(driver.findElement(By.xpath("//p[@class='validationmessage']")).isDisplayed())
			{
				String errorMessage = driver.findElement(By.xpath("//p[@class='validationmessage']")).getText();
				test.log(Status.INFO, errorMessage);	

				if(errorMessage.contains("error"))
				{
					Thread.sleep(2000);
					String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath2);
					test.log(Status.FAIL, "sim action execution of transformation is not done successfully");
					System.out.println("sim action execution of transformation is not done  successfully");
				}
			}
	    	
	    	
	    		
	    }
	catch(Exception e)
	    
	    {
		if(conformationmsg.isDisplayed())
		{
		test.log(Status.INFO, "sim action preparation of transformation is done successfully");
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		Thread.sleep(2000);
		System.out.println("sim action prepation of transformation is done successfully");
		test.log(Status.PASS, "sim action prepation of transformation is done successfully");
		
	}
	
	    }
	}
}

