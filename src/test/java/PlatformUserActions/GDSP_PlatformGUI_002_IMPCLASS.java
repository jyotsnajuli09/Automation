package PlatformUserActions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_002_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;


	@Test(dataProvider="TC_002",dataProviderClass=Dataproviders.GDSP_002.class)

	public void TC_002(Map hm) throws Exception{

		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_002.class);
		GDSP_PlatformGUI_002 obj = new GDSP_PlatformGUI_002(driver);
		String uid= hm.get("username").toString();
		System.out.println(uid);
		String pass=hm.get("pwd").toString();
		String url = genericLibrary.ReadProperty.readURL();
		String tcid = hm.get("TC_ID").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		obj.login(uid,test,tcid);
		test.log(Status.INFO, "Login is not successful since user name is invalid");	
		driver.quit();

	}


}



