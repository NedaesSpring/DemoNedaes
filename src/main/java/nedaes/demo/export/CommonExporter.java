package nedaes.demo.export;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;



public class CommonExporter<T> {

 
	public static List<Cell> writeHeaderLine(List<String> columnNames,String titulo,CellStyle style,Row row) {
		
		
		
		List<Cell> Celdas = new ArrayList<Cell>();
		for (int i=0; i<columnNames.size(); i++) {
			Celdas.add(createCell(row, i, columnNames.get(i), style));  
		}	
		
		return Celdas;
	}
	
	
	public static  Cell createCell(Row row, int columnCount, Object value, CellStyle style
			) {
		
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
		return cell;
	}
	
	public static void export(HttpServletResponse response,SXSSFWorkbook workbook) throws IOException {
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}
