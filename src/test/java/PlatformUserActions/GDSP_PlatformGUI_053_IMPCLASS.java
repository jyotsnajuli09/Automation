package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import genericLibrary.CurrentDateTime;

public class GDSP_PlatformGUI_053_IMPCLASS extends BaseExtent{

	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_053",dataProviderClass=Dataproviders.GDSP_053.class)
	public void TC_053(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_053.class);		
		GDSP_PlatformGUI_053 obj = new GDSP_PlatformGUI_053(driver);
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
		obj.login(uid, pass);
		obj.createnewRoamingGroup(RGName,RGDescription ,GhlrGroup,ESCAIdentifier,test, tcid);
		obj.searchRoamingGroup(RGName, test, tcid);
		driver.quit();

	}

}




