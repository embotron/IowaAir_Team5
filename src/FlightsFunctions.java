import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;

/**
 * Created by crisi_000 on 3/30/2017.
 */
public class FlightsFunctions {
    public static void main( String[]  args){
        Connection connection = null;
        try {
            boolean working = false;
            connection = AccountFunctions.OpenDatabase();
            CreateFlightsTable(connection);
            java.util.Date date = new java.util.Date(02,14,2017);
            //AddFlight(connection, 1,);
            //working = checkLogin(connection,"test@gmail.com","test");
            //System.out.println(working);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    public static void CreateFlightsTable(Connection con)
    {
        Connection c = con;
        Statement stmt = null;
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE FLIGHTS " +
                    "(ID INT PRIMARY KEY     NOT NULL AUTO_INCREMENT," +
                    " PLANE_ID      INT     NOT NULL" +
                    " FOREIGN KEY (PLANE_ID) REFERENCES PLANES(ID) ON DELETE CASCADE" +
                    " DEPARTURE_DATE           DATE    NOT NULL, " +
                    " DEPARTURE_TIME        TIME     NOT NULL," +
                    " DEPARTURE_LOCATION         TEXT    NOT NULL," +
                    " ARRIVAL_DATE          DATE        NOT NULL," +
                    " ARRIVAL_TIME          TIME        NOT NULL)" +
                    " ARRIVAL_LOCATION        TEXT    NOT NULL,";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }




    public static void AddFlight(Connection con, int planeID, Date deptDate, Time deptTime, String deptLocation,
                                 Date arrivalDate, Time arrivalTime, String arrivalLocation)
    //i assume that if a plane has first class, it also has business and coach. If it has business it also has coach
    {
        Connection c = con;
        Statement stmt = null;
        try {

            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "INSERT INTO FLIGHTS (PLANE_ID,DEPARTURE_DATE,DEPARTURE_TIME,DEPARTURE_LOCATION,ARRIVAL_DATE,ARRIVAL_TIME,ARRIVAL_LOCATION) " +
                    "VALUES ( '" + planeID + "' , '" + deptDate + "' , '"+ deptTime +"' , '"+ deptLocation +"' , '"+ arrivalDate + "','" +
                    arrivalTime + "','" + arrivalLocation +"');";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            //c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
}
