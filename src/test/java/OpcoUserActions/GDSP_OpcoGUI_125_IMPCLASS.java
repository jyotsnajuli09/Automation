package OpcoUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_125_IMPCLASS extends  BaseExtent {
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_125",dataProviderClass=DataprovidersOpco.GDSP_125.class)

	public void TC_125(Map hm) throws Exception{

		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_OpcoGUI_125.class);	
		GDSP_OpcoGUI_125 obj = new GDSP_OpcoGUI_125(driver);	
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnameOpco();
		String pass = genericLibrary.ReadProperty.readPwdOpco();
		System.out.println("hii..");
		String tcid = hm.get("TC_ID").toString();
		String Customercode = hm.get("CUSTOMERCODE").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		//driver.get("http://158.234.62.77:8080/GDSPGui/login.htm");
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);		
		test.log(Status.INFO,"Browser has been Launched");
		// To login 
		System.out.println("siso");
		obj.login(uid, pass,test,tcid);
		System.out.println("kido");
		test.log(Status.INFO, "Login is successful");	
		obj.searchManageEvents(Customercode, test, tcid);
		Thread.sleep(4000);
		driver.quit();

	}

}