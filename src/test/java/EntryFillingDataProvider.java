import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntryFillingDataProvider {
    @DataProvider(name = "ExcelDataProvider")
    public Iterator<ArrayList<String>> getData() throws IOException {
        ArrayList<String> Person = new ArrayList<>();
        List<ArrayList<String>> Persons = new ArrayList<ArrayList<String>>();
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
            Persons.add(new ArrayList<>(Person));
            Person.removeAll(Person);
        }

        return Persons.iterator();
    }
}
