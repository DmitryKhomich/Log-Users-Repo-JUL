package demo.view;

import java.util.Scanner;

public class UserCreateView {

    public String[] getData(){
        Scanner scanner = new Scanner(System.in);

        String title = "Enter name: ";
        System.out.println(title);
        String name = scanner.nextLine();
        title = "Enter phone in format xxx xxx-xxxx: ";
        System.out.println(title);
        String phone = scanner.nextLine();
        title = "Enter email: ";
        System.out.println(title);
        String email = scanner.nextLine();

        return new String[] {name,phone,email};
    }

    public void getOutput(String out){
        System.out.println(out);
    }
}
