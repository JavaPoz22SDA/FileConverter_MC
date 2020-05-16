public class Converter {

    public void convert(String sourceFilePath, String outputFilePath) {
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        reader.read(sourceFilePath);

        if (reader instanceof JSONReader) {
            System.out.println("Działa, mam obiekt JSONReader");
        }
    }
}
