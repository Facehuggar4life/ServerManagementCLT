package webappserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author owena
 */
public class SaveFunction {
    public void writeFileUserPass(HashMap<String, String> UserPass, String fileName) throws IOException {
        BufferedWriter save = new BufferedWriter(new FileWriter(fileName));
        ArrayList<String> usersArrayList = new ArrayList<>(UserPass.keySet());
        ArrayList<String> passwordsArrayList = new ArrayList<>(UserPass.values());
        for (int i = 0; i < usersArrayList.size(); i++) {
            save.write(usersArrayList.get(i) + '\n');
            save.write(passwordsArrayList.get(i) + '\n');
        }
        save.close();
    }

    public void writeFilePassData(HashMap<String, PasswordData> PassData, String fileName) throws IOException {
        ArrayList<String> usersArrayList = new ArrayList<>(PassData.keySet());
        ArrayList<PasswordData> passwordDataArrayList = new ArrayList<>(PassData.values());
        BufferedWriter save = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < usersArrayList.size(); i++) {
            String username = usersArrayList.get(i);
            int[] key = passwordDataArrayList.get(i).key;
            int index = passwordDataArrayList.get(i).index;
            save.write(username + '\n');
            save.write(Arrays.toString(key) + '\n');
            save.write(String.valueOf(index) + '\n');
        }
        save.close();
    }

    public HashMap<String, String> backupFileUser(String fileName) throws IOException {
        BufferedReader Read = new BufferedReader(new FileReader(fileName));
        HashMap<String, String> passUserMirror = new HashMap<>();
        String line = Read.readLine();
        ArrayList<String> entries = new ArrayList<>();
        while (line != null) {
            entries.add(line);
            line = Read.readLine();
        }
        for (int i = 1; i <= entries.size(); i = i + 2) {
            passUserMirror.put(entries.get(i - 1), entries.get(i));
        }
        //System.out.println(entries.toString());
        return passUserMirror;
    }

    public HashMap<String, PasswordData> backupFileData(String fileName) throws IOException {
        BufferedReader Read = new BufferedReader(new FileReader(fileName));
        HashMap<String, PasswordData> passDataMirror = new HashMap<>();
        String line = Read.readLine();
        ArrayList<String> users = new ArrayList<>();
        ArrayList<int[]> keys = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        int lineNumber = 0; //The following statements can view this variable to determine which action to take with the given string
        while (line != null) {
            if (lineNumber == 0) {
                users.add(line);
            }
            if (lineNumber == 1) {
                keys.add(convertLineToArr(line));
            }
            if (lineNumber == 2) {
                indexes.add(Integer.parseInt(line));
            }
            line = Read.readLine();
            lineNumber = (lineNumber + 1) % 3;

        }
        for (int i = 0; i < users.size(); i++) {
            passDataMirror.put(users.get(i), new PasswordData(keys.get(i), indexes.get(i)));
        }
        return passDataMirror;
    }

    private int[] convertLineToArr(String line) {
        int[] readFileArr = new int[15];
        int arrayIndexing = 0; //i in the upcoming for statement will be added to in every loop of the
        // statement regardless of if array is added to. Therefore, we must have variable for array indexing
        // that is added to only when a value in the array is set
        for (int i = 0; i < line.length(); i++) {
            int lastCharacterIndex = line.indexOf(']');
            if (line.charAt(i) == ',') {
                if (i - 4 >= 0) {//This prevents referencing string indexes that don't exist
                    if (line.charAt(i - 3) == ',') {
                        readFileArr[arrayIndexing] = Integer.parseInt(line.substring(i - 1, i));
                        arrayIndexing++;
                    } else if (line.charAt(i - 4) == ',') {
                        readFileArr[arrayIndexing] = Integer.parseInt(line.substring(i - 2, i));
                        arrayIndexing++;
                    }
                }
                if (i + 3 <= lastCharacterIndex) { //This prevents referencing string indexes that don't exist
                    if (line.charAt(i + 3) == ']') {
                        readFileArr[arrayIndexing] = Integer.parseInt(line.substring(i + 2, i + 3));
                        arrayIndexing++;
                    } else if (line.charAt(i + 4) == ']') {
                        readFileArr[arrayIndexing] = Integer.parseInt(line.substring(i + 2, i + 4));
                        arrayIndexing++;
                    }
                }
                i++; //If the current character is a ',', the next is guaranteed to be a space. This can be skipped to improve efficiency
            }
            if (i == 0) {
                if (line.charAt(i + 2) == ',') {
                    readFileArr[arrayIndexing] = Integer.parseInt(line.substring(i + 1, i + 2));
                    arrayIndexing++;
                }
                if (line.charAt(i + 3) == ',') {
                    readFileArr[arrayIndexing] = Integer.parseInt(line.substring(i + 1, i + 3));
                    arrayIndexing++;
                }
            }
        }
        return readFileArr;
    }

}

