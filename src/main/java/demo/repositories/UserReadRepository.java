package demo.repositories;

import demo.db.DbConnect;
import demo.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import demo.utils.*;

public class UserReadRepository {

    private static final Logger LOGGER = Logger.getLogger(UserReadRepository.class.getName());

    public List<User> readUsers(){

        try(Statement statement = DbConnect.setUpConnectionWithDB().createStatement()){

            List<User> list = new ArrayList<>();
            String sql = "SELECT * FROM " + Constants.TABLE_USERS;
            ResultSet set = statement.executeQuery(sql);
            while(set.next()){
                User user = new User();
                user.setId(set.getInt("id"));
                user.setName(set.getString("name"));
                user.setPhone(set.getString("phone"));
                user.setEmail(set.getString("email"));
                list.add(user);
            }
            return list;

        }catch (SQLException e){
            LOGGER.log(Level.WARNING, Constants.LOG_DB_ERROR_MSG);
            return Collections.emptyList();
        }
    }
}
