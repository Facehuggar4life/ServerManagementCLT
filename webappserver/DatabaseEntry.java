package webappserver;

import java.util.Arrays;
import java.util.HashMap;
import Password.Encryption;

public class DatabaseEntry {
    HashMap<String, String> passwordUsernameMap = new HashMap<>();
    HashMap<String, PasswordData> passwordDataMap = new HashMap<>();
    Encryption instanceOfPasswordEncryption= new Encryption();
    public void enterToHashMaps(String enteredUsername, String enteredPassword) {
        if (!passwordUsernameMap.containsKey(enteredUsername)) {
            String encryptedPassword = instanceOfPasswordEncryption.encryptString(enteredPassword);
            PasswordData userPasswordData = new  PasswordData(instanceOfPasswordEncryption.getKey(), instanceOfPasswordEncryption.getIndex());
            passwordUsernameMap.put(enteredUsername, encryptedPassword);
            passwordDataMap.put(enteredUsername, userPasswordData);
            int[] test = passwordDataMap.get(enteredUsername).returnKey();
        } else {
            System.out.println("This username already exists. Please choose another");
        }
    }

    public void readFromHashMaps(String enteredUserName, String enteredPassword) {
        String encryptedPassword = passwordUsernameMap.get(enteredUserName);
        if(passwordDataMap.containsKey(enteredUserName)) {
            int[] encryptionKey = passwordDataMap.get(enteredUserName).returnKey();
            int encryptionIndex = passwordDataMap.get(enteredUserName).returnIndex();
            if (passwordUsernameMap.containsKey(enteredUserName) && instanceOfPasswordEncryption.decryptString(encryptedPassword, encryptionKey, encryptionIndex).equals(enteredPassword)) {
                System.out.println("You have been successfully logged on.");
            } else {
                System.out.println("The password username combo did not exist");
            }
        }
        else{
            System.out.println("The password username combo did not exist");
        }
    }
}
