package OpcoUserActions;

import genericLibrary.TakeScreenshot;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_045 {
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
	
    @FindBy(xpath="//a[@href='manage_provisioning_overview.htm']")
    public static WebElement Manageprovisioning_Managecustomers;
    
    @FindBy(id="submit")
    public static WebElement create_provisionprofiles;
    
    @FindBy(name="commandGroup.customerId")
    public static WebElement customer_dropdown;
    
    @FindBy(name="commandGroup.commandGroupName")
    public static WebElement name_textfield;
    
    @FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement GrpidentifierSearchBox_Provprofiles;
    
    @FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_Roaminggroupidentifier;
    @FindBy(xpath="//*[@id='disableCombo']/button/span[1]")
    public static WebElement drpdownbutton_grpidentifier;
    
    @FindBy(id="submit")
    public static WebElement save_provisionprofiles;
    
    @FindBy(name="formSearchValue")
    public static WebElement search_provisionprofiles;
    
    @FindBy(xpath="//input[@src='images/search.png']")
    public static WebElement searchicon_provisionprofiles;
    
    @FindBy(id="overviewtable3")
	public static WebElement table_provprof;

public static WebDriver driver;

public GDSP_OpcoGUI_045(WebDriver driver)
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
public void createnewprovprof(String custcode,String name,com.aventstack.extentreports.ExtentTest test, String tcid)throws IOException, AWTException, InterruptedException
{
	Managecustomers_Opco.click();
	Manageprovisioning_Managecustomers.click();
	create_provisionprofiles.click();
	Thread.sleep(2000);
	Select dropdown=new Select(driver.findElement(By.name("commandGroup.customerId")));
	dropdown.selectByVisibleText(custcode);
	Thread.sleep(2000);
	name_textfield.sendKeys(name);
System.out.println("arabinda");

/*WebDriverWait wait = new WebDriverWait(driver,30);

 

 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("serviceCoverageGroupId")));


Select dropdown1=new Select(driver.findElement(By.id("serviceCoverageGroupId")));
dropdown1.selectByVisibleText("06sep1212(ID:51)");*/
//drpdownbutton_grpidentifier.click();
WebDriverWait wait = new WebDriverWait(driver,30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")));
GrpidentifierSearchBox_Provprofiles.sendKeys("ALL");


List<WebElement> allOptions = dropdown_Roaminggroupidentifier.findElements(By.className("ui-menu-item"));

java.util.Iterator<WebElement> i = allOptions.iterator();
while(i.hasNext()) {
	WebElement ele = i.next();
	if (ele.getText().equals("ALL")) 
  {
		ele.click();
Thread.sleep(5000);
}
}
	save_provisionprofiles.click();
	search_provisionprofiles.clear();
	search_provisionprofiles.sendKeys(name);
	
	
	try
	{
		if(table_provprof.getText().contains(name))
		{
			test.log(Status.INFO, "creation of new provisionprofile is successful");
			System.out.println("creation of new provisionprofile is successful");
			
			String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath2);
			Thread.sleep(2000);
			test.log(Status.PASS, "creation of new provisionprofile is successful");
		}
			
	}
	catch(Exception e)
	{
		test.log(Status.INFO, "creation of new provisionprofile is not successful");
		System.out.println("creation of new provisionprofile is not successful");
		
		String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
		test.addScreenCaptureFromPath(screenShotPath3);
		Thread.sleep(2000);
		test.log(Status.FAIL, "creation of new provisionprofile is not successful");
	}
	
	
	
	
	
	
	
}
}


















