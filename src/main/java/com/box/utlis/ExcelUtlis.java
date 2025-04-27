package com.box.utlis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtlis {
	public static Workbook book;
	public static Sheet sheetname;
	public static final String SHEET_PATH = "..\\boxcom\\src\\test\\resources\\foldernames.xlsx";
	
	public static Object[][] getData(String sheet_path1)
	{
		Object obj[][] = null;
		//FileInputStream ip = null;
		try {
			FileInputStream ip = new FileInputStream(SHEET_PATH);
			book=WorkbookFactory.create(ip);
				sheetname =	book.getSheet(sheet_path1);
				obj= new Object[sheetname.getLastRowNum()][sheetname.getRow(0).getLastCellNum()];
				for(int i =0;i<sheetname.getLastRowNum();i++)
				{
					for(int j=0;j<sheetname.getRow(0).getLastCellNum();j++)
					{
					obj[i][j]= sheetname.getRow(i+1).getCell(j).toString();
					}
				}
			} 
			
			catch (Exception ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
		return obj;
	}
	

}
