package genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import EXCEL.ExcelRW;

public class Utility2 {

	public static Iterator<Object[]> gdsp_commonlogic (String sheetname,String scriptname) throws Exception{

		ExcelRW excelRW= new ExcelRW(System.getProperty("user.dir") + "\\src\\test\\resources\\GDSP_Platform.xlsx");
		int rowcount=excelRW.rowcount(sheetname);
		int colcount=excelRW.Colcount(sheetname);
		// List Create
		List<Object[]> al= new ArrayList<Object[]>();		
		for (int i=0;i<rowcount;i++){

			String flag=excelRW.readcellval(sheetname, i, 2);
			String script=excelRW.readcellval(sheetname, 1, 1);
			if(flag.equals("Y") && script.equals(scriptname)){
				// Create Map
				Map<String, String> hmap=new HashMap<String, String>();
				// Create Object Array
				Object[] x= new Object[1];
				for(int j=0;j<colcount;j++){
					String key=	excelRW.readcellval(sheetname, 0,j);
					String value= excelRW.readcellval(sheetname, i,j);
					hmap.put(key, value);	
		
				}
				// Add to Object Array
				x[0]=hmap;
				al.add(x);

			}
		}

		return al.iterator();		

	}		
}



