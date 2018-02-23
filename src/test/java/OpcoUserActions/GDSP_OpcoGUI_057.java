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

public class GDSP_OpcoGUI_057 {
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

	@FindBy(xpath="//*[@id='submitNew']")
	public static WebElement Search_SIM;
	@FindBy(id="simSearchResult")
	public static WebElement  simsearchtable_ManageSIMS;

	public static WebDriver driver;

	public GDSP_OpcoGUI_057(WebDriver driver)
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
	public void searchSIMcustomers(String Custname,String simgroup,com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		ManageSIMs_Opco.click();


		Thread.sleep(2000);



		WebElement wb1= driver.findElement(By.xpath("//select[@name='searchCustomer']"));

		Select se1=new Select(wb1);
		se1.selectByVisibleText(Custname);
		Thread.sleep(3000);
		Select se2=new Select(driver.findElement(By.xpath("//select[@name='searchDeviceGroup']")));


		se2.selectByVisibleText(simgroup);
		Thread.sleep(5000);


		Search_SIM.click();


		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2650)", "");



		test.log(Status.INFO,"Scroll down has been done");

		WebDriverWait wait = new WebDriverWait(driver,600); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("simSearchResult")));
		try
		{	
			if(( simsearchtable_ManageSIMS.isDisplayed()))
			{System.out.println("hiii2");
				test.log(Status.INFO, "Sim search Results  data  found");
				System.out.println("sim search results  data found");

				test.log(Status.INFO,"Scroll down has been done");

				//BackToTop_ManageContacts.click();
				Thread.sleep(10000);
				System.out.println("hii3333");
				JavascriptExecutor jse1 = (JavascriptExecutor) driver;
				jse1.executeScript("window.scrollBy(0,3050)", "");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);

			}
		}
		catch(Exception e)
		{              
			test.log(Status.INFO, "SIM search results no data  found");
			String screenShotPath4=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath4);
			System.out.println("SIM search results no data found");
		}




	}
}







