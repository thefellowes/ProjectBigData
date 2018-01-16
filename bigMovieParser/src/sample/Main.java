package sample;

import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Which list would you like to export to CSV?");

        // Constants
        String IMDBpath = "DatabaseIMDB/"; // TODO: !!

        // Init the readers
        Scanner s = new Scanner(System.in);
        String choice = s.next().toLowerCase();
        FileReader fr = new FileReader(IMDBpath + choice.toLowerCase() + ".list");
        BufferedReader br = new BufferedReader(fr);

        // Variables
        String pattern;
        String substitution;
        String[] header;

        // Loading the patterns for parsing into .CSV files
        switch (choice)
        {
            case "countries":
                pattern = "";    //								\"\W(.+?)"\s\(([A-Za-z0-9?I\/_.]+?)\)(?(?=\s\{\{)\s\{\{(.+?)\}\})(?(?=\s\{)\s\{(.+?)\s\(\#(.+?)\)\}\s*(.+)|\s*(.+))
                substitution = "$1-$2-$4-$6-$8-$9";
                header = new String[]{};
                break;
            case "movies":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            case "series":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            case "actors":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            case "actresses":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            case "directors":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            case "producers":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            case "ratings":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            case "running-times":
                pattern = "";
                substitution = "";
                header = new String[]{};
                break;
            default:
                pattern = "";
                substitution = "";
                header = new String[]{};
                System.out.println("File not found");
                System.exit(0);
                break;
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(IMDBpath + "CSV/" + choice.toLowerCase() + ".csv")))
        {
            int count = 0; // TODO: Remove count, in de huidige situatie doorloopt hij alleen de eerste 150 regels van het plaintext bestand.

            csvWriter.writeNext(header); // TODO: Nodig?

            Pattern r = Pattern.compile(pattern);

            while (br.readLine() != null && count < 150)
            {
                String nextLine = br.readLine();

                Matcher matcher = r.matcher(nextLine);

                String result = matcher.replaceAll(substitution);

                String[] line = result.split("-");

                csvWriter.writeNext(line, true);

                count++;
            }
        }
    }
}
