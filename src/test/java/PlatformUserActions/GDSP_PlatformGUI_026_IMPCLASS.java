package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_026_IMPCLASS extends BaseExtent{
	
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_026",dataProviderClass=Dataproviders.GDSP_026.class)
	public void TC_026(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_026.class);		
		GDSP_PlatformGUI_026 obj = new GDSP_PlatformGUI_026(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String ghlrTemplate = hm.get("GHLRTemplate").toString();
		String name = hm.get("Name").toString();
		String description = hm.get("Description").toString();
		String SecondaryMSISDNRequired = hm.get("SecondaryMSISDNRequired").toString();
		String ExtraServiceSupported = hm.get("ExtraServiceSupported").toString();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
	
		obj.editGHLRTemplate( name, description, SecondaryMSISDNRequired, test, tcid);
		
		driver.quit();

	}}



