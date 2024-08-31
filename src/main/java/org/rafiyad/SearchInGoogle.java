package org.rafiyad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchInGoogle {

    //create a function that takes a list of input and return a list of output
    //key ashbay readandwriteexel they

    public static void main(String[] args) throws InterruptedException {
        List<String> searchedResults = new ArrayList<>();

        //
        System.setProperty("webdriver.gecko.driver",
                "D:\\Java\\ReadAndWrite\\src\\main\\java\\org\\rafiyad\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://www.google.com/en");

        //WebElement click = driver.findElement(By.id("SIvCob"));

        WebElement boxClass = driver.findElement(By.className("gLFyf"));
        boxClass.sendKeys("Dhaka");
        Thread.sleep(2000);
        //aria-activedescendant
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        for (WebElement ele:elements){
            searchedResults.add(ele.getText());
            //System.out.println(ele.getText());
        }

        driver.quit();

        for (String st:searchedResults){
            System.out.println(st);
        }

    }
}

/*




    public static List<WebElement> findHighestAndLowestLength(List<WebElement> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new IllegalArgumentException("The list is either null or empty.");
        }

        // Initialize variables to store the WebElement with the highest and lowest text lengths
        WebElement highestLengthElement = elements.get(0);
        WebElement lowestLengthElement = elements.get(0);

        // Iterate through the list to find the required elements
        for (WebElement element : elements) {
            String text = element.getText();
            if (text.length() > highestLengthElement.getText().length()) {
                highestLengthElement = element;
            }
            if (text.length() < lowestLengthElement.getText().length()) {
                lowestLengthElement = element;
            }
        }

        // Create a list to store the results
        List<WebElement> result = new ArrayList<>();
        result.add(highestLengthElement);
        result.add(lowestLengthElement);

        return result;
    }


 */
