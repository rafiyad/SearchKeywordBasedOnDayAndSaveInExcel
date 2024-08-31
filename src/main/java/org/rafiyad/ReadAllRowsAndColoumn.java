package org.rafiyad;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadAllRowsAndColoumn {
    String excelFilePath = "D:\\Java\\ReadAndWrite\\src\\main\\java\\org\\rafiyad\\4BeatsQ1.xlsx";
    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ReadAllRowsAndColoumn(){

        try {
            FileInputStream fis =new FileInputStream(new File(this.excelFilePath));
            System.out.println("File input stream created successfully");
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheetAt(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readSheetData() {
        Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext()){
            Row currRow = rows.next();
            Iterator<Cell> cells = currRow.cellIterator();
            while (cells.hasNext()){
                Cell currCell = cells.next();
               String value= currCell.getStringCellValue();
                System.out.println("Value for cell: "+value);
            }
        }
    }


    public static void main(String[] args) {
        ReadAllRowsAndColoumn read = new ReadAllRowsAndColoumn();
        read.readSheetData();







    }















}
