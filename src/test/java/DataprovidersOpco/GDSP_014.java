package DataprovidersOpco;

import genericLibrary.Utility_Opco;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class GDSP_014 {

	@DataProvider(name="TC_014")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility_Opco.gdsp_commonlogic("TC_014", "GDSPOpco");
	}

}