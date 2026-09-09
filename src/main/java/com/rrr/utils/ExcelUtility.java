package com.rrr.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtility() throws IOException {

    	
        String filePath = System.getProperty("user.dir")
                + "/FtrackAutomation/TestData/LoginData.xlsx";

        FileInputStream file = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(file);

        sheet = workbook.getSheet("Sheet1");
    }

    public String getCellData(int rowNum, int colNum) {

        return sheet.getRow(rowNum)
                    .getCell(colNum)
                    .toString();
    }

    public int getRowCount() {

        return sheet.getLastRowNum();
    }

    public int getColumnCount() {

        return sheet.getRow(0).getLastCellNum();
    }

    public void closeWorkbook() throws IOException {
        workbook.close();
    }

	public Object[][] getLoginData() {
		// TODO Auto-generated method stub
		return null;
	}
}