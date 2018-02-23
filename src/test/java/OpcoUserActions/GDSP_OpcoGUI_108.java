package OpcoUserActions;

import genericLibrary.TakeScreenshot;

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

public class GDSP_OpcoGUI_108 {
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
	
	@FindBy(xpath="//a[@href='manage_vpn_number_lists_overview.htm']")
	public static WebElement Numberlist_managevpns;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement  createbutton_ManageVPNs;
	
	@FindBy(xpath="//input[@name='vpnNumberList.numberListName']")
	public static WebElement  Numberlistnametextbox_createnewnumberlist;
	
	@FindBy(xpath="//input[@name='vpnNumberList.numberListDesc']")
	public static WebElement numberlistdesc_createnewnumberlist;
	
	@FindBy(xpath="//input[@name='vpnListNumbersList[0].number']")
	public static WebElement numberlists_createnumberlist;
	
	@FindBy(xpath="//input[@id='submit']")
	public static WebElement savebutton;
	
	@FindBy(xpath="//input[@name='formSearchValue']")
	public static WebElement searchbox_numberlistname;
	
	@FindBy(xpath="//input[@src='images/search.png']")
	public static WebElement searchicon_numberlistname;
	
	@FindBy(xpath="//a[text()='Edit']")
	public static WebElement edit_numlist;
	
	
	
	@FindBy(id="overviewtable3")
	public static WebElement usertable_ManageVPNs;
	
	@FindBy(xpath="//div[@class='tablewrapper pc70']")
	public static WebElement numlisttable_ManageVPNs;
	public static WebDriver driver;

	public GDSP_OpcoGUI_108(WebDriver driver)
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
	public void numlistedit(String customercode,String numlistname,String numlistdesc,String numlists,com.aventstack.extentreports.ExtentTest test, String tcid) throws InterruptedException, IOException
	{
		ManageVPNs_Opco.click();
		Numberlist_managevpns.click();
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)", "");
		
		
		
		WebDriverWait wait=new WebDriverWait(driver, 160);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("formSearchValue")));
		searchbox_numberlistname.sendKeys(numlistname);
		searchicon_numberlistname.click();
		edit_numlist.click();
		numberlists_createnumberlist.sendKeys(numlists);
		savebutton.click();
		
	    Thread.sleep(3000);
		try
		{
			if(numlisttable_ManageVPNs.getText().contains(numlistname))
			{
				test.log(Status.INFO, "edit of newnumlist is successfully done ");
				String screenShotPath2=TakeScreenshot.captureScreen(driver,tcid);
				test.addScreenCaptureFromPath(screenShotPath2);
				Thread.sleep(2000);
				System.out.println("edit of newnumlist is successfully done");
				test.log(Status.PASS, "  edit of newnumlist is successfully done ");
			}
			}
		catch(Exception e)
		{
			test.log(Status.INFO, "  edit of newnumlist is not successfully done ");
			String screenShotPath3=TakeScreenshot.captureScreen(driver,tcid);
			test.addScreenCaptureFromPath(screenShotPath3);
			Thread.sleep(2000);
			System.out.println("edit of newnumlist is not successfully done");
			test.log(Status.FAIL, "  edit of newnumlist is not successfully done ");
		
		}
		
	}
}

