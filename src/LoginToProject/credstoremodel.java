package LoginToProject;
import java.util.*;

public class credstoremodel {

    private static credstoremodel single_instance = null;
    private static HashMap<String, String> userCredentials = null;

    private credstoremodel() {

        userCredentials = new HashMap();
    }

    public static credstoremodel getInstance() {
        if (single_instance == null) {
            single_instance = new credstoremodel();
        }
        return single_instance;
    }

    public HashMap<String, String> getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(HashMap<String, String> userCredentials) {
        this.userCredentials = userCredentials;
    }


    public void addUserCredentials(String userName, String password) {
        userCredentials.put(userName, password);
    }



    public String getUserPassword(String userName) {
        return userCredentials.get(userName);
    }

}


