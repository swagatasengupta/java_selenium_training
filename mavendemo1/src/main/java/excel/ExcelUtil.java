package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	public static Object[][] getXLSTableDataProvider(String excelFileToRead, String sheetName, int headerRowNum) {
		Object[][] excelTable = null;
		FileInputStream excelFile = null;
		List<Object[]> excelTableAsList = new ArrayList<Object[]>();
		int startRow = headerRowNum;
		int lastRow;

		try {
			excelFile = new FileInputStream(excelFileToRead);
			HSSFWorkbook workBook = new HSSFWorkbook(excelFile);
			HSSFSheet workSheet = workBook.getSheet(sheetName);
			lastRow = workSheet.getLastRowNum();

			for (int currRow = startRow; currRow <= lastRow; currRow++) {
				HSSFRow row = workSheet.getRow(currRow);
				HSSFCell cell;
				int numCols = (row.getLastCellNum() - row.getFirstCellNum());
				Object[] rowObj = new Object[numCols];
				Iterator cells = row.cellIterator();
				int i = 0;
				FormulaEvaluator formulaEvaluator = workBook.getCreationHelper().createFormulaEvaluator();
				while (cells.hasNext()) {

					cell = (HSSFCell) cells.next();
					switch (formulaEvaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case BOOLEAN:
						rowObj[i] = cell.getBooleanCellValue();
						//System.out.println(rowObj[i]);
						break;
					case STRING:
						rowObj[i] = cell.getStringCellValue();
						//System.out.println(rowObj[i]);
						break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(cell)) {
							rowObj[i] = cell.getDateCellValue();
						} else {
							rowObj[i] = cell.getNumericCellValue();
						}
						//System.out.println(rowObj[i]);
						break;
					case ERROR:
						rowObj[i] = cell.getErrorCellValue();
						//System.out.println(rowObj[i]);
						break;
					case BLANK:
						rowObj[i] = "";
						//System.out.println(rowObj[i]);
						break;
					default:
						rowObj[i] = cell.getStringCellValue();
						//System.out.println(rowObj[i]);
						break;
					}

					i++;
				}
				excelTableAsList.add(rowObj);
			}
			excelFile.close();
		} catch (IOException e) {
			System.out.println("Error in reading: " + excelFileToRead + ". " + e.getMessage());
		}

		excelTable = excelTableAsList.toArray(new Object[excelTableAsList.size()][]);
		return excelTable;

	}

	public static Object[][] getXLSXTableDataProvider(String excelFileToRead, String sheetName, int headerRowNum) {
		Object[][] excelTable = null;
		FileInputStream excelFile = null;
		List<Object[]> excelTableAsList = new ArrayList<Object[]>();
		int startRow = headerRowNum;
		int lastRow;
		try {
			excelFile = new FileInputStream(excelFileToRead);
			Workbook workBook = new XSSFWorkbook(excelFile);
			Sheet workSheet = workBook.getSheet(sheetName);
			lastRow = workSheet.getLastRowNum();
			for (int currRow = startRow; currRow <= lastRow; currRow++) {
				Row row = workSheet.getRow(currRow);
				Cell cell;
				int numCols = (row.getLastCellNum() - row.getFirstCellNum());
				Object[] rowObj = new Object[numCols];
				Iterator cells = row.cellIterator();
				int i = 0;
				FormulaEvaluator formulaEvaluator = workBook.getCreationHelper().createFormulaEvaluator();
				while (cells.hasNext()) {

					cell = (Cell) cells.next();
					switch (formulaEvaluator.evaluateInCell(cell).getCellTypeEnum()) {
					case BOOLEAN:
						rowObj[i] = cell.getBooleanCellValue();
						//System.out.println(rowObj[i]);
						break;
					case STRING:
						rowObj[i] = cell.getStringCellValue();
						//System.out.println(rowObj[i]);
						break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(cell)) {
							rowObj[i] = cell.getDateCellValue();
						} else {
							rowObj[i] = cell.getNumericCellValue();
						}
						//System.out.println(rowObj[i]);
						break;
					case ERROR:
						rowObj[i] = cell.getErrorCellValue();
						//System.out.println(rowObj[i]);
						break;
					case BLANK:
						rowObj[i] = "";
						//System.out.println(rowObj[i]);
						break;
					
					default:
						rowObj[i] = cell.getStringCellValue();
						//System.out.println(rowObj[i]);
						break;
					}

					i++;
				}
				excelTableAsList.add(rowObj);
				
			}
			excelFile.close();
		} catch (IOException e) {
			
		}
		
		excelTable = excelTableAsList.toArray(new Object[excelTableAsList.size()][]);
		return excelTable;
	}

}
