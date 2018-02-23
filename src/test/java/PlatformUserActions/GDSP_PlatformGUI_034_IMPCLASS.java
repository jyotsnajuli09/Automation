package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_034_IMPCLASS extends BaseExtent {
	
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_034",dataProviderClass=Dataproviders.GDSP_034.class)
	public void TC_034(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_034.class);		
		GDSP_PlatformGUI_034 obj = new GDSP_PlatformGUI_034(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String ImsiFrom = hm.get("IMSIFROM").toString();
		double d5 = Double.parseDouble(ImsiFrom);
		DecimalFormat df5 = new DecimalFormat("#");
		String IMSIFrom =df5.format(d5);
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.searchIMSIRange(IMSIFrom, test, tcid);
		//driver.quit();
      }
}
