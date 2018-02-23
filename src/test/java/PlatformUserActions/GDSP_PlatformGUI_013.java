package PlatformUserActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GDSP_PlatformGUI_013 {
	

	@FindBy(name="login.userId")
	public static WebElement platform_uname;

	@FindBy(id="submit")
	public static WebElement platformLogin_Button;

	@FindBy(name="login.password")
	public static WebElement platform_Pass;

	@FindBy(id="submit")
	public static WebElement platformPassword_Button;
	
	@FindBy(xpath="//a[@href='manage_platform_ops_details.htm']")
	public static WebElement ManageAccount_PlatformTab;
	
	@FindBy(xpath="//a[@href='account_user_only_details.htm']")
	public static WebElement UserAccounts_PlatformTab;
	

}
