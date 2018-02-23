package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_031_IMPCLASS extends BaseExtent {
	
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_031",dataProviderClass=Dataproviders.GDSP_031.class)
	public void TC_031(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_031.class);		
		GDSP_PlatformGUI_031 obj = new GDSP_PlatformGUI_031(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String SName = hm.get("SNAME").toString();	
		String SDescription = hm.get("SDESCRIPTION").toString();
		String IMSIType = hm.get("IMSITYPE").toString();
		String FormFactor = hm.get("FORMFACTOR").toString();
		String Manufacturer = hm.get("MANUFACTURER").toString();
		String PLMNList = hm.get("PLMNLIST").toString();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.searchSIMProfile(SName, test, tcid);
		obj.editSIMProfile(SName, SDescription, IMSIType, FormFactor, Manufacturer, PLMNList, test, tcid);
		driver.quit();
      }
}