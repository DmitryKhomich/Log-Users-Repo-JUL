package demo.services;

import demo.entities.User;
import demo.repositories.UserCreateRepository;
import demo.repositories.UserReadRepository;
import demo.utils.Constants;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class UserReadService {
    private static final Logger LOGGER = Logger.getLogger(UserCreateRepository.class.getName());
    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUsers(){
        List<User> usersList = repository.readUsers();
        if(usersList != null && !usersList.isEmpty()){
            AtomicInteger atomicInteger = new AtomicInteger(1);
            StringBuilder builder = new StringBuilder();
            usersList.forEach((usr) -> builder.append(atomicInteger.getAndIncrement())
                    .append(") id: ")
                    .append(usr.getId())
                    .append(", ")
                    .append(usr.getName())
                    .append(", ")
                    .append(usr.getPhone())
                    .append(", ")
                    .append(usr.getEmail())
                    .append("\n"));
            return builder.toString();
        }
        return Constants.DATA_ABSENT_MSG;
    }
}
