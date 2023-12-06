/* JCE on Database Access
   Fall 2023
   Student: Cole Dombrowski
   Date: 12/6/2023
 */

package dombrowski.cole.jce7;

import java.sql.*;

public class JCE7
{
    // Build connection string
    final static String CON_STR = 
            "jdbc:mysql://localhost:3306/dombrowskic?user=root&password=bcis3680";

    public static void main(String[] args)
    {
        try
        {
            // Create connection object
            Connection conn = DriverManager.getConnection(CON_STR);
            
            // Create Statement object
            Statement stmt = conn.createStatement();

            // Create SQL statement
            String sqlSelect = "SELECT vend_id, vend_name FROM vendors;";

            // Run SQL statement
            ResultSet result = stmt.executeQuery(sqlSelect);

            // Store records into array list
            while (result.next())
            {
                System.out.println(result.getInt(1)
                + "\t" + result.getString(2));
            }
        }
        catch ( SQLException se )
        {
            System.out.println("ERROR: " + se.getMessage());
        }
    }
}