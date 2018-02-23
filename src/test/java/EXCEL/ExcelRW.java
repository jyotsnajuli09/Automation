package EXCEL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class ExcelRW {
	
	XSSFWorkbook wb;
	FileInputStream fis;
	
	// Initialize Excel
	
	public ExcelRW (String fpath) throws IOException{
		
		fis = new FileInputStream(fpath);
		
		// Create a Work Book
		
		wb = new XSSFWorkbook(fis);
	}
		
	// Get the Row Count
	
	public int rowcount (String sheetname){
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		return sheet.getLastRowNum();
	}
	
	
	//Get Column Count
	
	public int Colcount(String sheetname){
		
		XSSFSheet sheet= wb.getSheet(sheetname);
		return sheet.getRow(0).getLastCellNum();
	}
	
	// Read Cell
	
	public String readcellval(String sheetname, int row,int col){
		
		XSSFSheet sheet= wb.getSheet(sheetname);
		XSSFCell cell =sheet.getRow(row).getCell(col);
		String celltext=null;
		if(cell.getCellType()==cell.CELL_TYPE_STRING){
			
			celltext=cell.getStringCellValue();
		}else if (cell.getCellType()==cell.CELL_TYPE_NUMERIC){
			
			celltext=String.valueOf(cell.getNumericCellValue());
			
		}else if (cell.getCellType()==cell.CELL_TYPE_BLANK){
			
			celltext="";
		}
		return celltext;
		
		
		
	}
	
// Write to cell
	
	public void writecell(String sheetname, int row, int col,String val){
		
		XSSFSheet sheet= wb.getSheet(sheetname);
		sheet.getRow(row).getCell(col).setCellValue(val);
		
	}
	
	
	//Save & close
	
	public void saveandclose(String fpath) throws IOException {
		
		FileOutputStream fos= new FileOutputStream(fpath);
		
		wb.write(fos);
		
		// Close the streams
		
		fos.close();
		fis.close();
		
		
	}
}
