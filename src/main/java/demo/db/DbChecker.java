package demo.db;
import demo.utils.*;
import java.io.File;

public class DbChecker {

    public static boolean isDBExist(){
        return new File(Constants.DB_BASE_URL + Constants.DB_NAME).exists();
    }
}
