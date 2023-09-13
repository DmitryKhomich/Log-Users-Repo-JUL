package demo.repositories;
import demo.db.DbConnect;
import demo.entities.User;
import demo.utils.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class UserUpdateRepository {
    private static final Logger LOGGER = Logger.getLogger(UserDeleteRepository.class.getName());

    public String updateUser(User user) {

        String sql = "UPDATE " + Constants.TABLE_USERS + " SET phone = ?" + " WHERE id = ?";
        try (PreparedStatement statement = DbConnect.setUpConnectionWithDB().prepareStatement(sql)){
            statement.setString(1,user.getPhone());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
            return Constants.DATA_UPDATE_MSG;
        } catch (SQLException e){
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return e.getMessage();
        }
    }
}
