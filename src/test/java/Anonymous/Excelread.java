package Anonymous;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.Alert;
//import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//simport org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Excelread {
WebDriver driver=null;
static String un;
static String pwd;
@Test(priority=1)
public void readexcel() throws IOException
{
	System.setProperty("webdriver.chrome.driver","./src/test/resources/exe_files/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();	
	String scr="C://Users//arabinda.samal//Documents//facebook.xlsx";
	FileInputStream fis=new FileInputStream(scr);
	XSSFWorkbook ws=new XSSFWorkbook(fis);
	XSSFSheet sh=ws.getSheet("sheet1");
	XSSFRow rw2=sh.getRow(1);
	XSSFRow rw1=sh.getRow(0);
	un=rw2.getCell(0).getStringCellValue();
	pwd=rw2.getCell(1).getStringCellValue();
	String user=rw1.getCell(0).getStringCellValue();
	System.out.println(un);
	System.out.println(pwd);
	System.out.println(user);
	
}
@Test(priority=2)
public void fblogin() throws InterruptedException
{
	driver.get("https://www.facebook.com/login.php?login_attempt=1&lwv=110");
	Thread.sleep(2000);
	driver.findElement(By.id("email")).sendKeys(un);
	driver.findElement(By.id("pass")).sendKeys(pwd);
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
	Thread.sleep(2000);
}


@Test(priority=3)
public void namevalidate() throws InterruptedException
	{
	Thread.sleep(2000);
WebDriverWait wait=new WebDriverWait(driver, 20);
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Arabinda Samal']")));
	WebElement wb=driver.findElement(By.xpath("//div[text()='Arabinda Samal']"));
	String expectedresult="Arabinda Samal";
	String actualresult=wb.getText();
	System.out.println(actualresult);
	if(expectedresult.equals(actualresult))
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ESCAPE).build().perform();
		wb.click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='https://www.facebook.com/photo.php?fbid=1206852856100078&set=a.103010609817647.3183.100003261246050&type=3&source=11&referrer_profile_id=100003261246050']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//div[@class='fbPhotoSnowliftContainer snowliftPayloadRoot uiContextualLayerParent']/div[1]/div[1]/div[1]/div[1]/div"));
		WebElement ele3 =driver.findElement(By.xpath("//div[@id='fbPhotoSnowliftActions']/div[2]/a/span[@class='uiButtonText']"));
		Actions adt=new Actions(driver);
		adt.moveToElement(ele3).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Download")).click();
		Thread.sleep(3000);
		adt.sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		adt.sendKeys(Keys.ESCAPE).perform();
		adt.sendKeys(Keys.ESCAPE).perform();
		System.out.println("aaaa");
		driver.findElement(By.xpath("//a[@href='https://www.facebook.com/?ref=tn_tnmn']")).click();
		driver.findElement(By.id("userNavigationLabel")).click();
		driver.findElement(By.xpath("//div[@class='uiScrollableAreaContent']/ul/li[16]/a/span/span")).click();
		driver.close();
	}
	else
	{
	driver.findElement(By.linkText("https://www.facebook.com/?ref=tn_tnmn")).click();
	driver.findElement(By.id("userNavigationLabel")).click();
	driver.findElement(By.xpath("//div[@class='uiScrollableAreaContent']/ul/li[16]/a/span/span")).click();
	
		
	}
	
	
	}
}

	
	
	
	























