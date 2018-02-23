package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_035_IMPCLASS extends BaseExtent {

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_035",dataProviderClass=Dataproviders.GDSP_035.class)
	public void TC_035(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_035.class);		
		GDSP_PlatformGUI_035 obj = new GDSP_PlatformGUI_035(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String EnType = hm.get("ENTITYTYPE").toString();	
		String WbServiceName = hm.get("WEBSERVICENAME").toString();
		String Calllimit= hm.get("CALLLIMIT").toString();
		double d = Double.parseDouble(Calllimit);
		DecimalFormat df = new DecimalFormat("#");
		String CLimit =df.format(d);
		String Periods = hm.get("PERIOD").toString();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.createAPIThrottling(EnType,WbServiceName, CLimit, Periods, test, tcid);
		
		//driver.quit();
      }
}
