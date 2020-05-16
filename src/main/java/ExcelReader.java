import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ExcelReader implements Reader {
    @Override
    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String,Object>> list = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(inputFilePath));

            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
            Row header = sheet.getRow(0);
                while (rowIterator.hasNext()) {
                    Map<String, Object> map = new HashMap<>();
                    Row row = rowIterator.next();
                    for (int i = 0; i <numberOfColumn; i++) {
                    map.put(header.getCell(i).toString(), row.getCell(i));
                }
                    list.add(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
