package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<String> Person = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(new File("D:\\RegisterData.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0); // Assuming you want to read from the first sheet
        int rowCount = sheet.getLastRowNum() + 1;
        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            int cellCount = row.getLastCellNum();
            for (int j = 0; j < cellCount; j++) {
                Cell cell = row.getCell(j);
                // Process the cell value as needed
                DataFormatter dataFormatter = new DataFormatter();
                String formattedCellStr = dataFormatter.formatCellValue(cell);
                Person.add(formattedCellStr);
            }
            js.executeScript("document.getElementById('countries').remove();");
            js.executeScript("document.getElementsByClassName('col-md-3 col-xs-3 col-sm-3 control-label')[0].remove();");
            driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(Person.getFirst());
            driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(Person.get(1));
            driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(Person.get(2));
            driver.findElement(By.xpath("//input[@ng-model='EmailAdress']")).sendKeys(Person.get(3));
            driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys(Person.get(4));
            driver.findElement(By.xpath("//input[@value='" + Person.get(5) +"']")).click();
            driver.findElement(By.xpath("//input[@value='"+Person.get(6)+"']")).click();
            driver.findElement(By.xpath("//div[@id='msdd']")).click();
            driver.findElement(By.xpath("//a[text() = '"+Person.get(7)+"']")).click(); // or //a[text() = 'English']
            driver.findElement(By.className("row")).click();

            Select drpSkills = new Select(driver.findElement(By.xpath("//select[@id='Skills']")));
            drpSkills.selectByVisibleText(Person.get(8));
            driver.findElement(By.className("row")).click();
            driver.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();
            driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Person.get(9));
            driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Keys.RETURN);
            Select drpYear = new Select(driver.findElement(By.xpath("//select[@placeholder='Year']")));
            drpYear.selectByVisibleText(Person.get(10));
            Select drpMonth = new Select(driver.findElement(By.xpath("//select[@placeholder='Month']")));
            drpMonth.selectByValue(Person.get(11));
            Select drpDay = new Select(driver.findElement(By.xpath("//select[@placeholder='Day']")));
            drpDay.selectByVisibleText(Person.get(12));
            driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys(Person.get(13));
            driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys(Person.get(14));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(1000);
            Person.removeAll(Person);
            if(i != rowCount-1){
                driver.navigate().refresh();
            }

        }
        workbook.close();
        inputStream.close();

        driver.quit();
    }
}
