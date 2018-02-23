package CustomerUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PlatformUserActions.GDSP_PlatformGUI_002;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_002_IMPCLASS extends BaseExtent {
	public WebDriver driver;
	public String tcid;
	public String now;


	@Test(dataProvider="TC_002",dataProviderClass=DataprovidersCustomer.GDSP_002.class)

	public void TC_002(Map hm) throws Exception{

		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_CustomerGUI_002.class);
		GDSP_CustomerGUI_002 obj = new GDSP_CustomerGUI_002(driver);
		String uid= hm.get("username").toString();
		System.out.println(uid);
		//String pass=hm.get("pwd").toString();
		String url = genericLibrary.ReadProperty.readURL();
		String tcid = hm.get("TC_ID").toString();
		System.out.println(tcid);
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		
		test=extent.createTest(tcid + " "+tc_desc);	
		obj.login(uid,test,tcid);
		test.log(Status.INFO, "Login is not successful since user name is invalid");	
		driver.quit();

	}

}
