package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_016_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_016",dataProviderClass=Dataproviders.GDSP_016.class)
	public void TC_016(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_016.class);		
		GDSP_PlatformGUI_016 obj = new GDSP_PlatformGUI_016(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String fullname=hm.get("Fullname").toString();
		String tcid = hm.get("TC_ID").toString();
		String Email=hm.get("Email").toString();
		String phon=hm.get("Telephone1").toString();
		// formatting phon	
		double d = Double.parseDouble(phon);
		DecimalFormat df = new DecimalFormat("#");
		String PhoneNumber =df.format(d);
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.editContacts(fullname, Email, PhoneNumber, test, tcid);
		driver.quit();
	}

}




