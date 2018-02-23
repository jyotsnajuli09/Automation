package DataprovidersOpco;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import genericLibrary.Utility_Opco;

public class GDSP_153 {
	@DataProvider(name="TC_153")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility_Opco.gdsp_commonlogic("TC_153", "GDSPOpco");
	}

}