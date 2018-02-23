package OpcoUserActions;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demo {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
		WebDriver fd = new ChromeDriver();
		fd.get("http://158.234.62.84:8080/GDSPGui/login.htm");
		fd.manage().window().maximize();
		fd.findElement(By.id("login.userId")).sendKeys("SUPPNL4");
		fd.findElement(By.id("submit")).click();
		fd.findElement(By.id("login.password")).sendKeys("Secret123");
		fd.findElement(By.id("submit")).click();
		fd.findElement(By.xpath("//a[@href='indexOpCoSims.htm']")).click();
		fd.findElement(By.id("submitNew")).click();
		//fd.findElement(By.xpath("//textarea[@id='searchForm.imsiSelections']")).sendKeys("600000011500006");
		//fd.findElement(By.linkText("600000011500006")).click();
		System.out.println("hola");
		//Scanner scanner = new Scanner(System.in);
		//String next = scanner.next();
		fd.findElement(By.xpath("//a[@href='popup_sim_details.htm?simId=100205922071&cusId=100200751&width=760&height=580']")).click();
		fd.switchTo().frame(fd.findElement(By.className("cboxIframe")));
		fd.findElement(By.xpath("//a[@href='popup_sim_registration_data.htm?simId=100205922071&simIdentifier=110000000000003']")).click();
		//fd.findElement(By.partialLinkText("SIM")).click();
		
	

	}

}
