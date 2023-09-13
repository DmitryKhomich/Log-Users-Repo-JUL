package demo.services;
import demo.entities.User;
import demo.repositories.UserCreateRepository;
import demo.repositories.UserDeleteRepository;
import demo.utils.Constants;
import demo.utils.IdChecker;
import demo.utils.IdValidator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDeleteService {
    private static final Logger LOGGER = Logger.getLogger(UserCreateRepository.class.getName());
    UserDeleteRepository repository;

    public UserDeleteService(UserDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteUser(String[] data){

        Map<String,String> errs = validateData(data);
        if(errs.isEmpty()){
            LOGGER.log(Level.WARNING,Constants.LOG_DB_ABSENT_MSG);
            throw new RuntimeException("Check inputs");
        }
        return repository.deleteUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);
        if(IdChecker.isProvidedIdValid(Integer.parseInt(data[0])))
            errors.put("id", Constants.ID_NO_EXISTS_MSG);
        return errors;
    }

    private User convertData(String[] data){
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}
