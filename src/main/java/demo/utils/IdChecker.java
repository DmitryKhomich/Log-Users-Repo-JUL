package demo.utils;
import demo.db.DbConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdChecker {
    public static boolean isProvidedIdValid(int id){

        String sql = "SELECT COUNT(id) FROM " + Constants.TABLE_USERS + " WHERE id = ?";

        try(PreparedStatement statement = DbConnect.setUpConnectionWithDB().prepareStatement(sql)){
            statement.setInt(1, id);

            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    return !resultSet.getBoolean(1);
                }
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return true;
    }
}
