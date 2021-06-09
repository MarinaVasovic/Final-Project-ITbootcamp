package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static XSSFWorkbook wb;
	public static Sheet sheet;

	public static void readFromExcelFile(String path) {
		File f = new File(path);
		try {
			InputStream is = new FileInputStream(f);
			wb = new XSSFWorkbook(is);

		} catch (IOException e) {
			System.out.println("File is not found on this location: " + path);
		}
	}

	public static void getSheet(int indexSheeta) {
		sheet = wb.getSheetAt(indexSheeta);
	}

	public static int getNumberOfRows() {
		return sheet.getLastRowNum();
	}

	public static String getData(int rowIndex, int cellIndex) {
		Row row = sheet.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		return cell.toString();

	}

}
