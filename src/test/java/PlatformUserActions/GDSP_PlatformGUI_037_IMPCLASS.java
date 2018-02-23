package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_037_IMPCLASS extends BaseExtent {
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_037",dataProviderClass=Dataproviders.GDSP_037.class)
	public void TC_037(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_037.class);		
		GDSP_PlatformGUI_037 obj = new GDSP_PlatformGUI_037(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String opcoCode = hm.get("OPCOCODE").toString();	
		double d = Double.parseDouble(opcoCode);
		DecimalFormat df = new DecimalFormat("#");
		String OpcoCode =df.format(d);		
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);

        obj.searchOpco(OpcoCode, test, tcid);
        
		driver.quit();
      }
}