package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import DBOpco.DatabaseOpco;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_032 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;

	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_ManageCustomers;

	@FindBy(xpath="//a[@href='manage_customer_overview.htm']")
	public static WebElement Managecustomers_Opco;

	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchIcon_Managecustomers;

	@FindBy(xpath="//a[@href='manage_certificates_overview.htm?customerId=667&customerCode=001dp_test&prevPage=customer']")
	public static WebElement managecertificatetab_customers;

	
	
	@FindBy(id="submit")
	public static WebElement createbuttton_customers;
	@FindBy(id="certificate.sslCertificateName")
	public static WebElement certificatename_certificate;
	
	@FindBy(id="certificate.sslCertificateDesc")
	public static WebElement certificatedesc_certificate;
	
	@FindBy(id="certificate.keyStorePassword")
	public static WebElement certificatepass_certificate;
	
	@FindBy(id="uploadedCommonsMultipartFile.file")
	public static WebElement choosefile_certificate;
	
	@FindBy(xpath="//input[@value='Upload']")
	public static WebElement uploadfile_certificate;
	
	@FindBy(xpath="//input[@value='Yes']")
	public static WebElement yesbutton_certificate;
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement savebutton_certificate;
	//*[@id="wrapper"]/div/div/form[1]/p[1]/text()
	@FindBy(id="wrapper")
	public static WebElement cerficatetable_customers;
	
	@FindBy(xpath="//*[@id='wrapper']/div/div")
	public static WebElement form_validation;
	@FindBy(xpath="//*[@id='wrapper']/div/div/form[1]/p[1]/text()")
	public static WebElement errormsg;
	//p[@class='validationmessage']
	@FindBy(xpath="//p[@class='validationmessage']")
	public static WebElement errormsg2;
	
	@FindBy(xpath="//*[@class='validationmessage']")
	public static WebElement validationMesaage_UserDetails;
	
	public static WebDriver driver;

	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement customersearch_logincustomers;


	public GDSP_OpcoGUI_032(WebDriver driver)
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
	public void customercertitificate(String Custname,String name,String desc,String password,String filepath, com.aventstack.extentreports.ExtentTest test, String tcid) throws IOException, AWTException, InterruptedException
	{
		Managecustomers_Opco.click();


		Thread.sleep(2000);
		customersearch_logincustomers.sendKeys(Custname);

		List<WebElement> allOptions =dropdown_ManageCustomers.findElements(By.className("ui-menu-item"));

		java.util.Iterator<WebElement> i = allOptions.iterator();
		while(i.hasNext()) {
			WebElement ele = i.next();
			if (ele.getText().equals(Custname)) 
			{
				ele.click();
				Thread.sleep(3000);
			}
			searchIcon_Managecustomers.click();
			managecertificatetab_customers.click();
			Thread.sleep(2000);
			 createbuttton_customers.click();
			 certificatename_certificate.sendKeys(name);
			 certificatedesc_certificate.sendKeys(desc);
			 certificatepass_certificate.sendKeys(password);
			 Thread.sleep(5000);
			 choosefile_certificate.click();
			
			 Runtime.getRuntime().exec(filepath);
			 //Runtime.getRuntime().exec("filepath");

			 System.out.println("hiii");
			 Thread.sleep(5000);
			 uploadfile_certificate.click();
			 
			 System.out.println("hiii2");
			 yesbutton_certificate.click();
			 Thread.sleep(5000);
			 System.out.println("hiii3");
			 savebutton_certificate.click();
			 
			Thread.sleep(3000);
			 
			 try
			 {
				if(errormsg2.isDisplayed())
				{
					
					test.log(Status.PASS, "User certificate is already existing");
					System.out.println("error msg is shown");
					System.out.println( "User certificate is already existing");
					String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
					test.addScreenCaptureFromPath(screenShotPath3);
				}
		}
			 
	catch(Exception e)
			 {
		
		test.log(Status.INFO,"validation message is not shown");
		test.log(Status.FAIL, "validation message is not shown");
		System.out.println("error msg is not shown");
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
			 }
			 
		}
		
	}
}

