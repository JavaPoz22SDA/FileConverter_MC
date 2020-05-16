public class ReaderFactory {

    public Reader produce (String filePath){
        if (filePath.endsWith(".json")){
            return new JSONReader();
        }

        if (filePath.endsWith(".csv")){
            return new CSVReader();
        }
        /*
        TO DO : CSVreader, EXCELREADER
         */

        return null;

    }


}
