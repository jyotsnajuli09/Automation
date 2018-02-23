package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_022_IMPCLASS extends BaseExtent{
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_022",dataProviderClass=Dataproviders.GDSP_022.class)
	public void TC_022(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_022.class);		
		GDSP_PlatformGUI_022 obj = new GDSP_PlatformGUI_022(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String name=hm.get("Name").toString();
		String tcid = hm.get("TC_ID").toString();	
		String country = hm.get("Country").toString();
		String client_type = hm.get("AAA_Client_Type").toString();
		String diameterIP=hm.get("DIAMETER_IP_Address").toString();	
		String RadiusIP=hm.get("RADIUS_IP_Address").toString();	
		String RADIUS_Secret = hm.get("RADIUS_Secret").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.searchAAA(name, test, tcid);	
		obj.editAAA(name, country, client_type, diameterIP, RadiusIP, RADIUS_Secret, test, tcid);
		driver.quit();
		
	}		
	
	

}