package demo.services;

import demo.entities.User;
import demo.repositories.UserCreateRepository;
import demo.repositories.UserUpdateRepository;
import demo.utils.Constants;
import demo.utils.IdValidator;
import demo.utils.PhoneValidator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserUpdateService {
    private static final Logger LOGGER = Logger.getLogger(UserCreateRepository.class.getName());
    UserUpdateRepository repository;

    public UserUpdateService(UserUpdateRepository repository) {
        this.repository = repository;
    }

    public String updateUser(String[] data){
        Map<String,String> errs = validateData(data);
        if(errs.isEmpty()){
            try {
            throw new RuntimeException("Check inputs");
            } catch (RuntimeException e){
                LOGGER.log(Level.WARNING,Constants.LOG_DATA_INPTS_WRONG_MSG);
                System.out.println(e.getMessage());
            }
        }
        return repository.updateUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {

        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);

        if (PhoneValidator.isPhoneValid(data[1]))
            errors.put("phone", Constants.WRONG_PHONE_MSG);

        return errors;
    }
    private User convertData(String[] data){
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setPhone(data[1]);
        return user;
    }
}
