import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

public class Controller {
    //        System.out.println("Hello World!");
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/discordbot";
    static final String USER = "root";
    static final String PASS = "";

    static public String removeCrap(String line)
    {
        line = line.replace("\"", "");
        line = line.replace("'", "");
        line = line.replace("#", "");
        line = line.replace("$", "");
        line = line.replace("*", "");
        return line;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Connection conn = null;
        Statement stmt = null;
        String csvFile = "/Bigdata/csv/countries.csv";
        String line = "";
        String cvsSplitBy = ",";
        int count = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database connected successfully...");
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String line_filt = removeCrap(line);
                String[] plines = line_filt.split(cvsSplitBy);
                if (plines.length == 3)
                {
                    for (int i = 0; i < plines.length; i++)
                        plines[i] = plines[i].trim();

                    stmt = conn.createStatement();
                    int year = -1;
                    try {
                        year = Integer.parseInt(plines[1]);
                    }
                    catch (NumberFormatException e) {}

                    if (year != -1) {
                        try {
                            String sql = "INSERT INTO countries " +
                                    "VALUES (" + count + ", '" + plines[0] + "', " + plines[1] + ", '" + plines[2] + "')";
                            stmt.executeUpdate(sql);
                            count++;
                        }
                        catch (SQLException e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se) {
            }// the database is corrupt
            try {
                if (conn != null)
                    conn.close();
            }
            catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }
        System.out.println("Goodbye!");
    }
}
//                    String print = count + ".countries [";
//                    for (int i = 0; i < plines.length; i++)
//                    {
//                        if (plines[i].isEmpty() || plines[i] == null)
//                            plines[i] = "niks";
//                        print += " line" + i + "=" + plines[i];
//                        //print += plines[i];
//                    }
//                    System.out.println(print + "]");