package OpcoUserActions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Arabinda {
	
	public static WebDriver driver;
	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://158.234.62.84:8080/GDSPGui/login.htm");

		driver.findElement(By.xpath("//a[@href='manage_events_overview.htm']")).click();
		
		driver.findElement(By.linkText("Combined_Usage"));
		
		
		
	}
}
	 

	
		