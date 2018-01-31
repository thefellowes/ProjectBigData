package csv.to.sql;

public class ToSQL {

    public void write( String dataQuery, String tableQuery )
    {
        JDBC.execute( tableQuery );
        JDBC.execute( dataQuery );
    }
}


