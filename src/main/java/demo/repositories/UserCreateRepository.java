package demo.repositories;

import com.sun.security.jgss.GSSUtil;
import demo.db.DbConnect;
import demo.entities.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import demo.utils.*;

public class UserCreateRepository {
    private static final Logger LOGGER = Logger.getLogger(UserCreateRepository.class.getName());

    public String createContact(User user){

        String sql = "INSERT INTO " + Constants.TABLE_USERS + "(name, phone, email) VALUES (?, ?, ?)";

        try(PreparedStatement statement = DbConnect.setUpConnectionWithDB().prepareStatement(sql)){
            statement.setString(1, user.getName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        }catch (SQLException e){
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return e.getMessage();
        }
    }
}
