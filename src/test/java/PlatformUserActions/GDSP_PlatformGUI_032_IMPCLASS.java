package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_032_IMPCLASS extends BaseExtent {
	
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_032",dataProviderClass=Dataproviders.GDSP_032.class)
	public void TC_032(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_032.class);		
		GDSP_PlatformGUI_032 obj = new GDSP_PlatformGUI_032(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String ImsiFrom = hm.get("IMSIFROM").toString();
		
	
		String ImsiTo = hm.get("IMSITO").toString();
		
		
		//String RangeDesc = hm.get("RANGE_DESCRIPTION").toString();
		//String OpcoCode = hm.get("OPCOCODE").toString();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.createIMSIRange(ImsiFrom,ImsiTo, test, tcid);
		obj.searchIMSIRange(ImsiFrom,ImsiTo, test, tcid);
		driver.quit();
      }
}
