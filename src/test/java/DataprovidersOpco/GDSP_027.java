package DataprovidersOpco;

import genericLibrary.Utility_Opco;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class GDSP_027 {
	@DataProvider(name="TC_027")

	public static Iterator<Object[]> dp_Platform() throws Exception{

		return Utility_Opco.gdsp_commonlogic("TC_027", "GDSPOpco");
	}
}
