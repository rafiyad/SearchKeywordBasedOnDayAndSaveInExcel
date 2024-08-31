package org.rafiyad;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchKeywordBasedOnDayAndSaveInExcel {
    //Function that returns highest and lowest searched value
    public static String[] findHighestAndLowestLength(ArrayList<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The list is either null or empty.");
        }

        // Initialize variables to store the highest and lowest length strings
        String highestLengthString = list.get(0);
        String lowestLengthString = list.get(0);

        // Iterate through the list to find the highest and lowest key
        for (String str : list) {
            if (str.length() > highestLengthString.length()) {
                highestLengthString = str;
            }
            if (str.length() < lowestLengthString.length()) {
                lowestLengthString = str;
            }
        }

        // Return the results as an array
        return new String[]{highestLengthString, lowestLengthString};
    }


    public static void main(String[] args){

        //Finding current file path and                      adding folder location in the end
        String rootPath = System.getProperty("user.dir")+"\\SearchKeywordBasedOnDayAndSaveInExcel\\datafiles";
        System.out.println(rootPath);
        String filePath = rootPath+"\\4BeatsQ1.xlsx";
        String webDriverPath =rootPath+"\\geckodriver.exe";

        //Setting up the webdriver for automation and
        System.setProperty("webdriver.gecko.driver", webDriverPath);

        //Finding local day of the week
        LocalDate today = LocalDate.now();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println("Date from the system "+dayOfWeek);



        try {
            //Creating input file stream for file reading
            FileInputStream fis = new FileInputStream(filePath);
            //Creating workboor for opening and writing in Excel file
            Workbook workbook = new XSSFWorkbook(fis);

            // Iterate through each sheet in the workbook
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();

                //Find and match the current day of the week
                if(sheetName.equalsIgnoreCase(String.valueOf(dayOfWeek))){
                    System.out.println(sheetName + " sheet is selected.");
                    // Iterate through each row in the sheet and adding the arraylist
                    for(int j=2;j<12;j++){
                        Row row = sheet.getRow(j);
                        Cell cell = row.getCell(2);
                        String value = cell.getStringCellValue();

                        //Luching the web browser and wait for 2 seconds
                        WebDriver driver = new FirefoxDriver();
                        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                        driver.get("http://www.google.com/en");

                        //Search box class id to locate search box in the browser
                        WebElement boxClass = driver.findElement(By.className("gLFyf"));
                        boxClass.sendKeys(value);
                        Thread.sleep(2000);

                        //Creating a list for storing keywords that have to be searched
                        ArrayList<String> extractedKey = new ArrayList<>();

                        //Capturing all the searched result in a WebElement List
                        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
                        for (WebElement element:elements){
                            extractedKey.add(element.getText());
                        }
                        driver.quit();


                        //Storing the high and low value in the results array
                        String[] results=findHighestAndLowestLength(extractedKey);

                        //Saving the highest value
                        Row hRow = sheet.getRow(j);
                        Cell hCell = hRow.createCell(3);
                        hCell.setCellValue(results[0]);
                        //Saving the lowest value
                        Row lRow = sheet.getRow(j);
                        Cell lCell = lRow.createCell(4);
                        lCell.setCellValue(results[1]);

                        //File writing operations
                        FileOutputStream fos = new FileOutputStream(filePath);
                        workbook.write(fos);
                        fos.close();
                    }
                }
                //Writing the highest value in the excel
                fis.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All files written successfully");
    }
}
