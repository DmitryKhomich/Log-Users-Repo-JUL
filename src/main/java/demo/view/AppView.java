package demo.view;

import demo.utils.AppStarter;
import demo.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {

    Scanner scanner;

    int choice;

    public int chooseOption(){
        scanner = new Scanner(System.in);
        showMenu();
        try{
            choice = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println(Constants.INCORRECT_VALUE_MSG);
            AppStarter.runThisApp();
        }
        return choice;
    }

    private void showMenu() {
        System.out.print("""
                
                >>>>>MENU<<<<<
                1 - Create user.
                2 - View users.
                3 - Update the user's phone number.
                4 - Delete user.
                0 - Close the App.
                """);
    }

    public void getOutput(int choice, String out){
        if(choice == 0){
            System.out.println(out);
        }
        scanner.close();
        System.exit(0);
    }
}
