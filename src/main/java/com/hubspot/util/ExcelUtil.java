package com.hubspot.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static Workbook book;
	public static Sheet sheet;	
	
public static Object[][] getTestData(String sheetName)
{
	try {
		FileInputStream fip=new FileInputStream(AppConstants.TESTDATA_SHEET_PATH);
		book= WorkbookFactory.create(fip);
		sheet= book.getSheet(sheetName);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}


int row=sheet.getLastRowNum();
int column=sheet.getRow(0).getLastCellNum();

Object data[][]=new Object[row][column];
for(int i=0;i<row;i++)
{
	for(int k=0;k<column;k++)
	{
		data[i][k]=sheet.getRow(i+1).getCell(k).toString();
	}
}
return data;
}
}
