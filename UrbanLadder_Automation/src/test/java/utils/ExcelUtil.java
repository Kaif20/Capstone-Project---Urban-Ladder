package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {
    public static Map<String, String> getTestData(String filePath, String sheetName, int rowNum) throws Exception {
        Map<String, String> data = new HashMap<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row headerRow = sheet.getRow(0); // Headers in first row
        Row dataRow = sheet.getRow(rowNum); // Data from specified row

        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            String key = headerRow.getCell(i).getStringCellValue();
            String value = dataRow.getCell(i) != null ? dataRow.getCell(i).getStringCellValue() : "";
            data.put(key, value);
        }

        workbook.close();
        fis.close();
        return data;
    }
}