package OpcoUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_OpcoGUI_010_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_010",dataProviderClass=DataprovidersOpco.GDSP_010.class)

	public void TC_010(Map hm) throws Exception{

		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_OpcoGUI_010.class);	
		GDSP_OpcoGUI_010 obj = new GDSP_OpcoGUI_010(driver);	
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnameOpco();
		String pass = genericLibrary.ReadProperty.readPwdOpco();
		String tcid = hm.get("TC_ID").toString();
		String username = hm.get("USERNAME").toString();
		String fullname = hm.get("FULLNAME").toString();
		String accessright = hm.get("ACCESSRIGHT").toString();
		String customercode = hm.get("CUSTOMERCODE").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass,test,tcid);
		obj.searchByUsername(test, tcid, username);
		obj.searchByFullname(test, tcid, fullname);
		obj.searchByCustomercode(test, tcid, customercode);
		obj.searchByAccessright(test, tcid, accessright);

		driver.quit();

	}

}
