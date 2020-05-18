import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONWriter implements Writer {

    @Override
    public void write(String outputFilePath, List<Map<String, Object>> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            JSONArray jsonArray = new JSONArray();
            for (Map<String,Object> map : list) {
                JSONObject jsonObject = new JSONObject();
                for (String string : map.keySet()){
                    jsonObject.put(string,map.get(string));
                }
                jsonArray.put(jsonObject);
            }
            writer.write(jsonArray.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
