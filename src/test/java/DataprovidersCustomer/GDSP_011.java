package DataprovidersCustomer;

import genericLibrary.Utility_Customer;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class GDSP_011 {
	@DataProvider(name="TC_011")

	public static Iterator<Object[]> dp_Customer() throws Exception{

		return Utility_Customer.gdsp_commonlogic("TC_011","GDSPCustomer");
}
}
