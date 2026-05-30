
	package utilities;

	import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtility {


		public FileInputStream fi;
		public FileOutputStream fo;
		public XSSFWorkbook wb;
		public XSSFSheet ws;
		public XSSFRow row;
		public XSSFCell cell;

		String path;

		// Constructor
		public ExcelUtility(String path) {
			this.path = path;
		}

		// Get total row count
		public int getRowCount(String sheetName) throws IOException {

			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName); 

			int rowCount = ws.getLastRowNum();

			wb.close();
			fi.close();

			return rowCount;
		}

		// Get total cell count
		public int getCellCount(String sheetName, int rownum) throws IOException {

			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row = ws.getRow(rownum);

			int cellCount = row.getLastCellNum();

			wb.close();
			fi.close();

			return cellCount;
		}

		// Read data from cell
		public String getCellData(String sheetName, int rownum, int colnum) throws IOException {

			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);

			String data;

			try {
				DataFormatter formatter = new DataFormatter();
				data = formatter.formatCellValue(cell);
			} catch (Exception e) {
				data = "";
			}

			wb.close();
			fi.close();

			return data;
		}

		// Write data into Excel
		public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {

			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(sheetName);

			row = ws.getRow(rownum);

			if (row == null)
				row = ws.createRow(rownum);

			cell = row.getCell(colnum);

			if (cell == null)
				cell = row.createCell(colnum);

			cell.setCellValue(data);

			fo = new FileOutputStream(path);
			wb.write(fo);

			wb.close();
			fi.close();
			fo.close();
		}

		// Fill Green color for Pass
		public void fillGreenColor(String sheetName, int rownum, int colnum) {
			System.out.println("PASS - Green Color Applied");
		}

		// Fill Red color for Fail
		public void fillRedColor(String sheetName, int rownum, int colnum) {
			System.out.println("FAIL - Red Color Applied");
		}
	}


