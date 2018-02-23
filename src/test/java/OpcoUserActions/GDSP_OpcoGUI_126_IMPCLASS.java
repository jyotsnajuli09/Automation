package OpcoUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


	public class GDSP_OpcoGUI_126_IMPCLASS extends BaseExtent{
		public WebDriver driver;
		public String tcid;
		public String now;

		@Test(dataProvider="TC_126",dataProviderClass=DataprovidersOpco.GDSP_126.class)

		public void TC_126(Map hm) throws Exception{

			System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();	
			PageFactory.initElements(driver, GDSP_OpcoGUI_126.class);	
			GDSP_OpcoGUI_126 obj = new GDSP_OpcoGUI_126(driver);	
			String url = genericLibrary.ReadProperty.readURL();
			String uid= genericLibrary.ReadProperty.readUnameOpco();
			String pass = genericLibrary.ReadProperty.readPwdOpco();
			String tcid = hm.get("TC_ID").toString();
	        String custcode=hm.get("CUSTCODE").toString();
	        String endpointname=hm.get("ENDPOINTNAME").toString();
	        String endpointdesc=hm.get("ENDPOINTDESC").toString();
	        String wscenabled=hm.get("WSCENABLED").toString();
	        String soaplocation=hm.get("SOAPLOCATION").toString();
	        String wscusername=hm.get("WSCUSERNAME").toString();
	        String wscpassword=hm.get("WSCPASSWORD").toString();
	        String mcrequestwsc=hm.get("MCREQUESTWSC").toString();
	        String wscsupported=hm.get("WSCSUPPORTED").toString();
	        String deliveryregime=hm.get("DELIVERYREGIME").toString();
	        String numofretries=hm.get("NUMBEROFRETRIES").toString();
	        String actuponfailure=hm.get("ACTIONUPONFAILURE").toString();
	        String deliveryvalidity=hm.get("DELIVERYVALIDITY").toString();
			String now = CurrentDateTime.get_datetimestamp();
			driver.get(url);
			//driver.get("http://158.234.62.77:8080/GDSPGui/login.htm");
			String tc_desc= hm.get("TC_DESC").toString();
			test=extent.createTest(tcid + " "+tc_desc);	
			test.log(Status.INFO,"Browser has been Launched");
			// To login
			obj.login(uid, pass,test,tcid);
			test.log(Status.INFO, "Login is successful");	
			obj.createoutboundwsc(custcode,endpointname,endpointdesc,wscenabled,soaplocation,wscusername, wscpassword, mcrequestwsc,wscsupported,deliveryregime,numofretries,actuponfailure,deliveryvalidity,test, tcid);
			//driver.quit();

		}

	}




