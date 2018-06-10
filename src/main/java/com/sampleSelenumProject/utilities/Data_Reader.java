package com.sampleSelenumProject.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data_Reader {

	static int x;
	static InputStream is;

	@DataProvider
	public static Object[][] ReadAutomation_Data() throws IOException {

		String[][] excel_data = null;
		XSSFWorkbook wb;
		XSSFSheet sheet;
		try {
			is = new BufferedInputStream(new FileInputStream(
					Common_Constants.file_Path));
			wb = new XSSFWorkbook(is);
			sheet = wb.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows() - 1; // int
			// cols=sheet.getRow(1).getPhysicalNumberOfCells();
			x = sheet.getLastRowNum();
			System.out.println("Rows in given Excel :" + rows);
			excel_data = new String[rows][3];

			for (int i = 1; i <= rows; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < 3; j++) {
					System.out.println("Dyanmic Row Values"
							+ row.getCell(j).toString());
					excel_data[i - 1][j] = row.getCell(j).toString();
				}
			}
		} catch (Exception z) {
			System.out.println(z);
		}
		return excel_data;
	}

	public int num_of_rows() {
		return x;
	}

	public String getValuesFromExcel(String sheetName, int rowNum, int colNum)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {
		String value = null;
		String loc;
		try {
			loc = Common_Constants.file_Path;
			FileInputStream fis = new FileInputStream(loc);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row rw = sh.getRow(rowNum);
			value = rw.getCell(colNum).getStringCellValue();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public void setValuesFromExcel(String sheetName, int rowNum, int colNum,
			String data) throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		String loc = Common_Constants.file_Path;
		FileInputStream fis = new FileInputStream(loc);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		sh.getRow(rowNum).createCell(colNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(loc);
		wb.write(fos);
		((FileInputStream) wb).close();
		fos.close();
		fis.close();
	}

}
