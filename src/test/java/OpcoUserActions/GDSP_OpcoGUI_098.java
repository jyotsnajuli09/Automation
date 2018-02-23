package OpcoUserActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GDSP_OpcoGUI_098 {
	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;


	@FindBy(xpath="//a[@href='indexOpCoSims.htm']")
	public static WebElement ManageSIMs_Opco;

	@FindBy(xpath="//a[@href='provision_sim_batch.htm']")
	public static WebElement provisionsimbatch_ManageSIMs;

	@FindBy(xpath="//input[@class='ui-autocomplete-input ui-widget ui-widget-content ui-corner-left']")
	public static WebElement custcodeSearchBox_loadBatchsim;
	
	@FindBy(xpath="//*[@class='ui-autocomplete ui-menu ui-widget ui-widget-content ui-corner-all']")
	public static WebElement dropdown_custcode;
	
	

}
