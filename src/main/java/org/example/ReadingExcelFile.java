package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcelFile {
    public void readExcelFile(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(filePath));
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
                System.out.print(formattedCellStr + " ");
            }
            System.out.println();
        }
        workbook.close();
        inputStream.close();
    }
    public static void main(String[] args) throws IOException {
        ReadingExcelFile obj = new ReadingExcelFile();
        obj.readExcelFile("D:\\RegisterData.xlsx");
    }
}
