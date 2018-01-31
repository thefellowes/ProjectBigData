package csv.to.sql;

//STEP 1. Import required packages
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class JDBC {
    // JDBC driver name, database URL and credentials
    public static final String USER = "root", PASS = "", DB_URL = "jdbc:mysql://localhost:3306/discordbot", JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static void execute( String query )
    {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName( JDBC_DRIVER );
            conn = DriverManager.getConnection( DB_URL, USER, PASS);
            System.out.println( "JDBC::Execute -> Connected, proceeding..." );

            stmt = conn.createStatement();
            stmt.execute( query );

            System.out.println( "JDBC::Execute -> Query executed" );
        }
        catch( SQLException se )
        {
            System.out.println( "JDBC::Execute -> Failed to connect!" );
            se.printStackTrace();
        }
        catch( Exception e )
        {
            System.out.println( "JDBC::Execute -> Failed to register driver" );
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if( stmt != null )
                    stmt.close();
            }
            catch(SQLException se2){
                System.out.println( "JDBC::Execute -> Failed to close statement" );
                se2.printStackTrace();
            }

            try
            {
                if( conn != null )
                    conn.close();
            }
            catch( SQLException se )
            {
                System.out.println( "JDBC::Execute -> Failed to close connection" );
                se.printStackTrace();
            }
        }
    }

    static void insert( String tablename, ArrayList<String> columns, ArrayList<String> values )
    {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName( JDBC_DRIVER );
            conn = DriverManager.getConnection( DB_URL, USER, PASS);
            System.out.println( "JDBC::Insert -> Connected, proceeding..." );

            String query = "INSERT INTO " + tablename + " ( ";

            for( String col : columns )
                query += col + ", ";

            query = query.substring( 0, query.length() - 2 );
            query += " ) VALUES ( " + "'";

            for( String val : values )
                query += val + "', '";

            query = query.substring( 0, query.length() - 3 );
            query += " );";

            System.out.println( "JDBC::Insert -> Query[" + query + "]" );

            stmt = conn.createStatement();
            stmt.executeQuery( query );

            System.out.println( "JDBC::Insert -> Query executed" );
        }
        catch( SQLException se )
        {
            System.out.println( "JDBC::Insert -> Failed to connect!" );
            se.printStackTrace();
        }
        catch( Exception e )
        {
            System.out.println( "JDBC::Insert -> Failed to register driver" );
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if( stmt != null )
                    stmt.close();
            }
            catch(SQLException se2){
                System.out.println( "JDBC::Insert -> Failed to close statement" );
                se2.printStackTrace();
            }

            try
            {
                if( conn != null )
                    conn.close();
            }
            catch( SQLException se )
            {
                System.out.println( "JDBC::Insert -> Failed to close connection" );
                se.printStackTrace();
            }
        }
    }

    static void update( String tablename, int primaryKey, ArrayList<String> values )
    {

    }

    static ArrayList<ArrayList> select( String query )
    {
        ArrayList<ArrayList> rows = new ArrayList<>();
        Statement stmt = null;
        Connection conn = null;

        try {
            Class.forName( JDBC_DRIVER );
            conn = DriverManager.getConnection( DB_URL, USER, PASS);
            System.out.println( "JDBC::Select -> Connected, proceeding..." );

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery( query );
            ResultSetMetaData rsmd = rs.getMetaData();

            while( rs.next() )
            {
                ArrayList tmp = new ArrayList();
                for( int i = 1; i <= rsmd.getColumnCount(); i++ )
                {
                    String name = rsmd.getColumnName( i );
                    tmp.add( rs.getString( name ) );
                }

                rows.add( tmp );
            }
            rs.close();

            System.out.println( "JDBC::Select -> Finished!" );
        }
        catch( SQLException se )
        {
            System.out.println( "JDBC::Select -> Failed to connect!" );
            se.printStackTrace();
        }
        catch( Exception e )
        {
            System.out.println( "JDBC::Select -> Failed to register driver" );
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if( stmt != null )
                    stmt.close();
            }
            catch(SQLException se2)
            {
                System.out.println( "JDBC::Select -> Failed to close statement" );
                se2.printStackTrace();
            }

            try
            {
                if( conn != null )
                    conn.close();
            }
            catch( SQLException se )
            {
                System.out.println( "JDBC::Select -> Failed to close connection" );
                se.printStackTrace();
            }
        }
        return rows;
    }

    static void createTable(String tableName, ArrayList<String> columns )
    {
        Statement stmt = null;
        Connection conn = null;

        try
        {
            Class.forName( JDBC_DRIVER );
            conn = DriverManager.getConnection( DB_URL, USER, PASS);
            System.out.println( "JDBC::createTable -> Connected, proceeding..." );

            stmt = conn.createStatement();

            String query = "CREATE TABLE IF NOT EXISTS " + tableName + " ( ";

            for( String col : columns )
                query += col + ", ";

            query = query.substring( 0, query.length() - 2 );

            query += " );";

            stmt.executeUpdate( query );
            System.out.println("JDBC::createTable -> Table created successfully...");
        }
        catch(SQLException se)
        {
            System.out.println( "JDBC::createTable -> Failed to execute query" );
            se.printStackTrace();
        }
        catch( Exception e )
        {
            System.out.println( "JDBC::createTable -> Failed to register driver" );
        }
        finally{
            try
            {
                if( stmt != null )
                    stmt.close();

            }
            catch(SQLException se2)
            {
                System.out.println( "JDBC::createTable -> Failed to close statement" );
                se2.printStackTrace();
            }

            try
            {
                if( conn != null )
                    conn.close();

            }
            catch( SQLException se )
            {
                System.out.println( "JDBC::createTable -> Failed to close connection" );
                se.printStackTrace();
            }
        }
    }
}