
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CSVReader implements Reader {
    private Path path;

    @Override
//    public List<Map<String, Object>> read(String inputFilePath) {
////        List<Map<String, Object>> list = new ArrayList<>();
////        try (
////            BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath));
////            CSVParser csvParser = new CSVParser(reader,CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
////
////        ){
////            for (CSVRecord csvRecord: csvParser){
////                Map<String,Object> map = new HashMap<>();
////                System.out.println(csvRecord);
////                System.out.println(csvParser.getHeaderMap().get(1));
////
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return list;
////    }

    public List<Map<String, Object>> read(String inputFilePath) {
        List<Map<String, Object>> list = new ArrayList<>();
        try {

            path = Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes);
            String[] dataArray = content.split("\\r");
            for (int i = 1; i <dataArray.length; i++){
                Map<String,Object> map = new HashMap<>();
                String[] header = dataArray[0].split(";");
                String[] object = dataArray[i].split(";");
                for (int j = 0; j < object.length; j++){
                    map.put(header[j], object[j]);
                }
                list.add(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}