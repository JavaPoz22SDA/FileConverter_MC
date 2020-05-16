public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String sourceFilePath = "test.json";
        String outputFilePath = "test.xlsx";
        converter.convert(sourceFilePath,outputFilePath);

    }
}
