package DataprovidersCustomer;

import genericLibrary.Utility_Customer;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class GDSP_015 {
	@DataProvider(name="TC_015")

	public static Iterator<Object[]> dp_Customer() throws Exception{

		return Utility_Customer.gdsp_commonlogic("TC_015","GDSPCustomer");
}
}
