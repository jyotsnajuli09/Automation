package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_056_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_056",dataProviderClass=Dataproviders.GDSP_056.class)
	public void TC_056(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_056.class);		
		GDSP_PlatformGUI_056 obj = new GDSP_PlatformGUI_056(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String ImsiRange = hm.get("IMSIRANGE").toString();	
		double d = Double.parseDouble(ImsiRange);
		DecimalFormat df = new DecimalFormat("#");
		String IMSIRange =df.format(d);	
		String opcoCode = hm.get("OPCOCODE").toString();	
		double d1 = Double.parseDouble(opcoCode);
		DecimalFormat df1 = new DecimalFormat("#");
		String OpcoCode =df1.format(d1);	
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
        obj.searchOpco(OpcoCode, test, tcid);
        obj.editBillingConfiguration(IMSIRange,OpcoCode, test, tcid);
		driver.quit();
      }

}
