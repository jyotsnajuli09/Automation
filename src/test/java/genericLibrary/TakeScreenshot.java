package genericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot extends CreateTestngXML {

	static String now = CurrentDateTime.get_datetimestamp();
	static String fpath = CreateTestngXML.createDirectory();

	public void takeScreenShot(WebDriver driver, String screenShotName)
	{

		TakesScreenshot sc = (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		
		
		

		try {
			FileUtils.copyFile(src, new File(fpath+"\\"+ now + screenShotName +".png"));
			// Change the screenshot path as required
		} 

		catch (IOException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		} 

	}

	public static String captureScreen(WebDriver driver,String screenShotName) throws IOException
	{
		String now1 = CurrentDateTime.get_datetimestamp();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = fpath+"\\"+now1+ screenShotName +".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);        
		return dest;
	  }
  }
