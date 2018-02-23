package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_045_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_045",dataProviderClass=Dataproviders.GDSP_045.class)
	public void TC_045(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_045.class);		
		GDSP_PlatformGUI_045 obj = new GDSP_PlatformGUI_045(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String Name= hm.get("NAME").toString();
		String newname= hm.get("NEWNAME").toString();
		String Description= hm.get("DESCRIPTION").toString();
		String reference= hm.get("REFERENCE").toString();
		String copyReference= hm.get("COPYREFERENCE").toString();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.searchPLMNList(Name,newname,Description,reference,copyReference, test, tcid);
		driver.quit();
	}
}