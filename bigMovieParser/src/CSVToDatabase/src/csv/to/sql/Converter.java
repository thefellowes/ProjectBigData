package csv.to.sql;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {

    public void Convert( String filename, String pattern, String substitution ) throws FileNotFoundException
    {
        FileReader fr = new FileReader("C:\\Users\\niels\\IdeaProjects\\CSVToDatabase\\tsv\\" + filename + ".tsv" );
        BufferedReader br = new BufferedReader(fr);

        // Variables
        String[] header = new String[]{};

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("C:\\Users\\niels\\IdeaProjects\\CSVToDatabase\\csv\\" + filename + ".csv")))
        {
            int counter = 0, c2 = 0;

            csvWriter.writeNext(header); //Nodig?
            Pattern r = Pattern.compile(pattern);

            String nextLine;

            while( ( nextLine = br.readLine() ) != null )
            {
                nextLine = nextLine.replace( "\\N", "null" );

                Matcher matcher = r.matcher(nextLine);

                String result = matcher.replaceAll(substitution);

                String[] line = result.split("\\t" );

                csvWriter.writeNext(line, true);
                counter++;

//                if( counter > 50 )
//                    break;

                if( counter % 100000 == 0 )
                {
                    c2++;
                    System.out.println( c2 + "00k done" );
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
