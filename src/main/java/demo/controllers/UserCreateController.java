package demo.controllers;

import demo.services.UserCreateService;
import demo.utils.AppStarter;
import demo.utils.Constants;
import demo.view.UserCreateView;

public class UserCreateController {
    UserCreateService service;
    UserCreateView view;

    public UserCreateController(UserCreateService service, UserCreateView view) {
        this.service = service;
        this.view = view;
    }

    public void createUser(){
        String str = service.createUsr(view.getData());
        if(str.equals(Constants.DB_ABSENT_MSG)){
            view.getOutput(str);
            System.exit(0);
        }else{
            view.getOutput(str);
            AppStarter.runThisApp();
        }
    }
}
