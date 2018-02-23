package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_054_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_054",dataProviderClass=Dataproviders.GDSP_054.class)
	public void TC_054(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_054.class);		
		GDSP_PlatformGUI_054 obj = new GDSP_PlatformGUI_054(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String now = CurrentDateTime.get_datetimestamp();
		String RGName = hm.get("RGNAME").toString();
		String RGDescription = hm.get("RGDESCRIPTION").toString();
		String GhlrGroup = hm.get("GHLRGROUP").toString();
		String EscaIdentifier = hm.get("ESCAIDENTIFIER").toString();
		double d = Double.parseDouble(EscaIdentifier);
		DecimalFormat df = new DecimalFormat("#");
		String ESCAIdentifier =df.format(d);
		driver.get(url);
		String tc_desc= hm.get("TC_DESC").toString();
		test=extent.createTest(tcid + " "+tc_desc);	
		test.log(Status.INFO,"Browser has been Launched");
		// To login 
		obj.login(uid, pass);
		obj.searchRoamingGroup(RGName, test, tcid);
		obj.editRoamingGroup(RGName,RGDescription ,GhlrGroup,ESCAIdentifier,test, tcid);
		
		driver.quit();

	}

}




