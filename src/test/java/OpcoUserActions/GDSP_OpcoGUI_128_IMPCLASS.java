package OpcoUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_128_IMPCLASS extends BaseExtent{
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_128",dataProviderClass=DataprovidersOpco.GDSP_128.class)

	public void TC_128(Map hm) throws Exception{

		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_OpcoGUI_128.class);	
		GDSP_OpcoGUI_128 obj = new GDSP_OpcoGUI_128(driver);	
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnameOpco();
		String pass = genericLibrary.ReadProperty.readPwdOpco();
		String tcid = hm.get("TC_ID").toString();
       
        String endpointname=hm.get("ENDPOINTNAME").toString();
        String newendpointname=hm.get("NEWENDPOINTNAME").toString();
        String newendpointdesc=hm.get("NEWENDPOINTDESC").toString();
        String soaploc=hm.get("SOAPLOC").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		//driver.get("http://158.234.62.77:8080/GDSPGui/login.htm");
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		// To login
		obj.login(uid, pass,test,tcid);
		test.log(Status.INFO, "Login is successful");	
		obj.copyoutboundwsc(endpointname,newendpointname,newendpointdesc,soaploc,test, tcid);
		//driver.quit();
}
}