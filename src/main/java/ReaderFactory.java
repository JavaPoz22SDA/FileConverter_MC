public class ReaderFactory {

    public Reader produce (String filePath){
        if (filePath.endsWith(".json")){
            return new JSONReader();
        }
        /*
        TO DO : CSVreader, EXCELREADER
         */

        return null;

    }


}
