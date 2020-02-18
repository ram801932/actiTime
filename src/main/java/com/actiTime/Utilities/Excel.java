package com.actiTime.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String readdata(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		   Workbook w = WorkbookFactory.create(fs);
		  String s= w.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		  return s;
	}
	public static void writedata(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException
	{

		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		   Workbook w = WorkbookFactory.create(fs);
		   w.getSheet(sheetname).getRow(rownum).createCell(cellnum).setCellValue(data);
		   FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"/testdata/userdata.xlsx");
		   w.write(fos);
		
	}
}
