package CustomerUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_014_IMPCLASS extends BaseExtent{
	public WebDriver driver;
	public String tcid;
	public String now;


	@Test(dataProvider="TC_014",dataProviderClass=DataprovidersCustomer.GDSP_014.class)

	public void TC_014(Map hm) throws Exception{

		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_CustomerGUI_014.class);	
		GDSP_CustomerGUI_014 obj = new GDSP_CustomerGUI_014(driver);	
		String tcid = hm.get("TC_ID").toString();
		String now = CurrentDateTime.get_datetimestamp();
		String url = genericLibrary.ReadProperty.readURL();
		//String uid= genericLibrary.ReadProperty.readUnameCustomer();
		String uid=hm.get("username").toString();
		String username=hm.get("Username").toString();
		String pass = genericLibrary.ReadProperty.readPwdCustomer();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass,test,tcid);
		test.log(Status.INFO, "Login is successful");
		obj.filteruser(username, test, tcid);
		driver.quit();
	}
}
