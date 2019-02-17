package webappserver;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author owena
 */
public class Input {
    String inPassword;
    String inUser;
    String inConfirmPass;
    SaveFunction S = new SaveFunction();
    private boolean equal;
    boolean collecting = true;
    private String modeSelect;
    private final DatabaseEntry data;
    Input(DatabaseEntry data) {
        this.data = data;
    }
    Scanner inTest = new Scanner(System.in);
    public void dataCollection() {
	while(collecting == true){
        System.out.println("Select mode.");
        modeSelect = inTest.nextLine();
        switch (modeSelect.toLowerCase()) {
            case "done":
                collecting = false;
                break;
            case "entry":
                equal = false;
                while (!equal) {
                    System.out.println("Enter username");
                    inUser = inTest.nextLine();
                    System.out.println("Enter password");
                    inPassword = inTest.nextLine();
                    System.out.println("Confirm Pass");
                    inConfirmPass = inTest.nextLine();
                    if (inPassword.equals(inConfirmPass)) {
                        equal = true;
                    } else {
                        equal = false;
                        System.out.println("Your passwords did not match. Please re-enter.");
                    }
                }
                data.enterToHashMaps(inUser, inPassword);
                break;
            case "login":
                System.out.println("Please enter your username");
                inUser = inTest.nextLine();
                System.out.println("Please enter your password");
                inPassword = inTest.nextLine();
                data.readFromHashMaps(inUser, inPassword);
                break;
            case "save":
                System.out.println("Please enter the name of the file you wish to create for Users and Encrypted Passwords");
                String fileForHashMapSaveUserPass = inTest.nextLine();
                System.out.println("Please enter the name of the file you wish to create for Password Keys \n(It is recommended you store this file on a remote machine with an innocuous name)");
                String fileforHashMapSavePassData = inTest.nextLine();
                try {
                    S.writeFileUserPass(data.passwordUsernameMap, fileForHashMapSaveUserPass);
                    S.writeFilePassData(data.passwordDataMap, fileforHashMapSavePassData);
                } catch (IOException e) {
                     System.out.println("Something went wrong. Please ensure the file name you choose was valid.");
                }
                break;
            case "backup":
                System.out.println("Choose the file you wish to read Usernames and Passwords from");
                String fileForHashMapRestorationUserPass = inTest.nextLine();
                System.out.println("Choose the file you wish to read password encryption data from");
                String fileForHashMapRestorationPassData = inTest.nextLine();
                try{
                    data.passwordUsernameMap = S.backupFileUser(fileForHashMapRestorationUserPass);
                    data.passwordDataMap = S.backupFileData(fileForHashMapRestorationPassData);
                }
                catch(IOException e){
                    System.out.println("It seems the file you choose does not exist. Check to make sure you entered it correctly along with the full file path.");
                }
                break;
            case "clear":
                System.out.println("Please be warned this will eliminate all data. Deleted data can only be restored by backing up to a saved database.");
                modeSelect = inTest.nextLine();
                if(modeSelect.equalsIgnoreCase("yes") || modeSelect.equalsIgnoreCase("Y")){
                    data.passwordUsernameMap.clear();
                    data.passwordDataMap.clear();
                    System.out.println("Both HashMaps have been absolutely obliterated. Hope you're happy.");
                }
                else{
                    System.out.println("The deletion has been aborted.");
                }
     		}
	   }
    }
}
