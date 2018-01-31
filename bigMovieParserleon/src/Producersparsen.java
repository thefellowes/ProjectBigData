import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Producersparsen {
    public static void main(String[] args) throws IOException {

        String IMDBpath = "C:\\"; //pad van waar producers zich bevind
        String filename = IMDBpath + "producers.list";
        int startLine = 220;

        FileReader reader = new FileReader(filename);
        BufferedReader br = new BufferedReader(reader);
        String line;
        int lineCount = 0;
        String lastProducer = "";
        while ((line = br.readLine()) != null) {
            lineCount++;

            if(lineCount < startLine || line.isEmpty()) {
                continue;
            }

            String[] columns = line.split("(\t)+");
            String credit = columns[1];
            if (line.charAt(0) != '\t') {
                lastProducer = columns[0];

            }
            String[] creditColumns =  credit.split("\\(|\\)");
            String movie = creditColumns[0].trim().replace("\"", "");
            String year = creditColumns[1];
            System.out.println(lastProducer + "|" + movie + "|" + year);
        }
    }

}
