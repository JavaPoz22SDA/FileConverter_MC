import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONReader implements Reader {

    private Path path;

    @Override
    public void read(String inputFilePath) {
        try {
            path = Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
            System.out.println(bytes);
        } catch (IOException ex){
            ex.printStackTrace();
        }




    }
}
