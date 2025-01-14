import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < str.length / 2; i++) {
            if (str[i] != str[str.length - 1 - i]) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
    }
}