package api.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet; 
	public XSSFRow row ;
	public XSSFCell cell; 
	public InputStream input;
	
	
	public int getRowCount(String exelPath, String sheetName) throws Exception {
		input= new FileInputStream(exelPath);
		workbook=new XSSFWorkbook(input);
		sheet=workbook.getSheet(sheetName);
		
		int rowcount=sheet.getLastRowNum();
		
		input.close();
		workbook.close();
		return rowcount;
	}
	
	public int getCellCount(String excelPath,String sheetName) throws Exception {
		input =new FileInputStream(excelPath);
		workbook =new XSSFWorkbook(input);
		sheet=workbook.getSheet(sheetName);
		
		int cellcount=sheet.getRow(0).getLastCellNum();
		input.close();
		workbook.close();
		return cellcount;
		
	}
	
	public String getData(String excelPath, String sheetName,int rownum,int cellnum) throws Exception {
		input= new FileInputStream(excelPath);
		
		workbook =new XSSFWorkbook(input);
		sheet=workbook.getSheet(sheetName);
		row= sheet.getRow(rownum);
		cell= row.getCell(cellnum);
		
		String data;
		try {
		DataFormatter formatter= new DataFormatter();
		String celldata=formatter.formatCellValue(cell);
		return celldata;
		}catch (Exception e) {
			data=" ";
		}
		input.close();
		workbook.close();
		return data;
		
	}


	
	

}
