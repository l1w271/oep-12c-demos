
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;


public class TestDerby
{
    private static String dbURL = "jdbc:derby://localhost:1527/ShoppingDemoDB;user=shopping;password=shopping";
    //private static String dbURL = "jdbc:derby:/Users/Lloyd/DERBYTUTOR/shoppingdb;user=shopping;password=shopping";
    //connect 'jdbc:derby:/home/bill/databases/MyDbTest';
    private static String tableName = "SHOPPING.CUSTOMER";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    public TestDerby() {
        super();
    }

    
    public static void main(String[] args)
    {
        TestDerby testDerby = new TestDerby();
        
        System.out.println("Testing Derby!");
        
        createConnection();
        //insertCustomer("Lloyd001", "Lloyd", "Williams", 5677.88d, 1);
        selectCustomers();
        shutdown();
    }
    
    private static void createConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL); 
        }
        catch (Exception except)
        {
            except.printStackTrace();
        }
    }
    
    private static void insertCustomer(String customerID, String firstName, String lastName, double totalPurchases, int loyaltyStatus )
    {
        try
        {
            stmt = conn.createStatement();
            stmt.execute("insert into " + tableName + " values (" +
                    "'" + customerID + "','" + firstName + "','" + lastName + "'," + totalPurchases + "," + loyaltyStatus + ")");
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void selectCustomers()
    {
        try
        {
            stmt = conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName);
            ResultSetMetaData rsmd = results.getMetaData();
            int numberCols = rsmd.getColumnCount();
            for (int i=1; i<=numberCols; i++)
            {
                //print Column Names
                System.out.print(rsmd.getColumnLabel(i)+"\t\t");  
            }

            System.out.println("\n-------------------------------------------------");

            while(results.next())
            {
                String customerID = results.getString(1);
                String firstName = results.getString(2);
                String lastName = results.getString(3);
                double totalPurchases = results.getDouble(4);
                int loyaltyStatus = results.getInt(5);
                System.out.println(customerID + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + totalPurchases + "\t\t" + loyaltyStatus);
            }
            results.close();
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            sqlExcept.printStackTrace();
        }
    }
    
    private static void shutdown()
    {
        try
        {
            if (stmt != null)
            {
                stmt.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            //sqlExcept.printStackTrace();
            sqlExcept.getErrorCode();
            //System.out.println("End!");
        }

    }
}