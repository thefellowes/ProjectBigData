package csv.to.sql;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CSVToSql {

    private String filePath;
    private BufferedReader br = null;
    private String line = "";
    private String splitter = ",";

    public CSVToSql( String filePath, String splitter )
    {
        this.filePath = filePath;
        this.splitter = splitter;
    }

    public ArrayList<List<String>> convertToSql( )
    {
        ArrayList<List<String>> output = new ArrayList<>();

        try {
            this.br = new BufferedReader(new FileReader(this.filePath));
            while ((this.line = br.readLine()) != null) {

                output.add( Arrays.asList( line.split( this.splitter ) ) );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return output;
    }

}
