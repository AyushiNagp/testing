//Author Emp Id:3151410
//Author Name: Siddharth Gaur
//Company Name:Nagarro Software
package Utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//Reading excel file and returning an object[][] with excel sheet data
public class ReadExcelData {
    public static String[][] getExcelData(String fileName, String sheetName) {
        String[][] excelData = null;
        try {
            File file = new File(fileName);
            FileInputStream fs = new FileInputStream(file);
            Workbook wb = null;
            wb = new HSSFWorkbook(fs);
            Sheet sh = wb.getSheet(sheetName);

            int rowCount = sh.getLastRowNum() - sh.getFirstRowNum()+1;
            excelData=new String[rowCount-1][sh.getRow(1).getLastCellNum()];
            for (int i = 1; i < rowCount ; i++) {
                Row row = sh.getRow(i);
                //Create a loop to add cell values in a excel data array
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    //add Excel data in array
                    excelData[i-1][j] = row.getCell(j).getStringCellValue();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(excelData);
        return excelData;
    }
}
