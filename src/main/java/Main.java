public class Main {
    public static void main(String[] args) {

        Converter converter = new Converter();
        String sourceFilePath = "test.csv";
        String outputFilePath = "testOut.json";
        converter.convert(sourceFilePath, outputFilePath);

    }
}