import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CSVWriter implements Writer {


    @Override
    public void write(String outputFilePath, List<Map<String, Object>> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            StringBuilder builder = new StringBuilder();
            int counter = 0;
            int mapSize = list.get(0).keySet().size();
            for (String string :list.get(0).keySet()){
                if (counter < mapSize - 1) {
                    builder.append(string).append(";");
                    counter++;
                 } else {
                    builder.append(string).append("\n");
                }
            }
            for (Map<String,Object> map : list){
                int counterMap = 0;
                for (Object object : map.values()){
                    if (counterMap < mapSize - 1){
                        builder.append(object.toString()).append(";");
                        counterMap++;
                    } else {
                        builder.append(object.toString()).append("\n");
                    }
                }
            }
            writer.write(builder.toString());
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
