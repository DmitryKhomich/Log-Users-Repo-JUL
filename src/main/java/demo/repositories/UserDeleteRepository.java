package demo.repositories;

import demo.db.DbConnect;
import demo.entities.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import demo.utils.*;

public class UserDeleteRepository {

    private static final Logger LOGGER = Logger.getLogger(UserDeleteRepository.class.getName());

    public String deleteUser (User user){
        String sql = "DELETE FROM " + Constants.TABLE_USERS + " WHERE id = ?";

        try(PreparedStatement statement = DbConnect.setUpConnectionWithDB().prepareStatement(sql)){
            statement.setInt(1,user.getId());
            statement.executeUpdate();
            return Constants.DATA_DELETE_MSG;

        }catch (SQLException e){
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return e.getMessage();
        }
    }
}
