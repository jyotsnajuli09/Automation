package genericLibrary;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	public static Properties properties;

	public static void loadData(Properties properties) throws IOException
	{	
		File f = new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\test.properties");
		FileReader obj2 = new FileReader(f);
		properties.load(obj2);	
		obj2.close();
	}

	public static String getObjects(Properties properties,String Data1) throws IOException
	{
		String Data2 = properties.getProperty(Data1);
		return Data2;
	}

	public static String readURL() throws IOException
	{
		Properties properties = new Properties();
		loadData(properties);	
		String URL= getObjects(properties,"url");
		return URL;
	}	

	public static String readUnamePL() throws IOException
	{
		Properties properties = new Properties();
		loadData(properties);	
		String UNAMEPLATFORM= getObjects(properties,"UnamePlatform");
		return UNAMEPLATFORM;
	}

	public static String readPwdPL() throws IOException
	{
		Properties properties = new Properties();
		loadData(properties);	
		String PWDPLATFORM = getObjects(properties,"PwdPlatform");
		return PWDPLATFORM;
	}

	public static String readUnameOpco() throws IOException
	{
		Properties properties = new Properties();
		loadData(properties);	
		String UnameOpco = getObjects(properties,"UnameOpco");
		return UnameOpco;
	}
	
	public static String readPwdOpco() throws IOException
	{
		Properties properties = new Properties();
		loadData(properties);	
		String PWDOpco = getObjects(properties,"PwdOpco");
		return PWDOpco;
	}
	public static String readUnameCustomer() throws IOException
	{
		Properties properties = new Properties();
		loadData(properties);	
		String UnameCustomer = getObjects(properties,"UnameCustomer");
		return UnameCustomer;
	}
	
	public static String readPwdCustomer() throws IOException
	{
		Properties properties = new Properties();
		loadData(properties);	
		String PwdCustomer = getObjects(properties,"PwdCustomer");
		return PwdCustomer;
	}
}

