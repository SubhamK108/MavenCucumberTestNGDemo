package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {
    private XSSFWorkbook workbook;

    public ExcelReader() {
        try {
            final String fileSeparator = System.getProperty("file.separator");
            final String folderPath = System.getProperty("user.dir") + fileSeparator + "Resources";
            final String fileName = "TestData.xlsx";
            final String filePath = folderPath + fileSeparator + fileName;
            File excelFile = new File(filePath);
            FileInputStream inputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(inputStream);
        } catch (Exception e) {
            System.out.println("Excel file not found!");
        }
    }

    public Row getRowBySheetAndIndex(String sheetName, int rowIndex) {
        return workbook.getSheet(sheetName).getRow(rowIndex);
    }

    public String getCellData(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        if (cell == null)
            return "";
        else if (cell.getCellType() == CellType.NUMERIC)
            return String.valueOf((int) cell.getNumericCellValue());
        else
            return cell.getStringCellValue();
    }
}
