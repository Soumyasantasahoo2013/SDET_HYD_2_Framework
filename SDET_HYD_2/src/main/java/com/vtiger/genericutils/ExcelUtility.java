package com.vtiger.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility {
	
	@Test
	public String excelUtility(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstant.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		return cell.getStringCellValue();
	}

}
