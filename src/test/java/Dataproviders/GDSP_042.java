package Dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import genericLibrary.Utility2;

public class GDSP_042 {
	@DataProvider(name="TC_042")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility2.gdsp_commonlogic("TC_042", "GDSPPlatform");
	}

}