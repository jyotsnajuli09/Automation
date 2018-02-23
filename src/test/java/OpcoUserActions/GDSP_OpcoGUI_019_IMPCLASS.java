package OpcoUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_019_IMPCLASS extends BaseExtent {
	
	

		public WebDriver driver;
		public String tcid;
		public String now;

		@Test(dataProvider="TC_019",dataProviderClass=DataprovidersOpco.GDSP_019.class)

		public void TC_019(Map hm) throws Exception{

			System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();	
			PageFactory.initElements(driver, GDSP_OpcoGUI_019.class);	
			GDSP_OpcoGUI_019 obj = new GDSP_OpcoGUI_019(driver);	
			String url = genericLibrary.ReadProperty.readURL();
			String uid= hm.get("username").toString();
			String pass = genericLibrary.ReadProperty.readPwdOpco();
			String tcid = hm.get("TC_ID").toString();
			String now = CurrentDateTime.get_datetimestamp();
			//String fullname= hm.get("FULLNAME").toString();
			driver.get(url);
			String tc_desc= hm.get("TC_DESC").toString();
			test=extent.createTest(tcid + " "+tc_desc);	
			test.log(Status.INFO,"Browser has been Launched");
			// To login 
			obj.login(uid, pass,test,tcid);
			test.log(Status.INFO, "Login is successful");
			obj.ClickonManagetariffs( test, tcid);
			driver.quit();

		}

	}
	


