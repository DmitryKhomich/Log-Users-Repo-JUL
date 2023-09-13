package demo.db;
import demo.utils.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    public static Connection setUpConnectionWithDB(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(Constants.DB_DRIVER + Constants.DB_BASE_URL + Constants.DB_NAME);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
