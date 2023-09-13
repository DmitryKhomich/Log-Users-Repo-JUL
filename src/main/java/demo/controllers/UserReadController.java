package demo.controllers;

import demo.services.UserReadService;
import demo.utils.AppStarter;
import demo.utils.Constants;
import demo.view.UserReadView;

public class UserReadController {

    UserReadService service;
    UserReadView view;

    public UserReadController(UserReadService service, UserReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readUser(){
        String str = service.readUsers();
        if(str.equals(Constants.DB_ABSENT_MSG)){
            view.getOutput(str);
            System.exit(0);
        } else {
            view.getOutput(str);
            AppStarter.runThisApp();
        }
    }
}
