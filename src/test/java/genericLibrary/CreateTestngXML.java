package genericLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.beust.testng.TestNG;

public class CreateTestngXML{
	
	public static String createDirectory()
	{
		String now = CurrentDateTime.get_datetimestamp();
		
	    File dir = new File("C:\\Users\\arabinda.samal\\new proj\\GDSP_REGRESSION_GUI_AUTOMATION_platform\\src\\test\\java\\extentReports\\TestReport"+now);
	    String filePath = dir.getPath();
	    // attempt to create the directory here
	    boolean successful = dir.mkdir();
	    if (successful)
	    {
	      // creating the directory succeeded
	      System.out.println("directory was created successfully");
	    }
	    else
	    {
	      // creating the directory failed
	      System.out.println("failed trying to create the directory");
	    }
	    System.out.println("File path is "+ filePath);
	    return filePath;
	   
		
	}

	public static void main(String[] args) throws IOException
	{
		CreateTestngXML obj = new CreateTestngXML();
		obj.createDirectory();
	    
		String fpath = "C:\\Users\\arabinda.samal\\new proj\\GDSP_REGRESSION_GUI_AUTOMATION_platform\\src\\test\\resources\\GDSP_Testngxml - Copy2.xlsx";
		File f = new File(fpath);
		FileInputStream fi = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet =workbook.getSheetAt(0);
		XSSFRow row=null;
		int row_num = sheet.getLastRowNum();
		java.util.List<String> saurav = new ArrayList<String>();


		for(int i=1;i<=row_num;i++)
		{
			row = sheet.getRow(i);
			if(row.getCell(2).toString().equalsIgnoreCase("Yes"))
			{
				saurav.add(row.getCell(3).toString());
			}
		}
		
		XmlSuite suite = new XmlSuite();
		suite.setName("Suite");
		XmlTest test = new XmlTest(suite);
		test.setName("Test");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		System.out.println("the size of array list is " + saurav.size());
		for(int p=0;p<saurav.size();p++)
		{
			System.out.println(saurav.get(p));
			classes.add(new XmlClass(saurav.get(p)));
			
		}
		
		test.setXmlClasses(classes) ;
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}

}
