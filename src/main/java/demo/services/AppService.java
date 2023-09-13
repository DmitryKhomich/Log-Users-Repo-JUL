package demo.services;

import demo.controllers.UserCreateController;
import demo.controllers.UserDeleteController;
import demo.controllers.UserReadController;
import demo.controllers.UserUpdateController;
import demo.repositories.UserCreateRepository;
import demo.repositories.UserDeleteRepository;
import demo.repositories.UserReadRepository;
import demo.repositories.UserUpdateRepository;
import demo.utils.AppStarter;
import demo.utils.Constants;
import demo.view.*;

public class AppService {

    public void create(){
        UserCreateRepository repository = new UserCreateRepository();
        UserCreateService service = new UserCreateService(repository);
        UserCreateView view = new UserCreateView();
        UserCreateController controller = new UserCreateController(service,view);
        controller.createUser();
    }
    public void delete(){
        UserDeleteRepository repository = new UserDeleteRepository();
        UserDeleteService service = new UserDeleteService(repository);
        UserDeleteView view = new UserDeleteView();
        UserDeleteController controller = new UserDeleteController(service,view);
        controller.deleteUser();
    }

    public void read(){
        UserReadRepository repository = new UserReadRepository();
        UserReadService service = new UserReadService(repository);
        UserReadView view = new UserReadView();
        UserReadController controller = new UserReadController(service,view);
        controller.readUser();
    }

    public void update(){
        UserUpdateRepository repository = new UserUpdateRepository();
        UserUpdateService service = new UserUpdateService(repository);
        UserUpdateView view = new UserUpdateView();
        UserUpdateController controller = new UserUpdateController(service,view);
        controller.updateUser();
    }

    public void getNoSuchOption(int choice) {
        int[] menuChoices = {0, 1, 2, 3, 4};
        if (!contains(menuChoices, choice)) {
            try {
                throw new RuntimeException(Constants.INCORRECT_VALUE_MSG);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                AppStarter.runThisApp();
            }
        }
    }

    public static boolean contains(final int[] options, final int value) {
        boolean result = false;
        for (int i : options) {
            if (i == value) {
                result = true;
                break;
            }
        }
        return result;
    }
}
