import java.util.List;
import java.util.Map;

public interface Writer {

    public void write (String outputFilePath, List<Map<String,Object>> list);
}
