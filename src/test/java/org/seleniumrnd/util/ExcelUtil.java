package org.seleniumrnd.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    public static void main(String[] args) {
        String filePath ="C://All_Projects//test_data.xlsx";
        //System.out.println(getExcelDataArray(filePath,"login"));
        System.out.println(getExcelDataMap(filePath,"login"));
    }

      public static String[][] getExcelDataArray(String fileName, String sheetName){

        String[][] data = null;
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows-1][noOfCols];
            for(int i =1; i<noOfRows;i++){
                for(int j=0;j<noOfCols;j++){
                    row = sh.getRow(i);
                    cell= row.getCell(j);
                    data[i-1][j] = cell.getStringCellValue();
                }
            }
        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
        return data;
    }

    public static Map<String,String> getExcelDataMap(String fileName, String sheetName){

        Map<String,String> dataMap = new HashMap<>();
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            int noOfRows = sh.getPhysicalNumberOfRows();
            int noOfCols = row.getLastCellNum();


            for(int i =0; i<noOfRows;i++){

                row = sh.getRow(i);
                Cell keyCell= row.getCell(0);
                Cell valueCell= row.getCell(1);
                dataMap.put(keyCell.getStringCellValue(),valueCell.getStringCellValue());

            }
        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
        return dataMap;
    }

    public static Object[][] getExcelDataMapAsPartOf2DArray(String fileName, String sheetName){
        Object[][] objData = new Object[1][1];
        objData[0][0]= getExcelDataMap(fileName,sheetName);
        return objData;
    }

    }
