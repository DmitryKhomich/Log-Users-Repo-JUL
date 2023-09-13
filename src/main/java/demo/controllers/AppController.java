package demo.controllers;

import demo.services.AppService;
import demo.utils.Constants;
import demo.view.AppView;

public class AppController {
    AppView view;
    AppService service;

    public AppController(AppView view, AppService service) {
        this.view = view;
        this.service = service;
    }

    public void run(){
        filterChoice(view.chooseOption());
    }

    private void filterChoice(int choice) {
        switch (choice) {
            case 1 -> service.create();
            case 2 -> service.read();
            case 3 -> service.update();
            case 4 -> service.delete();
            case 0 -> view.getOutput(choice, Constants.APP_CLOSE_MSG);
            default -> service.getNoSuchOption(choice);
        }
    }
}
