package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_023_IMPCLASS extends BaseExtent {
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_023",dataProviderClass=Dataproviders.GDSP_023.class)
	public void TC_023(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_023.class);		
		GDSP_PlatformGUI_023 obj = new GDSP_PlatformGUI_023(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();		
		String SGSNAddressType = hm.get("SGSNAddressType").toString();
		String opcoCode = hm.get("OpCoCode").toString();
		//Formatting SGSN IP address
		String ipAddress = hm.get("SGSNIPAddress").toString();
		String now = CurrentDateTime.get_datetimestamp();	
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.createSGSNMapping(SGSNAddressType, ipAddress, test,tcid,opcoCode);	
		//driver.quit();

	}
}