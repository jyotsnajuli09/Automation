package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_020_IMPCLASS extends BaseExtent {
	
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_020",dataProviderClass=Dataproviders.GDSP_020.class)
	public void TC_020(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_020.class);		
		GDSP_PlatformGUI_020 obj = new GDSP_PlatformGUI_020(driver);
		String url = hm.get("url").toString();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String name=hm.get("Name").toString();
		String copyname=hm.get("CopyName").toString();
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
		obj.copyBSG(name,copyname, description, className, test, tcid, businessService);
		//driver.quit();
		
	}		
	
	

}



