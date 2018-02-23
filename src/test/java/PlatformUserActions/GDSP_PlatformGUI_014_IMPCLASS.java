package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_014_IMPCLASS extends BaseExtent {

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_014",dataProviderClass=Dataproviders.GDSP_014.class)
	public void TC_014(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_014.class);		
		GDSP_PlatformGUI_014 obj = new GDSP_PlatformGUI_014(driver);	
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String Username=hm.get("Username").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass,test,tcid);
		obj.searchUser(Username,test,tcid);
		driver.quit();
	}

}
