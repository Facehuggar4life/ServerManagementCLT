package Password;

import java.util.Random;

public class Encryption {
    /*
    *   "Encryption" is performed to a string by generating an integer array bassed off the given string.
    *A random key array of 16 digits is also generated. This key can be added to the original int array
    *which in turn is converted back into a string. The "decrypt" method simply does the same thing,
    *except it subtracts the key from the generated array. This should return the decrypted array.
    *   *Note:* at the bottom of the switch statements that convert the pass[] into a string
    *there is an empty case. This is necessary because of the way Modular Arithmetic works 
    *(for those interested, in mod arithemetic, 0 is equivalent to the max value (In this program 63), 
    *since 0 is assigned in the switch statements, the mod cannot also be a character); 
    *if you want a functional program, do not remove this!
    */
    int[] key;
    int index;
    public String encryptString(String password) {
        Random keyGeneration = new Random();
        key = new int[15];
        index = keyGeneration.nextInt(15+1);//value between 0 -16
        for (int gna = 0; gna < 15; gna++) {
            key[gna] = keyGeneration.nextInt(50);
        }
        int[] pass = getPassArr(password);
        int v=index;
        for (int i = 0; i < password.length(); i++) {
            if(v>=15){
                v=0;
            }
            pass[i] = ((pass[i] + key[v]) % 71);
            v++;
        }
        password = getPassString(pass, password);
        return password;
    }
    public String decryptString(String password, int[] key, int index) {
        int[] pass = getPassArr(password);
        int v =index;
        for (int i = 0; i < password.length(); i++) {
            if(v >=15){
                v=0;
            }
            pass[i] = (Math.floorMod(pass[i] - key[v], 71));
            v++;
        }
        password = getPassString(pass, password);
        return password;
    }
    public String encryptWKey(String password, int[] key, int index) {
        int[] pass = getPassArr(password);
        int v=index;
        for (int i = 0; i < password.length(); i++) {
            if(v>=16){
                v=0;
            }
            pass[i] = ((pass[i] + key[v]) % 71);
            v++;
        }
        password = getPassString(pass, password);
        return password;
    }
    private int[] getPassArr(String password){
        int[] pass = new int[password.length()];
        for (int i = 0; i < password.length(); i++) {
            switch (password.charAt(i)) {
                case 'a':
                    pass[i] = 0;
                    break;
                case 'b':
                    pass[i] = 1;
                    break;
                case 'c':
                    pass[i] = 2;
                    break;
                case 'd':
                    pass[i] = 3;
                    break;
                case 'e':
                    pass[i] = 4;
                    break;
                case 'f':
                    pass[i] = 5;
                    break;
                case 'g':
                    pass[i] = 6;
                    break;
                case 'h':
                    pass[i] = 7;
                    break;
                case 'i':
                    pass[i] = 8;
                    break;
                case 'j':
                    pass[i] = 9;
                    break;
                case 'k':
                    pass[i] = 10;
                    break;
                case 'l':
                    pass[i] = 11;
                    break;
                case 'm':
                    pass[i] = 12;
                    break;
                case 'n':
                    pass[i] = 13;
                    break;
                case 'o':
                    pass[i] = 14;
                    break;
                case 'p':
                    pass[i] = 15;
                    break;
                case 'q':
                    pass[i] = 16;
                    break;
                case 'r':
                    pass[i] = 17;
                    break;
                case 's':
                    pass[i] = 18;
                    break;
                case 't':
                    pass[i] = 19;
                    break;
                case 'u':
                    pass[i] = 20;
                    break;
                case 'v':
                    pass[i] = 21;
                    break;
                case 'w':
                    pass[i] = 22;
                    break;
                case 'x':
                    pass[i] = 23;
                    break;
                case 'y':
                    pass[i] = 24;
                    break;
                case 'z':
                    pass[i] = 25;
                    break;
                case 'A':
                    pass[i] = 26;
                    break;
                case 'B':
                    pass[i] = 27;
                    break;
                case 'C':
                    pass[i] = 28;
                    break;
                case 'D':
                    pass[i] = 29;
                    break;
                case 'E':
                    pass[i] = 30;
                    break;
                case 'F':
                    pass[i] = 31;
                    break;
                case 'G':
                    pass[i] = 32;
                    break;
                case 'H':
                    pass[i] = 33;
                    break;
                case 'I':
                    pass[i] = 34;
                    break;
                case 'J':
                    pass[i] = 35;
                    break;
                case 'K':
                    pass[i] = 36;
                    break;
                case 'L':
                    pass[i] = 37;
                    break;
                case 'M':
                    pass[i] = 38;
                    break;
                case 'N':
                    pass[i] = 39;
                    break;
                case 'O':
                    pass[i] = 40;
                    break;
                case 'P':
                    pass[i] = 41;
                    break;
                case 'Q':
                    pass[i] = 42;
                    break;
                case 'R':
                    pass[i] = 43;
                    break;
                case 'S':
                    pass[i] = 44;
                    break;
                case 'T':
                    pass[i] = 45;
                    break;
                case 'U':
                    pass[i] = 46;
                    break;
                case 'V':
                    pass[i] = 47;
                    break;
                case 'W':
                    pass[i] = 48;
                    break;
                case 'X':
                    pass[i] = 49;
                    break;
                case 'Y':
                    pass[i] = 50;
                    break;
                case 'Z':
                    pass[i] = 51;
                    break;
                case '0':
                    pass[i] = 52;
                    break;
                case '1':
                    pass[i] = 53;
                    break;
                case '2':
                    pass[i] = 54;
                    break;
                case '3':
                    pass[i] = 55;
                    break;
                case '4':
                    pass[i] = 56;
                    break;
                case '5':
                    pass[i] = 57;
                    break;
                case '6':
                    pass[i] = 58;
                    break;
                case '7':
                    pass[i] = 59;
                    break;
                case '8':
                    pass[i] = 60;
                    break;
                case '9':
                    pass[i] = 61;
                    break;
                case ' ':
                    pass[i] =62;
                    break;
                case '.':
                    pass[i] = 63;
                    break;
                case '?':
                    pass[i] = 64;
                    break;
                case '!':
                    pass[i] = 65;
                    break;
                case '^':
                    pass[i] = 66;
                    break;
                case '*':
                    pass[i] = 67;
                    break;
                case ',':
                    pass[i] = 68;
                    break;
                case ';':
                    pass[i] = 69;
                    break;
                case '\'':
                    pass[i] = 70;
                    break;
            }
        }
        return pass;
    }
    private String getPassString(int[] pass, String password){
        int passwordLength = password.length();
        password = "";
        for (int i = 0; i < passwordLength; i++) {
            switch (pass[i]) {
                case 0:
                    password = password + "a";
                    break;
                case 1:
                    password = password + "b";
                    break;
                case 2:
                    password = password + "c";
                    break;
                case 3:
                    password = password + "d";
                    break;
                case 4:
                    password = password + "e";
                    break;
                case 5:
                    password = password + "f";
                    break;
                case 6:
                    password = password + "g";
                    break;
                case 7:
                    password = password + "h";
                    break;
                case 8:
                    password = password + "i";
                    break;
                case 9:
                    password = password + "j";
                    break;
                case 10:
                    password = password + "k";
                    break;
                case 11:
                    password = password + "l";
                    break;
                case 12:
                    password = password + "m";
                    break;
                case 13:
                    password = password + "n";
                    break;
                case 14:
                    password = password + "o";
                    break;
                case 15:
                    password = password + "p";
                    break;
                case 16:
                    password = password + "q";
                    break;
                case 17:
                    password = password + "r";
                    break;
                case 18:
                    password = password + "s";
                    break;
                case 19:
                    password = password + "t";
                    break;
                case 20:
                    password = password + "u";
                    break;
                case 21:
                    password = password + "v";
                    break;
                case 22:
                    password = password + "w";
                    break;
                case 23:
                    password = password + "x";
                    break;
                case 24:
                    password = password + "y";
                    break;
                case 25:
                    password = password + "z";
                    break;
                case 26:
                    password = password + "A";
                    break;
                case 27:
                    password = password + "B";
                    break;
                case 28:
                    password = password + "C";
                    break;
                case 29:
                    password = password + "D";
                    break;
                case 30:
                    password = password + "E";
                    break;
                case 31:
                    password = password + "F";
                    break;
                case 32:
                    password = password + "G";
                    break;
                case 33:
                    password = password + "H";
                    break;
                case 34:
                    password = password + "I";
                    break;
                case 35:
                    password = password + "J";
                    break;
                case 36:
                    password = password + "K";
                    break;
                case 37:
                    password = password + "L";
                    break;
                case 38:
                    password = password + "M";
                    break;
                case 39:
                    password = password + "N";
                    break;
                case 40:
                    password = password + "O";
                    break;
                case 41:
                    password = password + "P";
                    break;
                case 42:
                    password = password + "Q";
                    break;
                case 43:
                    password = password + "R";
                    break;
                case 44:
                    password = password + "S";
                    break;
                case 45:
                    password = password + "T";
                    break;
                case 46:
                    password = password + "U";
                    break;
                case 47:
                    password = password + "V";
                    break;
                case 48:
                    password = password + "W";
                    break;
                case 49:
                    password = password + "X";
                    break;
                case 50:
                    password = password + "Y";
                    break;
                case 51:
                    password = password + "Z";
                    break;
                case 52:
                    password = password + "0";
                    break;
                case 53:
                    password = password + "1";
                    break;
                case 54:
                    password = password + "2";
                    break;
                case 55:
                    password = password + "3";
                    break;
                case 56:
                    password = password + "4";
                    break;
                case 57:
                    password = password + "5";
                    break;
                case 58:
                    password = password + "6";
                    break;
                case 59:
                    password = password + "7";
                    break;
                case 60:
                    password = password + "8";
                    break;
                case 61:
                    password = password + "9";
                    break;
                case 62:
                    password = password + " ";
                    break;
                case 63:
                    password = password + ".";
                    break;
                case 64:
                    password = password + "?";
                    break;
                case 65:
                    password = password + "!";
                    break;
                case 66:
                    password = password + "^";
                    break;
                case 67:
                    password = password + "*";
                    break;
                case 68:
                    password = password + ",";
                    break;
                case 69:
                    password = password + ";";
                    break;
                case 70:
                    password = password + "'";
                    break;
                case 71:
                    break;
            }
        }
        return password;
    }
    public int[] getKey() {
        return key;
    }
    public int getIndex(){
        return index;
    }
}