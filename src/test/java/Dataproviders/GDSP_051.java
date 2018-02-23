package Dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import genericLibrary.Utility2;

public class GDSP_051 {
	@DataProvider(name="TC_051")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility2.gdsp_commonlogic("TC_051", "GDSPPlatform");
	}

}