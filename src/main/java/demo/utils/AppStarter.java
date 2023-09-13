package demo.utils;

import demo.controllers.AppController;
import demo.services.AppService;
import demo.view.AppView;

public class AppStarter {
    public static void runThisApp(){
        AppService service = new AppService();
        AppView view = new AppView();
        AppController controller = new AppController(view,service);
        controller.run();
    }
}
