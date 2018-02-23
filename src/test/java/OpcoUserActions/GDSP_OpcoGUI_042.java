package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_042 {



	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement Managecustomers_Opco;

	@FindBy(xpath="//a[@href='manage_sp_paged_overview.htm']")
	public static WebElement customerserviceprofiles_Managecustomers;

	//@FindBy(xpath="//a[contains(text(),'Blended-CSP1222')]")
	//public static WebElement linkofcspprofile_csp;
	@FindBy(name="formSearchValue")
	public static WebElement Search_profilenme;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_profilename;


	@FindBy(xpath="//a[contains(text(),' Migrate SIMs')]")
	public static WebElement migratesim_csp;

	@FindBy(xpath="//a[contains(text(),'Select')]")
	public static WebElement select_csp;

	@FindBy(name="userId")
	public static WebElement username_migratesimlogin;

	@FindBy(name="password")
	public static WebElement password_migratesimlogin;

	@FindBy(id="submit")
	public static WebElement loginbutton_migratesims;

	@FindBy(id="submit")
	public static WebElement submitbutton_migratesims;
	@FindBy(id="submit")
	public static WebElement okbutton_migratesims;

	@FindBy(name="formSearchValue")
	public static WebElement Searchname_MigratesimsCustomercode;

	@FindBy(xpath="//input[@value='Search']")
	public static WebElement searchbutton_MigratesimsCustomercode;

	@FindBy(xpath="//div[@class='formbox pc60']")
	public static WebElement table_csp;

	@FindBy(xpath="//*[@id='actions']/ul/li[5]/a")
	public static WebElement returntoserviceprof;

	public static WebDriver driver;

	public GDSP_OpcoGUI_042(WebDriver driver)
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

	public void csprofiles(String cspname,String username,String password,String custcode,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();
		Thread.sleep(3000);

		customerserviceprofiles_Managecustomers.click();
		Search_profilenme.sendKeys(cspname);
		searchicon_profilename.click();

		WebDriverWait wait = new WebDriverWait(driver,180); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(cspname)));

		String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath2);

		Thread.sleep(2000);

		WebDriverWait wait1 = new WebDriverWait(driver,180); 
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(cspname)));
		driver.findElement(By.linkText(cspname)).click();

		migratesim_csp.click();	
		select_csp.click();
		username_migratesimlogin.sendKeys(username);
		password_migratesimlogin.sendKeys(password);
		loginbutton_migratesims.click();
		System.out.println("hii");
		Searchname_MigratesimsCustomercode.sendKeys(custcode);
		searchbutton_MigratesimsCustomercode.click();
		select_csp.click();

		submitbutton_migratesims.click();
		try
		{
		
		
		if(driver.findElement(By.xpath("//p[@class='validationmessage']")).isDisplayed())
		{
			String errorMessage = driver.findElement(By.xpath("//p[@class='validationmessage']")).getText();
			test.log(Status.INFO, errorMessage);	

			if(errorMessage.contains("error"))
			{
				Thread.sleep(2000);
				String screenShotPath=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath);
				test.log(Status.FAIL, "sim migration is not possible because of internal error");
				System.out.println("sim migration is not possible because of internal error");
			}
		
			
		
		
	}
		}
		catch(Exception e)
		{
			
			if(table_csp.isDisplayed())
			{
			Search_profilenme.sendKeys(cspname);
			searchicon_profilename.click();
				
			
			WebDriverWait wait2 = new WebDriverWait(driver,180); 
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(cspname)));
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			test.log(Status.PASS, "SIMs migration is done successfully");
			System.out.println("SIMs migration is done successfully");
		}
	}
}

}	
		
	
