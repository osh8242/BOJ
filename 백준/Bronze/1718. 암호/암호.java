import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] phrase = br.readLine().toCharArray();
        char[] key = br.readLine().toCharArray();
        for (int i = 0; i < key.length; i++) key[i] -= 96;
        for (int i = 0; i < phrase.length; i++) {
            if(phrase[i] == ' ') continue;
            int index = i % key.length;
            char newChar = (char) (phrase[i] - key[index]);
            phrase[i] = newChar < 97 ? (char) (newChar + 26) : newChar;
        }
        System.out.println(new String(phrase));
    }
}
