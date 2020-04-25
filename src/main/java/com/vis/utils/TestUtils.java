package com.vis.utils;

import com.vis.Base.TestBase;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class TestUtils extends TestBase {
    public TestUtils() throws IOException {
    super();
    }
    public  Object[][] getDataFromExcel(String SheetName) throws IOException
    {
        FileInputStream fis = new FileInputStream("src/main/java/com/vis/testdata/TestData.xlsx"); // load the excel workbook

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        Sheet sheet1 = workbook.getSheet(SheetName);

        int rows = sheet1.getLastRowNum();
        int columns = sheet1.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][columns] ;

        for (int i =0;i<rows;i++)
        {
            for(int j =0;j<columns;j++)
            {
                data[i][j]=sheet1.getRow(i+1).getCell(j).toString();
            }
        }
        workbook.close();
        return data;
    }

}
