public class ReaderFactory {

    public Reader produce (String filePath){
        if (filePath.endsWith(".json")){
            return new JSONReader();
        }

        if (filePath.endsWith(".csv")){
            return new CSVReader();
        }

        if (filePath.endsWith(".xlsx")){
            return new ExcelReader();
        }
 
        return null;

    }


}
