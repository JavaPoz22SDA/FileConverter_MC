import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExcelWriter implements Writer{

    @Override
    public void write (String outputFilePath, List<Map<String,Object>> list){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row header = sheet.createRow(0);
        int column = 0;
        for (String string :list.get(0).keySet()){
            header.createCell(column).setCellValue(string);
            column++;
        }

        int rowNumber = 1;
        for (Map<String,Object> map : list){
            int cell = 0;
            Row row = sheet.createRow(rowNumber);
            for (Object object : map.values()){
                row.createCell(cell).setCellValue(object.toString());
                cell++;
            }
            rowNumber++;
        }

        try {
            OutputStream fileOutputStream = new FileOutputStream(outputFilePath);
            workbook.write(fileOutputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
