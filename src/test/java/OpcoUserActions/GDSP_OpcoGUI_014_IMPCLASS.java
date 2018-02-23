package OpcoUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


	public class GDSP_OpcoGUI_014_IMPCLASS extends BaseExtent{
		public WebDriver driver;
		public String tcid;
		public String now;

		@Test(dataProvider="TC_014",dataProviderClass=DataprovidersOpco.GDSP_014.class)

		public void TC_014(Map hm) throws Exception{

			System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();	
			PageFactory.initElements(driver, GDSP_OpcoGUI_014.class);	
			GDSP_OpcoGUI_014 obj = new GDSP_OpcoGUI_014(driver);	
			String url = genericLibrary.ReadProperty.readURL();
			String uid= genericLibrary.ReadProperty.readUnameOpco();
			String pass = genericLibrary.ReadProperty.readPwdOpco();
			String tcid = hm.get("TC_ID").toString();
			String now = CurrentDateTime.get_datetimestamp();
			String fullname= hm.get("FULLNAME").toString();
			driver.get(url);
			String tc_desc= hm.get("TC_DESC").toString();
			test=extent.createTest(tcid + " "+tc_desc);		
			test.log(Status.INFO,"Browser has been Launched");
			// To login 
			obj.login(uid, pass,test,tcid);
			test.log(Status.INFO, "Login is successful");
			obj.searchContacts(fullname, test, tcid);
			Thread.sleep(2000);
			driver.quit();

		}

	}




