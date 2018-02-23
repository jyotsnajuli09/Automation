package DataprovidersOpco;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import genericLibrary.Utility_Opco;

public class GDSP_013 {
	@DataProvider(name="TC_013")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility_Opco.gdsp_commonlogic("TC_013", "GDSPOpco");
	}

}
