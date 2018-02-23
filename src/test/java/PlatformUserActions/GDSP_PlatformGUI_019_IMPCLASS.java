package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_019_IMPCLASS extends BaseExtent {
	
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_019",dataProviderClass=Dataproviders.GDSP_019.class)
	public void TC_019(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_019.class);		
		GDSP_PlatformGUI_019 obj = new GDSP_PlatformGUI_019(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String name=hm.get("Name").toString();
		String description=hm.get("Description").toString();	
		String className=hm.get("Class").toString();
		String businessService=hm.get("BusinessServices").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.searchBSG(name, test, tcid);	
		obj.editBSG(name, description, className, test, tcid, businessService);
		driver.quit();
		
	}		
	
	

}
