package org.rafiyad;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteInExcel {

    //this class will be read and write in Excel
    public void readAndWrite(String filePath){
        //getting current day of the week
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println("Date from the system "+dayOfWeek);

        //Creating a list for storing keywords that have to be searched
        List<String> extractedKey = new ArrayList<>();

        //Call a function that retuen a list
        String [] result = {"Public university in Dhaka, Bangladesh","Dhaka"};


        try {
            FileInputStream fis = new FileInputStream(filePath);

            Workbook workbook = new XSSFWorkbook(fis);

            // Iterate through each sheet in the workbook
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();

                if(sheetName.equalsIgnoreCase(String.valueOf(dayOfWeek))){
                    System.out.println("File selected "+sheetName);
                    // Iterate through each row in the sheet
                    for(int j=2;j<12;j++){
                        Row row = sheet.getRow(j); // Row 0 is the first row
                        Cell cell = row.getCell(2); // Column 0 is the first column
                        String value = cell.getStringCellValue();
                        extractedKey.add(value);
                        //System.out.println(value);
                    }
                   /* Row row = sheet.getRow(2);
                    Cell cell = row.getCell(3);
                    String wCell = cell.getStringCellValue();
                    System.out.println(wCell);*/
                }
                //Writing the highest value in the excel
                Row hRow = sheet.getRow(2);
                Cell hCell = hRow.createCell(3);
                hCell.setCellValue(result[0]);
                //Writing the lowest value in the excel
                Row lRow = sheet.getRow(2);
                Cell lCell = lRow.createCell(4);
                lCell.setCellValue(result[1]);

                FileOutputStream fos = new FileOutputStream(filePath);
                workbook.write(fos);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
