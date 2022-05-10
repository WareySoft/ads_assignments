import java.io.*;

public class StrCode {
    private char[] s;
    private final int length;

    public StrCode(String word){
        this.length = word.length();
        s = new char[length];
        for (int i = 0; i < word.length(); i++) {
            s[i] = word.charAt(i);
        }
    }

    public int hashCodeOfString(){
        int[] arraycode = new int[length];
        int hash = 0;

        for (int i = 0; i < length; i++) {
            int ascii = s[i];
            arraycode[i] = ascii;
        }
        for (int i = 0; i < length; i++) {
            hash = arraycode[i] + (31 * hash);
        }
        return hash;
    }
}
