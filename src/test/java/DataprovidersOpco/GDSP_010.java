package DataprovidersOpco;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import genericLibrary.Utility_Opco;

public class GDSP_010 {

	@DataProvider(name="TC_010")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility_Opco.gdsp_commonlogic("TC_010", "GDSPOpco");
	}

}
