package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_010_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_010",dataProviderClass=Dataproviders.GDSP_010.class)
	public void TC_010(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_010.class);		
		GDSP_PlatformGUI_010 obj = new GDSP_PlatformGUI_010(driver);	
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String fullname =  hm.get("Fullname").toString();
		String email =  hm.get("Email").toString();   
		String phon=hm.get("PhoneNumber").toString();
		// formatting phon	
		double d = Double.parseDouble(phon);
		DecimalFormat df = new DecimalFormat("#");
		String phoneNumber =df.format(d);

		String Username=hm.get("Username").toString();
		String Password=hm.get("Password").toString();
		String now = CurrentDateTime.get_datetimestamp();
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		// To login 
		obj.login(uid, pass,test,tcid);
		obj.createUser(fullname,phoneNumber,email,Username,Password,test,tcid);
		driver.quit();
	}

}
