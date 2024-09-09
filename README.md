# SearchKeywordBasedOnDayAndSaveInExcel

## Description

`SearchKeywordBasedOnDayAndSaveInExcel` is a Java application designed to search for saved keywords in excel file, based on the current day and save the results in an Excel file. The project uses Selenium WebDriver for web scraping and Apache POI for handling Excel files.

### What will do

- It will select the current day of the week from the system.
- The excel sheet has seven days and the keywords that has to be searched on Google.
- It will select the current day sheet.
- It will search in Google based on the keywords saved in excel file.
- It will store the longest and shortest search result from Google in the excel file.

## Prerequisites

Before you start, make sure you have the following installed:

- JDK 17 or later
- Apache Maven
- A web browser (e.g., Chrome, Firefox) and the corresponding WebDriver (e.g., `chromedriver`, `geckodriver`)
- Reload pom.xml

![Github](https://github.com/user-attachments/assets/c7e4b636-169a-4627-ae2a-4b32e3763a03)

## Installation

1. **Clone the Repository**

   First, clone the repository to your local machine:
   ```bash
   git clone https://github.com/rafiyad/SearchKeywordBasedOnDayAndSaveInExcel.git
   cd SearchKeywordBasedOnDayAndSaveInExcel
