package PlatformUserActions;

import java.text.DecimalFormat;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GDSP_PlatformGUI_027_IMPCLASS extends BaseExtent {
	public WebDriver driver;
	public String tcid;
	public String now;

	@Test(dataProvider="TC_027",dataProviderClass=Dataproviders.GDSP_027.class)
	public void TC_027(Map hm) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();	
		PageFactory.initElements(driver, GDSP_PlatformGUI_027.class);		
		GDSP_PlatformGUI_027 obj = new GDSP_PlatformGUI_027(driver);
		String url = genericLibrary.ReadProperty.readURL();
		String uid= genericLibrary.ReadProperty.readUnamePL();
		String pass = genericLibrary.ReadProperty.readPwdPL();
		String tcid = hm.get("TC_ID").toString();
		String Name = hm.get("NAME").toString();
		String Class = hm.get("CLASS").toString();
		String RG = hm.get("RG").toString();
		double d = Double.parseDouble(RG);
		DecimalFormat df = new DecimalFormat("#");
		String Rg =df.format(d);
		
		String cqvt = hm.get("CQVT").toString();
		double d1 = Double.parseDouble(cqvt);
		DecimalFormat df1 = new DecimalFormat("#");
		String CQVT =df1.format(d1);
		
		String cqto = hm.get("CQTO").toString();
		double d2 = Double.parseDouble(cqto);
		DecimalFormat df2 = new DecimalFormat("#");
		String CQTO =df2.format(d2);
		
		String cqht = hm.get("CQHT").toString();
		double d3 = Double.parseDouble(cqht);
		DecimalFormat df3 = new DecimalFormat("#");
		String CQHT =df3.format(d3);
		
		String dcfci = hm.get("DCFCI").toString();
		double d4 = Double.parseDouble(dcfci);
		DecimalFormat df4 = new DecimalFormat("#");
		String DCFCI =df4.format(d4);
		
		String rcfci = hm.get("RCFCI").toString();
		double d5 = Double.parseDouble(rcfci);
		DecimalFormat df5 = new DecimalFormat("#");
		String RCFCI =df5.format(d5);
		
		String  RuleBaseId= hm.get("RuleBaseId").toString();
		String DevNotification = hm.get("DevNotification").toString();
		String ISDUR= hm.get("ISDUR").toString();
		String CRC = hm.get("CRC").toString();
		String Rat = hm.get("RAT").toString();
		
		driver.get(url);
		//driver.get("http://158.234.62.77:8080/GDSPGui/login.htm");
		test=extent.createTest("TC_027");
		test.log(Status.INFO,"Browser has been Launched");
		obj.login(uid, pass);
		obj.createAPN(Name, Class, Rg, CQVT, CQTO, CQHT, DCFCI, RCFCI, RuleBaseId, DevNotification, ISDUR, CRC, Rat, test, tcid);
		obj.searchAPN(Name, test, tcid);

		driver.quit();

	}}



