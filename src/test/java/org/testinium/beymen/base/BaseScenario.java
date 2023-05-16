package org.testinium.beymen.base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BaseScenario {

    static WebDriver webDriver=null;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(options));
        getWebDriver().navigate().to("https://www.beymen.com/");
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void setWebDriver (WebDriver webDriver){
        BaseScenario.webDriver= webDriver;
    }

    public String getTextFromExcel(int rowIndex, int cellIndex){
        String excelFilePath = "./files/products.xlsx";
        try (FileInputStream fis = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(cellIndex);
            return cell.getStringCellValue();
        } catch (IOException e) {
            return null;
        }
    }

    public void tearDown(){
        getWebDriver().quit();
    }
}
