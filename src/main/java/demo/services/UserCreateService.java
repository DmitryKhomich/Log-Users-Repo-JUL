package demo.services;

import demo.db.DbChecker;
import demo.entities.User;
import demo.repositories.UserCreateRepository;
import demo.utils.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserCreateService {

    private static final Logger LOGGER = Logger.getLogger(UserCreateRepository.class.getName());
    UserCreateRepository userCreateRepository;

    public UserCreateService(UserCreateRepository userCreateRepository) {
        this.userCreateRepository = userCreateRepository;
    }

    public String createUsr(String[] data){

        if(!DbChecker.isDBExist()){
            try{
                throw new RuntimeException(Constants.DB_ABSENT_MSG);
            }catch (Exception e){
                LOGGER.log(Level.WARNING,Constants.LOG_DB_ABSENT_MSG);
            }
        }

        Map<String, String> errors = validateData(data);

        if(!errors.isEmpty()){
            try{
                throw new RuntimeException("Check inputs");
            } catch (RuntimeException e){
                LOGGER.log(Level.WARNING, Constants.LOG_DATA_INPTS_WRONG_MSG);
            }
        }

        return userCreateRepository.createContact(converterArrayToObj(data));
    }

    private Map<String,String> validateData(String[] data){
        Map<String,String> errors = new HashMap<>();
        if(data[0].trim().isEmpty())
            errors.put("name", Constants.INPUT_REQ_MSG);
        if(PhoneValidator.isPhoneValid(data[1]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);
        if(EmailValidator.isEmailValid(data[2]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);

        return errors;
    }

    private User converterArrayToObj(String[] data){
        User u = new User();
        u.setName(data[0]);
        u.setPhone(data[1]);
        u.setEmail(data[2]);
        return u;
    }
}
