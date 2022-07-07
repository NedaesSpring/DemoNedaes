package nedaes.demo.export;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public abstract class AbstractCommonExporter {

	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;
	
	protected List<String> columnNames;
	
	
	private void writeHeaderLine(List<String> columnNames) {
		sheet = workbook.createSheet("EXCEL");

		Row row = sheet.createRow(0);

		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		for (int i=0; i<columnNames.size(); i++) {
			createCell(row, i, columnNames.get(i), style);  
		}		
	}
	
	
	protected void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			if (((Boolean) value).booleanValue() == true) {
				cell.setCellValue("Sí");
			} else {
				cell.setCellValue("No");
			}
		} else if (value instanceof Date) {
			cell.setCellValue((Date) value);
		} else if (value instanceof Float) {
			cell.setCellValue((Float) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}
	
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine(columnNames);
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		
		workbook.close();

		outputStream.close();

	}
		
	protected abstract void writeDataLines();
	
}
