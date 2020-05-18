public class WriterFactory {

    public Writer produce (String filePath){

        if (filePath.endsWith(".json")){
            return new JSONWriter();
        }

        if (filePath.endsWith(".csv")){
            return new CSVWriter();
        }

        if (filePath.endsWith(".xlsx")){
            return new ExcelWriter();
        }

        return null;

    }
}
