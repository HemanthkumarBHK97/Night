 package com.crm.Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
 public	String getDataFromExcel( String sheetName, int RowNum, int cellNum ) throws Throwable{
	FileInputStream fils1= new FileInputStream("./Book2.xlsx");
	Workbook book = WorkbookFactory.create(fils1);
	Sheet sh = book.getSheet(sheetName);
	Row row = sh.getRow(RowNum);
	Cell cell = row.getCell(cellNum);
	String data = cell.getStringCellValue();
	return data;	
	}
	

}
