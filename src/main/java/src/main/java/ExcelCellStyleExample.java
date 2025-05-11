package src.main.java;

import org.apache.poi.hpsf.Currency;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ExcelCellStyleExample {

    public static void main(String[] args) {
//        // Create a new workbook and sheet
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Sheet1");
//
//        // Create a cell style
//        CellStyle currencyStyle = createCurrencyStyle(workbook);
//
//        // Create a row and cell
//        Row row = sheet.createRow(0);
//        Cell cell = row.createCell(0);
//        Cell cell1 = row.createCell(1);
//        // Set the cell value and apply the currency style
//        cell.setCellValue(12345.67);
//        cell.setCellStyle(currencyStyle);
//        cell1.setCellValue(-12345.67);
//        cell1.setCellStyle(currencyStyle);
//
//        // Write the workbook to a file or stream as needed
//        File file = new File("C:/Users/Admin/Downloads/test.xlsx");
//        try(FileOutputStream fos = new FileOutputStream(file)) {
//            workbook.write(fos);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Close the workbook to release resources
//        try {
//            workbook.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static CellStyle createCurrencyStyle(Workbook workbook){
//        // Create a cell style
//        CellStyle style = workbook.createCellStyle();
//
//        // Create a data format with a dynamic number format and currency symbol
//        DataFormat dataFormat = workbook.createDataFormat();
//        //String currencyFormat = getCurrencyFormat(); // Define your dynamic format here
//        style.setDataFormat(dataFormat.getFormat(
//                HSSFDataFormat.getBuiltinFormat("$#,##0.00")));
//       // style.setDataFormat(dataFormat.getFormat(getCurrencyFormat()));
//
//        return style;
//    }
//
//    private static String getCurrencyFormat() {
//        // You can customize this method to generate a dynamic currency format
//        // For example, you can include currency symbols based on user preferences or locale
//        //String p = "₹"; // Currency symbol
//        return String.format("S$#,##0.00");
//        //return String.format("[%s%s]#,###.00;[RED]-[%s%s]#,###.00", p, p, p, p);
////        currencyStyle.setDataFormat(format.getFormat(
////                "_₹* #,##0.00_ ;_₹* -#,##0.00_ ;_₹* \"-\"??_ ;_(@_)"
////        ));
    }
}
