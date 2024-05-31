package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestReportFailedData {
    public static void main(String[] args) {
        ArrayList<String> newFailedTestCaseNames = new ArrayList<>();
        ArrayList<String> newPassedTestCaseNames = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter New File Name : ");
        String newFilename = sc.nextLine();
        System.out.print("Enter Old File Name : ");
        String oldFilename = sc.nextLine();
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\Siddharth Sarkhel\\Downloads\\"+newFilename);
        Actions action = new Actions(driver);
        action
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"controls\"]/div/div[1]/a")))
                .click(driver.findElement(By.xpath("//*[@id=\"tests-toggle\"]/li[2]")))
                .build().perform();
        List<WebElement> newFailedTestcases = driver.findElements(By.xpath("//li[@status=\"fail\"]/div/span[1]"));
        System.out.println("New File Failed Cases Number : "+newFailedTestcases.size());
        for (WebElement temp: newFailedTestcases){
            action.scrollToElement(temp).perform();
            newFailedTestCaseNames.add(temp.getText());
        }
        System.out.println(newFailedTestCaseNames);

        action
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"controls\"]/div/div[1]/a")))
                .click(driver.findElement(By.xpath("//*[@id=\"tests-toggle\"]/li[1]")))
                .build().perform();
        List<WebElement> newPassedTestcases = driver.findElements(By.xpath("//li[@status=\"pass\"]/div/span[1]"));
        System.out.println("New File Passed Cases Number : "+newPassedTestcases.size());
        for (WebElement temp: newPassedTestcases){
            action.scrollToElement(temp).perform();
            newPassedTestCaseNames.add(temp.getText());
        }
        System.out.println(newPassedTestCaseNames);

        ArrayList<String> oldFailedTestCaseNames = new ArrayList<>();
        ArrayList<String> oldPassedTestCaseNames = new ArrayList<>();
        driver.get("C:\\Users\\Siddharth Sarkhel\\Downloads\\"+oldFilename);
        action
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"controls\"]/div/div[1]/a")))
                .click(driver.findElement(By.xpath("//*[@id=\"tests-toggle\"]/li[2]")))
                .build().perform();
        List<WebElement> oldFailedTestcases = driver.findElements(By.xpath("//li[@status=\"fail\"]/div/span[1]"));
        System.out.println("Old File Failed Cases Number : "+oldFailedTestcases.size());
        for (WebElement temp: oldFailedTestcases){
            action.scrollToElement(temp).perform();
            oldFailedTestCaseNames.add(temp.getText());
        }
        System.out.println(oldFailedTestCaseNames);

        action
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"controls\"]/div/div[1]/a")))
                .click(driver.findElement(By.xpath("//*[@id=\"tests-toggle\"]/li[1]")))
                .build().perform();
        List<WebElement> oldPassedTestcases = driver.findElements(By.xpath("//li[@status=\"pass\"]/div/span[1]"));
        System.out.println("Old File Passed Cases Number : "+oldPassedTestcases.size());
        for (WebElement temp: oldPassedTestcases){
            action.scrollToElement(temp).perform();
            oldPassedTestCaseNames.add(temp.getText());
        }
        System.out.println(oldPassedTestCaseNames);

        ArrayList<String> finalNewFailedTestCaseNames = new ArrayList<>();
        for (int i=0; i< newFailedTestCaseNames.size(); i++){
            if (!oldFailedTestCaseNames.contains(newFailedTestCaseNames.get(i))){
                finalNewFailedTestCaseNames.add(newFailedTestCaseNames.get(i));
            }
        }
        ArrayList<String> finalNewPassedTestCaseNames = new ArrayList<>();
        for (int i=0; i< newFailedTestCaseNames.size(); i++){
            if (!oldPassedTestCaseNames.contains(newPassedTestCaseNames.get(i))){
                finalNewPassedTestCaseNames.add(newFailedTestCaseNames.get(i));
            }
        }
        driver.quit();
//        String[] headers = {"Failed TestCases"};
//        for (int i = 0; i < headers.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(headers[i]);
//        }

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheetFail = workbook.createSheet("New Failed");
        Sheet sheetPass = workbook.createSheet("New Passed");
//        Row headerRow = sheetFail.createRow(0);

        int rowNum = 1;
        for (String field : finalNewFailedTestCaseNames) {
            Row row = sheetFail.createRow(rowNum);
            Cell cell = row.createCell(0);
            cell.setCellValue(field);
            rowNum++;
        }
        rowNum = 1;
        for (String field : finalNewPassedTestCaseNames) {
            Row row = sheetPass.createRow(rowNum);
            Cell cell = row.createCell(0);
            cell.setCellValue(field);
            rowNum++;
        }

        try (FileOutputStream fileOut = new FileOutputStream("NewReportStatus.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file has been created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
