package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_097 {
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
	
	@FindBy(xpath="//a[@href='load_sim_batch.htm']")
	public static WebElement loadsimbatch_ManageSIMs;
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement custcodeSearchBox_loadBatchsim;
	 @FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
		public static WebElement dropdown_custcode;
	 
	
	@FindBy(name="uploadedMultipartFile.file")
	public static WebElement choosefile_batchfileupload;

	@FindBy(xpath="//input[@value='Upload']")
	public static WebElement uploadbutton_batchfileupload;
	
	@FindBy(id="submit")
	public static WebElement yesButton_batchfileupload;
	
	@FindBy(xpath="//div[@class='formbox pc60']")
	public static WebElement formbox_validmessage;

	public static WebDriver driver;

	public GDSP_OpcoGUI_097(WebDriver driver)
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
	
	public void Batchfileupload(String custcode,String filepath,com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageSIMs_Opco.click();
		loadsimbatch_ManageSIMs.click();
		
//		Select dropdown1=new Select(driver.findElement(By.name("customerId")));
//		dropdown1.selectByVisibleText(custcode);
		custcodeSearchBox_loadBatchsim.sendKeys(custcode);
		Thread.sleep(2000);
		//ContactNamedropdown_ManageContacts.click();
		// Thread.sleep(10000);

		List<WebElement> allOptions =dropdown_custcode.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(custcode)) 
			{
				ele.click();
				Thread.sleep(5000);
			}

		}
		System.out.println("rowdy");
		choosefile_batchfileupload.click();
		System.out.println("rana");
	Thread.sleep(2000);
		Runtime.getRuntime().exec(filepath);
		Thread.sleep(5000);
		System.out.println("hii");
		 uploadbutton_batchfileupload.click();
		 System.out.println("hii");
		 Thread.sleep(1000);
		 yesButton_batchfileupload.click();
		 System.out.println("hii");
	try
	{
		if(formbox_validmessage.getText().contains("Your file has been loaded and submitted for processing"))
		{
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			test.log(Status.PASS, "your batchfile has been loaded");
			System.out.println("your batchfile has been loaded");
		}
	}
		
	catch(Exception e)
	{
		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);
		test.log(Status.FAIL, "your batchfile has not been loaded");
		System.out.println("your batchfile has not been loaded");
	}
	}
		
		
		
}



		
		
		
		
		
		
		
		
		
		



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
