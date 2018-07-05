
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ishwor Subedi
 */
public class DBConnection {
    private static java.sql.Connection con = null;
    private final String ConnectionURL = "jdbc:mysql://localhost:3306/studentInfo";
    
    private DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con  = DriverManager.getConnection(ConnectionURL,"root","");
        }
        catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static java.sql.Connection getConnection() {
        if (con != null) {
            return con;
        } else {
            new DBConnection();
            return con;
        }
    }
}
