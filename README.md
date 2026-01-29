# SearchKeywordBasedOnDayAndSaveInExcel

## Overview

`SearchKeywordBasedOnDayAndSaveInExcel` is a Java automation project that integrates **Selenium WebDriver** with **Apache POI** to perform keyword searches on Google and store results back into an Excel file. The program dynamically selects the sheet corresponding to the current day of the week, reads keywords from that sheet, performs searches, and then records the longest and shortest search suggestions returned by Google.

This project demonstrates how to combine browser automation with structured data storage, making it a useful example of integrating external APIs and libraries for real-world automation tasks. The motivation behind this project was to create a system that not only automates repetitive search tasks but also organizes the results in a structured format for later analysis.

---

## Project Structure and Files

### `SearchKeywordBasedOnDayAndSaveInExcel.java`

This is the main class and entry point of the project. It contains two major components:

1. **Helper Function: `findHighestAndLowestLength`**
   - Accepts an `ArrayList<String>` of search suggestions extracted from Google.
   - Iterates through the list to determine which suggestion has the longest length and which has the shortest.
   - Returns these two values as a string array.
   - **Design choice:** Instead of sorting the entire list, the function uses a simple iteration to minimize computational overhead. This is efficient because we only care about the extremes, not the full ordering.

2. **Main Method**
   - Determines the current day of the week using `LocalDate` and `DayOfWeek`.
   - Opens the Excel file (`sheet.xlsx`) using Apache POI.
   - Iterates through all sheets in the workbook until it finds the one matching the current day.
   - For each keyword in the sheet (rows 2–11, column 2), it:
      - Launches a Firefox browser via Selenium WebDriver.
      - Navigates to Google and enters the keyword.
      - Collects autocomplete suggestions from the search dropdown.
      - Passes these suggestions to the helper function to determine the longest and shortest.
      - Writes the results back into the Excel sheet (columns 3 and 4).
   - Saves the workbook and closes resources.

---

## How It Works

1. **Excel File Setup**
   - The Excel file (`sheet.xlsx`) must contain seven sheets, each named after a day of the week (e.g., `MONDAY`, `TUESDAY`, etc.).
   - Each sheet contains keywords in column 2 (starting from row 2).
   - The program will only process the sheet corresponding to the current system day.

2. **Browser Automation**
   - Selenium WebDriver is configured to use `geckodriver.exe` for Firefox.
   - For each keyword, the program opens Google, enters the keyword, and waits briefly for autocomplete suggestions to appear.
   - These suggestions are captured using an XPath query targeting the suggestion list.

3. **Result Processing**
   - The longest and shortest suggestions are identified.
   - Results are written back into the same row of the Excel file, in columns 3 and 4.

4. **File Output**
   - After processing all keywords for the day, the workbook is saved.
   - The program prints confirmation messages to the console.

---

## Design Choices

- **Excel as Data Source/Destination:**  
  Excel was chosen because it is widely accessible and easy to edit. Users can add or modify keywords without needing to learn SQL or set up a database.

- **Day-Based Sheet Selection:**  
  Organizing keywords by day allows for scheduled or thematic searches. For example, Monday could be dedicated to technology keywords, while Friday could focus on entertainment.

- **Longest/Shortest Suggestion Metric:**  
  Instead of storing all suggestions, the program records only the extremes. This reduces clutter in the Excel file while still capturing meaningful variation in search results.

- **Selenium with Firefox:**  
  Firefox was selected for compatibility and ease of setup with `geckodriver`. However, the program could easily be adapted to use Chrome or another browser.

- **Row Iteration (2–11):**  
  The program currently processes rows 2 through 11. This was a deliberate choice to leave the first row for headers and to limit the number of searches per run, avoiding excessive automation that might trigger Google’s anti-bot measures.

---

## Prerequisites

Before running the project, ensure you have:

- Windows 8 or later
- JDK 17 or later
- Apache Maven
- Apache POI library (for Excel handling)
- Selenium WebDriver library
- Firefox browser and `geckodriver.exe` placed in the `datafiles` folder
- An Excel file (`sheet.xlsx`) with sheets named after days of the week

---

## Installation and Usage

1. **Clone the Repository**
   ```bash
   git clone https://github.com/rafiyad/SearchKeywordBasedOnDayAndSaveInExcel.git
   cd SearchKeywordBasedOnDayAndSaveInExcel
