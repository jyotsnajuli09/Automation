package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_033_IMPCLASS extends BaseExtent {

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_033",dataProviderClass=Dataproviders.GDSP_033.class)
	public void TC_033(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_033.class);		
		GDSP_PlatformGUI_033 obj = new GDSP_PlatformGUI_033(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String ImsiFrom = hm.get("IMSIFROM").toString();
		double d5 = Double.parseDouble(ImsiFrom);
		DecimalFormat df5 = new DecimalFormat("#");
		String IMSIFrom =df5.format(d5);
	
		String ImsiTo = hm.get("IMSITO").toString();
		double d1 = Double.parseDouble(ImsiTo);
		DecimalFormat df1 = new DecimalFormat("#");
		String IMSITo =df1.format(d1);
		String RangeDesc = hm.get("RANGE_DESCRIPTION").toString();
		//String OpcoCode = hm.get("OPCOCODE").toString();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		
		obj.editIMSIRange(IMSIFrom,IMSIFrom,IMSITo, RangeDesc,test, tcid);
		
		//driver.quit();
      }
}
