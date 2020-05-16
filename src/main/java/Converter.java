import java.io.ObjectInput;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.Map;

public class Converter {

    public void convert(String sourceFilePath, String outputFilePath) {
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        List<Map<String, Object>> list = reader.read(sourceFilePath);
        System.out.println(list);

        if (reader instanceof JSONReader) {
            System.out.println("Działa, mam obiekt JSONReader");
        }
    }
}
