package DataprovidersOpco;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import genericLibrary.Utility2;
import genericLibrary.Utility_Opco;

public class GDSP_001 {

	@DataProvider(name="TC_001")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility_Opco.gdsp_commonlogic("TC_001", "GDSPOpco");
	}

}
