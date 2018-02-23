package CustomerUserActions;

import genericLibrary.CurrentDateTime;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_CustomerGUI_019_IMPCLASS extends BaseExtent{
	public WebDriver driver;
	public String tcid;
	public String now;


	@Test(dataProvider="TC_019",dataProviderClass=DataprovidersCustomer.GDSP_019.class)

	public void TC_019(Map hm) throws Exception{

		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_CustomerGUI_019.class);	
		GDSP_CustomerGUI_019 obj = new GDSP_CustomerGUI_019(driver);	
		String tcid = hm.get("TC_ID").toString();
		String now = CurrentDateTime.get_datetimestamp();
		String url = genericLibrary.ReadProperty.readURL();
		
		String opcousername=hm.get("username").toString();
		
		String pass = hm.get("pwd").toString();
	    driver.get(url);
	   String customercode=hm.get("Customercode").toString();
	   String username=hm.get("usname").toString();
	   String newpass=hm.get("newpassword").toString();
	   
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(opcousername, pass,test,tcid);
		
		test.log(Status.INFO, "Login is successful");
		obj.resetpasswordthroughopco(customercode,username,newpass,test, tcid);
		driver.quit();
	}
	
}

