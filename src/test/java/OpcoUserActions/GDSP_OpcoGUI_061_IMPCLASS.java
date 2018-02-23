package OpcoUserActions;

import genericLibrary.CurrentDateTime;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_OpcoGUI_061_IMPCLASS extends BaseExtent {
	public WebDriver driver;

public String tcid;
public String now;

@Test(dataProvider="TC_061",dataProviderClass=DataprovidersOpco.GDSP_061.class)

public void TC_061(Map hm) throws Exception{

	System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();	
	PageFactory.initElements(driver, GDSP_OpcoGUI_061.class);	
	GDSP_OpcoGUI_061 obj = new GDSP_OpcoGUI_061(driver);	

	String url = genericLibrary.ReadProperty.readURL();
	String uid= genericLibrary.ReadProperty.readUnameOpco();
	String pass = genericLibrary.ReadProperty.readPwdOpco();
	String tcid = hm.get("TC_ID").toString();
	String now = CurrentDateTime.get_datetimestamp();
	String imei= hm.get("IMEI").toString();
	/*double d = Double.parseDouble(imei);
	DecimalFormat df = new DecimalFormat("#");
	String Imei=df.format(d);*/
	driver.get(url);
	//driver.get("http://158.234.62.77:8080/GDSPGui/login.htm");
	String tc_desc= hm.get("TC_DESC").toString();
	test=extent.createTest(tcid + " "+tc_desc);	
	test.log(Status.INFO,"Browser has been Launched");
	// To login 
	obj.login(uid, pass,test,tcid);
	test.log(Status.INFO, "Login is successful");
	obj.searchSIMcustomers(imei, test, tcid);
	Thread.sleep(2000);
	driver.quit();

}
}


